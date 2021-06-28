package com.kabum.application;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.kabum.adapter.web.KabumDto;
import com.kabum.domain.KabumObjectRepository;

@Component
public class Service {

	private KabumObjectRepository kabumObjectRepository;

	public Service(KabumObjectRepository kabumObjectRepository) {
		this.kabumObjectRepository = kabumObjectRepository;
	}

	public UUID criarMonitoramento(KabumDto dto) {
		return kabumObjectRepository.save(dto);
	}

}
