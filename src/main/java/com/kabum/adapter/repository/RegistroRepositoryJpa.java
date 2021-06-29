package com.kabum.adapter.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kabum.domain.Registro;
import com.kabum.domain.RegistroRepository;

@Repository
public class RegistroRepositoryJpa implements RegistroRepository {

	private RegistroRepositorySpringData repository;

	public RegistroRepositoryJpa(RegistroRepositorySpringData repository) {
		this.repository = repository;
	}

	@Override
	public void save(Registro registro) {
		repository.save(registro);

	}

	@Override
	public Optional<Registro> findByProdutoAndValor(String produto, BigDecimal valor) {
		return repository.findByProdutoAndValor(produto, valor);
	}

}
