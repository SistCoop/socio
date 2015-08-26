package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.BeneficiarioModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalTasaModel;
import org.sistcoop.socio.models.jpa.entities.AutorizadoEntity;
import org.sistcoop.socio.models.jpa.entities.BeneficiarioEntity;
import org.sistcoop.socio.models.jpa.entities.TasaCuentaPersonalEntity;

public class CuentaPersonalTasaAdapter implements CuentaPersonalTasaModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected TasaCuentaPersonalEntity cuentaPersonalTasaEntity;
	protected EntityManager em;

	public CuentaPersonalTasaAdapter(EntityManager em, TasaCuentaPersonalEntity cuentaPersonalTasaEntity) {
		this.em = em;
		this.cuentaPersonalTasaEntity = cuentaPersonalTasaEntity;
	}

	public TasaCuentaPersonalEntity getCuentaPersonalTasaEntity() {
		return this.cuentaPersonalTasaEntity;
	}

	public static TasaCuentaPersonalEntity toBeneficiarioEntity(CuentaPersonalTasaModel model, EntityManager em) {
		if (model instanceof CuentaPersonalTasaAdapter) {
			return ((CuentaPersonalTasaAdapter) model).getCuentaPersonalTasaEntity();
		}
		return em.getReference(TasaCuentaPersonalEntity.class, model.getId());
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
	public String getDenominacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDenominacion() {
		// TODO Auto-generated method stub

	}

	@Override
	public BigDecimal getValor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValor(BigDecimal valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public CuentaPersonalModel getCuentaPersonal() {
		// TODO Auto-generated method stub
		return null;
	}

}
