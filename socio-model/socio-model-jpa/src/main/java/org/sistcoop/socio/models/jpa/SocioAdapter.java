package org.sistcoop.socio.models.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.CuentaAporteModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.enums.TipoPersona;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;
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
		this.em.merge(socioEntity);
	}

	@Override
	public String getId() {
		return socioEntity.getId();
	}

	@Override
	public TipoPersona getTipoPersona() {
		return socioEntity.getTipoPersona();
	}

	@Override
	public String getTipoDocumento() {
		return socioEntity.getTipoDocumento();
	}

	@Override
	public String getNumeroDocumento() {
		return socioEntity.getNumeroDocumento();
	}

	@Override
	public String getTipoDocumentoRepresentanteLegal() {
		return socioEntity.getTipoDocumentoRepresentanteLegal();
	}

	@Override
	public void setTipoDocumentoRepresentanteLegal(String tipoDocumentoRepresentanteLegal) {
	    socioEntity.setTipoDocumentoRepresentanteLegal(tipoDocumentoRepresentanteLegal);
	}

	@Override
	public String getNumeroDocumentoRepresentanteLegal() {
		return socioEntity.getNumeroDocumentoRepresentanteLegal();
	}

	@Override
	public void setNumeroDocumentoRepresentanteLegal(String numeroDocumentoRepresentanteLegal) {
	    socioEntity.setNumeroDocumentoRepresentanteLegal(numeroDocumentoRepresentanteLegal);
	}

	@Override
	public Date getFechaInicio() {
		return socioEntity.getFechaInicio();
	}

	@Override
	public Date getFechaFin() {
		return socioEntity.getFechaFin();
	}

	@Override
	public void setFechaFin(Date fechaFin) {
	    socioEntity.setFechaFin(fechaFin);	
	}

	@Override
	public boolean getEstado() {
		return socioEntity.isEstado();
	}

	@Override
	public void desactivar() {
	    socioEntity.setEstado(false);
	}

	@Override
	public CuentaAporteModel getCuentaAporte() {
		return new CuentaAporteAdapter(em, socioEntity.getCuentaAporte());
	}

	@Override
	public List<CuentaPersonalModel> getCuentasPersonales() {
	    Set<CuentaPersonalEntity> cuentaPersonalEntities = socioEntity.getCuentasPersonales();
	    List<CuentaPersonalModel> result = new ArrayList<>();
	    for (CuentaPersonalEntity cuentaPersonalEntity : cuentaPersonalEntities) {
	        result.add(new CuentaPersonalAdapter(em, cuentaPersonalEntity));
        }
	    return result;
	}
	
}
