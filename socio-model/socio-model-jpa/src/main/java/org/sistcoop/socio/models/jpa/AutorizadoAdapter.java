package org.sistcoop.socio.models.jpa;

import java.util.Date;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.jpa.entities.AutorizadoEntity;

public class AutorizadoAdapter implements AutorizadoModel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private AutorizadoEntity autorizadoEntity;
    private EntityManager em;

    public AutorizadoAdapter(EntityManager em, AutorizadoEntity autorizadoEntity) {
        this.em = em;
        this.autorizadoEntity = autorizadoEntity;
    }

    public AutorizadoEntity getAutorizadoEntity() {
        return this.autorizadoEntity;
    }

    public static AutorizadoEntity toAutorizadoEntity(AutorizadoModel model, EntityManager em) {
        if (model instanceof AutorizadoAdapter) {
            return ((AutorizadoAdapter) model).getAutorizadoEntity();
        }
        return em.getReference(AutorizadoEntity.class, model.getId());
    }

    @Override
    public void commit() {
        em.merge(autorizadoEntity);
    }

    @Override
    public String getId() {
        return autorizadoEntity.getId();
    }

    @Override
    public String getTipoDocumento() {
        return autorizadoEntity.getTipoDocumento();
    }

    @Override
    public String getNumeroDocumento() {
        return autorizadoEntity.getNumeroDocumento();
    }

    @Override
    public Date getFechaInicio() {
        return autorizadoEntity.getFechaInicio();
    }

    @Override
    public Date getFechaFin() {
        return autorizadoEntity.getFechaFin();
    }

    @Override
    public void setFechaFin(Date fechaFin) {
        autorizadoEntity.setFechaFin(fechaFin);
    }

    @Override
    public boolean getEstado() {
        return autorizadoEntity.isEstado();
    }

    @Override
    public void desactivar() {
        autorizadoEntity.setEstado(false);
    }

    @Override
    public CuentaPersonalModel getCuentaPersonal() {
        return new CuentaPersonalAdapter(em, autorizadoEntity.getCuentaPersonal());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AutorizadoModel other = (AutorizadoModel) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

}
