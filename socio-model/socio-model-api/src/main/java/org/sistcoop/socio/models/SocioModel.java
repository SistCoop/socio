package org.sistcoop.socio.models;

import java.util.Date;
import java.util.List;

import org.sistcoop.socio.models.enums.TipoPersona;

public interface SocioModel extends Model {

	Long getId();

	TipoPersona getTipoPersona();

	String getTipoDocumento();

	String getNumeroDocumento();

	String getTipoDocumentoRepresentanteLegal();

	void setTipoDocumentoRepresentanteLegal();

	String getNumeroDocumentoRepresentanteLegal();

	void setNumeroDocumentoRepresentanteLegal();

	Date getFechaInicio();

	Date getFechaFin();

	void setFechaFin(Date fechaFin);

	boolean getEstado();

	void desactivar();

	CuentaAporteModel getCuentaAporte();

	List<CuentaPersonalModel> getCuentasPersonales();

}
