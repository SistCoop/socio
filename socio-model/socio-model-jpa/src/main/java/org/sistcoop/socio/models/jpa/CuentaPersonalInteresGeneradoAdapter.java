package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.CuentaAporteModel;
import org.sistcoop.socio.models.CuentaPersonalInteresGeneradoModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.enums.EstadoCuentaAporte;
import org.sistcoop.socio.models.jpa.entities.CuentaAporteEntity;
import org.sistcoop.socio.models.jpa.entities.InteresGeneradoCuentaPersonalEntity;

public class CuentaPersonalInteresGeneradoAdapter implements CuentaPersonalInteresGeneradoModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected InteresGeneradoCuentaPersonalEntity cuentaPersonalInteresGeneradoEntity;
	protected EntityManager em;

	public CuentaPersonalInteresGeneradoAdapter(EntityManager em, InteresGeneradoCuentaPersonalEntity cuentaPersonalInteresGeneradoEntity) {
		this.em = em;
		this.cuentaPersonalInteresGeneradoEntity = cuentaPersonalInteresGeneradoEntity;
	}

	public InteresGeneradoCuentaPersonalEntity getCuentaPersonalInteresGeneradoEntity() {
		return this.cuentaPersonalInteresGeneradoEntity;
	}

	public static InteresGeneradoCuentaPersonalEntity toCuentaAporteEntity(CuentaPersonalInteresGeneradoModel model, EntityManager em) {
		if (model instanceof CuentaPersonalInteresGeneradoAdapter) {
			return ((CuentaPersonalInteresGeneradoAdapter) model).getCuentaPersonalInteresGeneradoEntity();
		}
		return em.getReference(InteresGeneradoCuentaPersonalEntity.class, model.getId());
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
	public CuentaPersonalModel getCuentaPersonal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getCapital() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getInteresGenerado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getFecha() {
		// TODO Auto-generated method stub
		return null;
	}

}
