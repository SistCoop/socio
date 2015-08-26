package org.sistcoop.socio.models.jpa;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.TitularModel;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.TitularEntity;

public class TitularAdapter implements TitularModel {

    private static final long serialVersionUID = 1L;

    private TitularEntity titularEntity;
    private EntityManager em;

    public TitularAdapter(EntityManager em, TitularEntity titularEntity) {
        this.em = em;
        this.titularEntity = titularEntity;
    }

    public TitularEntity getTitularEntity() {
        return this.titularEntity;
    }

    public static TitularEntity toTitularEntity(TitularModel model, EntityManager em) {
        if (model instanceof TitularAdapter) {
            return ((TitularAdapter) model).getTitularEntity();
        }
        return em.getReference(TitularEntity.class, model.getId());
    }

    @Override
    public void commit() {
        em.merge(titularEntity);
    }

    @Override
    public String getId() {
        return titularEntity.getId();
    }

    @Override
    public String getTipoDocumento() {
        return titularEntity.getTipoDocumento();
    }

    @Override
    public String getNumeroDocumento() {
        return titularEntity.getNumeroDocumento();
    }

    @Override
    public CuentaPersonalModel getCuentaPersonal() {
        CuentaPersonalEntity cuentaPersonalEntity = titularEntity.getCuentaPersonal();
        return new CuentaPersonalAdapter(em, cuentaPersonalEntity);
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
        TitularModel other = (TitularModel) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

}
