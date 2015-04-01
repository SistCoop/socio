package org.sistcoop.socio.models;

import java.util.Date;

public interface AutorizadoModel {

	Long getId();

	String getTipoDocumento();

	String getNumeroDocumento();

	Date getFechaInicio();

	Date getFechaFin();

	void setFechaFin();

	boolean getEstado();

	void desactivar();

	CuentaPersonalModel getCuentaPersonal();

}
