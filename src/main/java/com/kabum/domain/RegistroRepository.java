package com.kabum.domain;

import java.math.BigDecimal;
import java.util.Optional;

public interface RegistroRepository {

	void save(Registro registro);

	Optional<Registro> findByProdutoAndValorAndCelular(String produto, BigDecimal valor, String celular);

}
