package org.sistcoop.socio.models;

import java.util.Date;

public interface AutorizadoModel extends Model {

    String getId();

    String getTipoDocumento();

    String getNumeroDocumento();

    Date getFechaInicio();

    Date getFechaFin();

    void setFechaFin(Date fechaFin);

    boolean getEstado();

    void desactivar();

    CuentaPersonalModel getCuentaPersonal();

}
