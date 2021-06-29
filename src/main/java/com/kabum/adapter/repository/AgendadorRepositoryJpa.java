package com.kabum.adapter.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.kabum.adapter.web.KabumDto;
import com.kabum.domain.Agendador;
import com.kabum.domain.AgendadorRepository;

@Repository
public class AgendadorRepositoryJpa implements AgendadorRepository {

	private AgendadorRepositorySpringData springData;

	public AgendadorRepositoryJpa(AgendadorRepositorySpringData springData) {
		this.springData = springData;
	}

	@Override
	public UUID save(KabumDto object) {
		
		Agendador obj = springData.save(new Agendador(UUID.randomUUID(), object.getChave(), object.getValorMaximo(), object.getCelular()));

		return obj.getId();
	}

	@Override
	public List<Agendador> all() {
		return springData.findAll();
	}

}
