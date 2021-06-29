package com.kabum.adapter.listener;

import java.util.Optional;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.kabum.domain.Registro;
import com.kabum.domain.RegistroRepository;

@Component
public class RegistroListener {

	private RegistroRepository registroRepository;

	public RegistroListener(RegistroRepository registroRepository) {
		this.registroRepository = registroRepository;
	}

	@EventListener
	public void execute(Registro command) {

		Optional<Registro> contemRegistro = registroRepository.findByProdutoAndValor(
				command.getProduto(),
				command.getValor());

		if (contemRegistro.isPresent()) {
			return;
		}

		registroRepository.save(command);

	}

}
