package org.sistcoop.socio.models;

import java.util.Date;
import java.util.List;

import org.sistcoop.socio.models.enums.TipoPersona;

public interface SocioModel extends Model {

    String getId();

    TipoPersona getTipoPersona();

    String getTipoDocumento();

    String getNumeroDocumento();

    String getTipoDocumentoRepresentanteLegal();

    void setTipoDocumentoRepresentanteLegal(String tipoDocumentoRepresentanteLegal);

    String getNumeroDocumentoRepresentanteLegal();

    void setNumeroDocumentoRepresentanteLegal(String numeroDocumentoRepresentanteLegal);

    Date getFechaInicio();

    Date getFechaFin();

    void setFechaFin(Date fechaFin);

    boolean getEstado();

    void desactivar();

    CuentaAporteModel getCuentaAporte();

    List<CuentaPersonalModel> getCuentasPersonales();

}
