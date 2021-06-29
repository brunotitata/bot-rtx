package com.kabum.adapter.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kabum.domain.Agendador;

public interface AgendadorRepositorySpringData extends JpaRepository<Agendador, UUID> {

}
