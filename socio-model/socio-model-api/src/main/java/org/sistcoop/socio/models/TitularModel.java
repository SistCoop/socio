package org.sistcoop.socio.models;

public interface TitularModel extends Model {

    String getId();

    String getTipoDocumento();

    String getNumeroDocumento();

    CuentaPersonalModel getCuentaPersonal();

}
