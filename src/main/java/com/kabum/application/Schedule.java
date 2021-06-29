package com.kabum.application;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kabum.adapter.http.KabumResources;
import com.kabum.adapter.web.KabumDto;
import com.kabum.domain.AgendadorRepository;
import com.kabum.domain.Notificar;
import com.kabum.domain.Registro;

@Component
@EnableScheduling
public class Schedule {

	private static final Logger LOG = LoggerFactory.getLogger(Schedule.class);

	private KabumServicePort kabumServicePort;
	private AgendadorRepository repository;
	private ObjectMapper objectMapper;
	private ApplicationEventPublisher applicationEventPublisher;

	public Schedule(KabumServicePort kabumServicePort, AgendadorRepository repository, ObjectMapper objectMapper,
			ApplicationEventPublisher applicationEventPublisher) {
		this.kabumServicePort = kabumServicePort;
		this.repository = repository;
		this.objectMapper = objectMapper;
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Scheduled(fixedDelay = 30000)
	public void executar() {

		LOG.info("Executando scheduled...");
		
		repository.all().forEach(p -> {

			List<KabumResources> listaDeProdutos = kabumServicePort
					.listaDeProdutos(
							new KabumDto(
									p.getProduto(), 
									p.getValorMaximo(), 
									p.getCelular()));

			listaDeProdutos.forEach(produto -> {

				BigDecimal precoVista = produto.getPrecoVista();

				if (precoVista.compareTo(p.getValorMaximo()) == -1) {

					try {
						LOG.info("Produto encontrado... " + objectMapper.writeValueAsString(produto));
					} catch (JsonProcessingException e) {
						throw new RuntimeException(e.getMessage());
					}
					
					applicationEventPublisher.publishEvent(
							new Registro(
									UUID.randomUUID(), 
									produto.getNomeDaPlaca(), 
									produto.getPrecoVista(),
									produto.getLink(), 
									LocalDateTime.now()));
					
					applicationEventPublisher.publishEvent(
							new Notificar(
									p.getCelular(), 
									produto.getNomeDaPlaca() + "\n" + produto.getPrecoVista() + "\n" + produto.getLink(),
									produto.getNomeDaPlaca(),
									produto.getPrecoVista(),
									produto.getLink()));
				}

			});

		});

	}

}
