package org.sistcoop.socio.models;

import java.math.BigDecimal;
import java.util.Date;

import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;

public interface BeneficiarioModel {

	Long getId();

	BigDecimal getPorcentajeBeneficio();

	void setPorcentajeBeneficio(BigDecimal porcentajeBeneficiario);

	String getTipoDocumento();

	void setTipoDocumento();

	String getNumeroDocumento();

	void setNumeroDocumento();

	Date getFechaInicio();

	String getApellidoPaterno();

	void setApellidoPaterno(String apellidoPaterno);

	String getApellidoMaterno();

	void setApellidoMaterno(String apellidoMaterno);

	CuentaPersonalModel getCuentaPersonal();

}
