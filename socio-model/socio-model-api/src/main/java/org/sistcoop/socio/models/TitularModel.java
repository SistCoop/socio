package org.sistcoop.socio.models;

public interface TitularModel extends Model {

	Long getId();

	String getTipoDocumento();

	String getNumeroDocumento();

	CuentaPersonalModel getCuentaPersonal();

}
