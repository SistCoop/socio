package org.sistcoop.socio.models.jpa;

import java.util.Date;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.TitularModel;
import org.sistcoop.socio.models.jpa.entities.AutorizadoEntity;
import org.sistcoop.socio.models.jpa.entities.TitularEntity;

public class TitularAdapter implements TitularModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected TitularEntity titularEntity;
	protected EntityManager em;

	public TitularAdapter(EntityManager em, TitularEntity titularEntity) {
		this.em = em;
		this.titularEntity = titularEntity;
	}

	public TitularEntity getTitularEntity() {
		return this.titularEntity;
	}

	public static TitularEntity toAutorizadoEntity(TitularModel model, EntityManager em) {
		if (model instanceof TitularAdapter) {
			return ((TitularAdapter) model).getTitularEntity();
		}
		return em.getReference(TitularEntity.class, model.getId());
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
	public String getTipoDocumento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNumeroDocumento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CuentaPersonalModel getCuentaPersonal() {
		// TODO Auto-generated method stub
		return null;
	}

}
