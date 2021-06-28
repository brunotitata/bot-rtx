package com.kabum.adapter.web;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kabum.application.Service;

@RestController
@RequestMapping("/v1")
public class KabumController {

	private Service service;

	public KabumController(Service service) {
		this.service = service;
	}
	
	@PostMapping("/criar")
	public ResponseEntity<UUID> criarAgendador(@RequestBody KabumDto dto) {
		
		UUID id = service.criarMonitoramento(dto);
		
		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(id)
				.toUri())
				.build();
	}

}
