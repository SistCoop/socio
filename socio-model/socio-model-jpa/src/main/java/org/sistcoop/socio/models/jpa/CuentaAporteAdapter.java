package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.CuentaAporteModel;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.enums.EstadoCuentaAporte;
import org.sistcoop.socio.models.jpa.entities.CuentaAporteEntity;

public class CuentaAporteAdapter implements CuentaAporteModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected CuentaAporteEntity cuentaAporteEntity;
	protected EntityManager em;

	public CuentaAporteAdapter(EntityManager em, CuentaAporteEntity cuentaAporteEntity) {
		this.em = em;
		this.cuentaAporteEntity = cuentaAporteEntity;
	}

	public CuentaAporteEntity getCuentaAporteEntity() {
		return this.cuentaAporteEntity;
	}

	public static CuentaAporteEntity toCuentaAporteEntity(CuentaAporteModel model, EntityManager em) {
		if (model instanceof CuentaAporteAdapter) {
			return ((CuentaAporteAdapter) model).getCuentaAporteEntity();
		}
		return em.getReference(CuentaAporteEntity.class, model.getId());
	}

	@Override
	public void commit() {
		em.merge(cuentaAporteEntity);
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNumeroCuenta() {
		// TODO Auto-generated method stub
		return null;
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
	public String getMoneda() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMoneda() {
		// TODO Auto-generated method stub

	}

	@Override
	public EstadoCuentaAporte getEstadoCuenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEstadoCuenta(EstadoCuentaAporte estadoCuenta) {
		// TODO Auto-generated method stub

	}

	@Override
	public SocioModel getSocio() {
		// TODO Auto-generated method stub
		return null;
	}

}
