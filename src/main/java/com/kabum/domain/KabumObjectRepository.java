package com.kabum.domain;

import java.util.List;
import java.util.UUID;

import com.kabum.adapter.web.KabumDto;

public interface KabumObjectRepository {

	UUID save(KabumDto object);

	List<KabumObject> all();

}
