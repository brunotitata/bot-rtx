package com.kabum.adapter.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kabum.domain.KabumObject;

public interface KabumObjectRepositorySpringData extends JpaRepository<KabumObject, UUID> {

}
