package com.kabum.adapter.listener;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.kabum.application.NotificationServicePort;
import com.kabum.domain.Notificar;
import com.kabum.domain.Registro;
import com.kabum.domain.RegistroRepository;

@Component
public class NotificarListener {
	
	private static final Logger LOG = LoggerFactory.getLogger(NotificarListener.class);

	private RegistroRepository registroRepository;
	private NotificationServicePort notificationServicePort;

	public NotificarListener(RegistroRepository registroRepository, NotificationServicePort notificationServicePort) {
		this.registroRepository = registroRepository;
		this.notificationServicePort = notificationServicePort;
	}

	@EventListener
	public void notificarUsuario(Notificar command) {
		
		Optional<Registro> contemRegistro = registroRepository.findByProdutoAndValor(
				command.getProduto(),
				command.getValor());

		if (contemRegistro.isPresent()) 
			return;
		
		LOG.info("Notificando " + command.getProduto() + " com o valor: " + command.getValor());
		
		notificationServicePort.notificar(command.getCelular(), command.getMsg());

	}

}
