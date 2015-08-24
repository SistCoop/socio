package org.sistcoop.socio.models;

import java.math.BigDecimal;
import org.sistcoop.socio.models.enums.EstadoCuentaAporte;

public interface CuentaAporteModel extends Model {

    String getId();

    String getNumeroCuenta();

    BigDecimal getSaldo();

    void setSaldo(BigDecimal saldo);

    String getMoneda();

    EstadoCuentaAporte getEstado();

    void setEstado(EstadoCuentaAporte estadoCuenta);

}
