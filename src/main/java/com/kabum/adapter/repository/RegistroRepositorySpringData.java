package com.kabum.adapter.repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kabum.domain.Registro;

public interface RegistroRepositorySpringData extends JpaRepository<Registro, UUID> {

	Optional<Registro> findByProdutoAndValorAndCelular(String produto, BigDecimal valor, String celular);

}
