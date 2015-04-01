package org.sistcoop.socio.models;

import java.math.BigDecimal;

public interface CuentaPersonalTasaModel extends Model {

	Long getId();

	String getDenominacion();

	void setDenominacion();

	BigDecimal getValor();

	void setValor(BigDecimal valor);

	CuentaPersonalModel getCuentaPersonal();

}
