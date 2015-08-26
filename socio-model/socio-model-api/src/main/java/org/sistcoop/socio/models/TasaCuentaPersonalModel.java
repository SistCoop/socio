package org.sistcoop.socio.models;

import java.math.BigDecimal;

public interface TasaCuentaPersonalModel extends Model {

    String getId();

    String getDenominacion();

    void setDenominacion(String denominacion);

    BigDecimal getValor();

    void setValor(BigDecimal valor);

    CuentaPersonalModel getCuentaPersonal();

}
