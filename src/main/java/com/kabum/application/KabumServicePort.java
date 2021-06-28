package com.kabum.application;

import java.util.List;

import com.kabum.adapter.http.KabumResources;
import com.kabum.adapter.web.KabumDto;

public interface KabumServicePort {
	
	List<KabumResources> listaDeProdutos(KabumDto dto);

}
