package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.InteresGeneradoCuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.InteresGeneradoCuentaPersonalEntity;

public class InteresGeneradoCuentaPersonalAdapter implements InteresGeneradoCuentaPersonalModel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private InteresGeneradoCuentaPersonalEntity interesGeneradoCuentaPersonalEntity;
    private EntityManager em;

    public InteresGeneradoCuentaPersonalAdapter(EntityManager em,
            InteresGeneradoCuentaPersonalEntity cuentaPersonalInteresGeneradoEntity) {
        this.em = em;
        this.interesGeneradoCuentaPersonalEntity = cuentaPersonalInteresGeneradoEntity;
    }

    public InteresGeneradoCuentaPersonalEntity getInteresGeneradoCuentaPersonalEntity() {
        return this.interesGeneradoCuentaPersonalEntity;
    }

    public static InteresGeneradoCuentaPersonalEntity toInteresGeneradoCuentaPersonalEntity(
            InteresGeneradoCuentaPersonalModel model, EntityManager em) {
        if (model instanceof InteresGeneradoCuentaPersonalAdapter) {
            return ((InteresGeneradoCuentaPersonalAdapter) model).getInteresGeneradoCuentaPersonalEntity();
        }
        return em.getReference(InteresGeneradoCuentaPersonalEntity.class, model.getId());
    }

    @Override
    public void commit() {
        em.merge(interesGeneradoCuentaPersonalEntity);
    }

    @Override
    public String getId() {
        return interesGeneradoCuentaPersonalEntity.getId();
    }

    @Override
    public CuentaPersonalModel getCuentaPersonal() {
        CuentaPersonalEntity cuentaPersonalEntity = interesGeneradoCuentaPersonalEntity.getCuentaPersonal();
        return new CuentaPersonalAdapter(em, cuentaPersonalEntity);
    }

    @Override
    public BigDecimal getCapital() {
        return interesGeneradoCuentaPersonalEntity.getCapital();
    }

    @Override
    public BigDecimal getInteresGenerado() {
        return interesGeneradoCuentaPersonalEntity.getInteresGenerado();
    }

    @Override
    public Date getFecha() {
        return interesGeneradoCuentaPersonalEntity.getFecha();
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
        InteresGeneradoCuentaPersonalModel other = (InteresGeneradoCuentaPersonalModel) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

}
