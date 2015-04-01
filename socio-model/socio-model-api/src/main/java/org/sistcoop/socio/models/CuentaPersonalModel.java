package org.sistcoop.socio.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.sistcoop.socio.models.enums.EstadoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoCuentaPersonal;

public interface CuentaPersonalModel extends Model {

	Long getId();

	TipoCuentaPersonal getTipoCuenta();

	String getNumeroCuenta();

	String getMoneda();

	Date getFechaApertura();

	Date getFechaCierre();

	void setFechaCierre(Date fechaCierre);

	BigDecimal getSaldo();

	void setSaldo(BigDecimal saldo);

	int getCantidadRetirantes();

	EstadoCuentaPersonal getEstadoCuenta();

	void setEstadoCuenta(EstadoCuentaPersonal estadoCuenta);

	SocioModel getSocio();

	List<TitularModel> getTitulares();

	List<AutorizadoModel> getAutorizados();

	List<BeneficiarioModel> getBeneficiarios();

	List<CuentaPersonalTasaModel> getTasas();

}
