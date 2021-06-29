package com.kabum.domain;

import java.util.List;
import java.util.UUID;

import com.kabum.adapter.web.KabumDto;

public interface AgendadorRepository {

	UUID save(KabumDto object);

	List<Agendador> all();

}
