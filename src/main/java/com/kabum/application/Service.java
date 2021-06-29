package com.kabum.application;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.kabum.adapter.web.KabumDto;
import com.kabum.domain.AgendadorRepository;

@Component
public class Service {

	private AgendadorRepository kabumObjectRepository;

	public Service(AgendadorRepository kabumObjectRepository) {
		this.kabumObjectRepository = kabumObjectRepository;
	}

	public UUID criarMonitoramento(KabumDto dto) {
		return kabumObjectRepository.save(dto);
	}

}
