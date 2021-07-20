package com.kabum.adapter.listener;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.kabum.domain.Registro;
import com.kabum.domain.RegistroRepository;

@Component
public class RegistroListener {

	private static final Logger LOG = LoggerFactory.getLogger(RegistroListener.class);

	private RegistroRepository registroRepository;

	public RegistroListener(RegistroRepository registroRepository) {
		this.registroRepository = registroRepository;
	}

	@EventListener
	public void registrarProduto(Registro command) {

		Optional<Registro> contemRegistro = registroRepository.findByProdutoAndValorAndCelular(
				command.getProduto(),
				command.getValor(),
				command.getCelular());

		if (contemRegistro.isPresent())
			return;
		
		LOG.info("Registrando " + command.getProduto() + " com valor: " + command.getValor());

		registroRepository.save(command);

	}

}
