package com.kabum.adapter.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.kabum.adapter.web.KabumDto;
import com.kabum.domain.KabumObject;
import com.kabum.domain.KabumObjectRepository;

@Repository
public class KabumObjectRepositoryJpa implements KabumObjectRepository {

	private KabumObjectRepositorySpringData springData;

	public KabumObjectRepositoryJpa(KabumObjectRepositorySpringData springData) {
		this.springData = springData;
	}

	@Override
	public UUID save(KabumDto object) {
		
		KabumObject obj = springData.save(new KabumObject(UUID.randomUUID(), object.getChave(), object.getValorMaximo(), object.getCelular()));

		return obj.getId();
	}

	@Override
	public List<KabumObject> all() {
		return springData.findAll();
	}

}
