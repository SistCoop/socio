package org.sistcoop.socio.models;

import java.math.BigDecimal;
import java.util.Date;

public interface InteresGeneradoCuentaPersonalModel extends Model {

    String getId();

    CuentaPersonalModel getCuentaPersonal();

    BigDecimal getCapital();

    BigDecimal getInteresGenerado();

    Date getFecha();

}
