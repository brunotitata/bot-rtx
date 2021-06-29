package com.kabum.domain;

import java.math.BigDecimal;
import java.util.Optional;

public interface RegistroRepository {

	void save(Registro registro);

	Optional<Registro> findByProdutoAndValor(String produto, BigDecimal valor);

}
