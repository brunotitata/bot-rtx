package com.kabum.application;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kabum.adapter.http.KabumResources;
import com.kabum.adapter.web.KabumDto;
import com.kabum.domain.KabumObjectRepository;

@Component
@EnableScheduling
public class Schedule {

	private static final Logger LOG = LoggerFactory.getLogger(Schedule.class);

	private KabumServicePort kabumServicePort;
	private AwsServicePort awsServicePort;
	private KabumObjectRepository repository;
	private ObjectMapper objectMapper;

	public Schedule(KabumServicePort kabumServicePort, AwsServicePort awsServicePort, KabumObjectRepository repository,
			ObjectMapper objectMapper) {
		this.kabumServicePort = kabumServicePort;
		this.awsServicePort = awsServicePort;
		this.repository = repository;
		this.objectMapper = objectMapper;
	}

	@Scheduled(fixedDelay = 30000)
	public void executar() {

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
					
					awsServicePort.notificar(p.getCelular(), produto.getNomeDaPlaca() + "\n" + produto.getPrecoVista() + "\n" + produto.getLink());
				}

			});

		});

	}

}
