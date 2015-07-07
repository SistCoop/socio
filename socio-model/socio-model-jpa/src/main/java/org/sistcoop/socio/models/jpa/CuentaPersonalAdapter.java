package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.BeneficiarioModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalTasaModel;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.TitularModel;
import org.sistcoop.socio.models.enums.EstadoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoCuentaPersonal;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;

public class CuentaPersonalAdapter implements CuentaPersonalModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected CuentaPersonalEntity cuentaPersonalEntity;
	protected EntityManager em;

	public CuentaPersonalAdapter(EntityManager em, CuentaPersonalEntity cuentaPersonalEntity) {
		this.em = em;
		this.cuentaPersonalEntity = cuentaPersonalEntity;
	}

	public CuentaPersonalEntity getCuentaPersonalEntity() {
		return this.cuentaPersonalEntity;
	}

	public static CuentaPersonalEntity toSocioEntity(CuentaPersonalModel model, EntityManager em) {
		if (model instanceof CuentaPersonalAdapter) {
			return ((CuentaPersonalAdapter) model).getCuentaPersonalEntity();
		}
		return em.getReference(CuentaPersonalEntity.class, model.getId());
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub

	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoCuentaPersonal getTipoCuenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNumeroCuenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMoneda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getFechaApertura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getFechaCierre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFechaCierre(Date fechaCierre) {
		// TODO Auto-generated method stub

	}

	@Override
	public BigDecimal getSaldo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSaldo(BigDecimal saldo) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getCantidadRetirantes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EstadoCuentaPersonal getEstadoCuenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEstadoCuenta(EstadoCuentaPersonal estadoCuenta) {
		// TODO Auto-generated method stub

	}

	@Override
	public SocioModel getSocio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TitularModel> getTitulares() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AutorizadoModel> getAutorizados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BeneficiarioModel> getBeneficiarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CuentaPersonalTasaModel> getTasas() {
		// TODO Auto-generated method stub
		return null;
	}

}
