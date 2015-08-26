package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.TasaCuentaPersonalModel;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.TasaCuentaPersonalEntity;

public class TasaCuentaPersonalAdapter implements TasaCuentaPersonalModel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private TasaCuentaPersonalEntity tasaCuentaPersonalEntity;
    private EntityManager em;

    public TasaCuentaPersonalAdapter(EntityManager em, TasaCuentaPersonalEntity cuentaPersonalTasaEntity) {
        this.em = em;
        this.tasaCuentaPersonalEntity = cuentaPersonalTasaEntity;
    }

    public TasaCuentaPersonalEntity getTasaCuentaPersonalEntity() {
        return this.tasaCuentaPersonalEntity;
    }

    public static TasaCuentaPersonalEntity toTasaCuentaPersonalEntity(TasaCuentaPersonalModel model,
            EntityManager em) {
        if (model instanceof TasaCuentaPersonalAdapter) {
            return ((TasaCuentaPersonalAdapter) model).getTasaCuentaPersonalEntity();
        }
        return em.getReference(TasaCuentaPersonalEntity.class, model.getId());
    }

    @Override
    public void commit() {
        em.merge(tasaCuentaPersonalEntity);
    }

    @Override
    public String getId() {
        return tasaCuentaPersonalEntity.getId();
    }

    @Override
    public String getDenominacion() {
        return tasaCuentaPersonalEntity.getDenominacion();
    }

    @Override
    public void setDenominacion(String denominacion) {
        tasaCuentaPersonalEntity.setDenominacion(denominacion);
    }

    @Override
    public BigDecimal getValor() {
        return tasaCuentaPersonalEntity.getValor();
    }

    @Override
    public void setValor(BigDecimal valor) {
        tasaCuentaPersonalEntity.setValor(valor);
    }

    @Override
    public CuentaPersonalModel getCuentaPersonal() {
        CuentaPersonalEntity cuentaPersonalEntity = tasaCuentaPersonalEntity.getCuentaPersonal();
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
        TasaCuentaPersonalModel other = (TasaCuentaPersonalModel) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

}
