package org.sistcoop.socio.models;

import java.math.BigDecimal;
import java.util.Date;

public interface CuentaPersonalInteresGeneradoModel extends Model {

	Long getId();

	CuentaPersonalModel getCuentaPersonal();

	BigDecimal getCapital();

	BigDecimal getInteresGenerado();

	Date getFecha();

}
