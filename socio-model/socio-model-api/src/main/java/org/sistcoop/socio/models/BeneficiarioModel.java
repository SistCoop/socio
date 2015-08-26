package org.sistcoop.socio.models;

import java.math.BigDecimal;

public interface BeneficiarioModel extends Model {

    String getId();

    BigDecimal getPorcentajeBeneficio();

    void setPorcentajeBeneficio(BigDecimal porcentajeBeneficiario);

    String getTipoDocumento();

    void setTipoDocumento(String tipoDocumento);

    String getNumeroDocumento();

    void setNumeroDocumento(String numeroDocumento);

    String getApellidoPaterno();

    void setApellidoPaterno(String apellidoPaterno);

    String getApellidoMaterno();

    void setApellidoMaterno(String apellidoMaterno);

    String getNombres();

    void setNombres(String nombres);

    CuentaPersonalModel getCuentaPersonal();

}
