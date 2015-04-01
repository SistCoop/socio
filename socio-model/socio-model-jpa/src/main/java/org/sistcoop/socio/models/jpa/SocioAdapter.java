package org.sistcoop.socio.models.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.CuentaAporteModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.enums.TipoPersona;
import org.sistcoop.socio.models.jpa.entities.AutorizadoEntity;
import org.sistcoop.socio.models.jpa.entities.SocioEntity;

public class SocioAdapter implements SocioModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected SocioEntity socioEntity;
	protected EntityManager em;

	public SocioAdapter(EntityManager em, SocioEntity socioEntity) {
		this.em = em;
		this.socioEntity = socioEntity;
	}

	public SocioEntity getSocioEntity() {
		return this.socioEntity;
	}

	public static SocioEntity toSocioEntity(SocioModel model, EntityManager em) {
		if (model instanceof SocioAdapter) {
			return ((SocioAdapter) model).getSocioEntity();
		}
		return em.getReference(SocioEntity.class, model.getId());
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
	public TipoPersona getTipoPersona() {
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
	public String getTipoDocumentoRepresentanteLegal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTipoDocumentoRepresentanteLegal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNumeroDocumentoRepresentanteLegal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNumeroDocumentoRepresentanteLegal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getFechaInicio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getFechaFin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFechaFin(Date fechaFin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getEstado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void desactivar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CuentaAporteModel getCuentaAporte() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CuentaPersonalModel> getCuentasPersonales() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
