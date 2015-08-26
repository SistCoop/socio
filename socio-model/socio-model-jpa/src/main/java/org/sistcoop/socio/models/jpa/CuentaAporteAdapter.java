package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.CuentaAporteModel;
import org.sistcoop.socio.models.enums.EstadoCuentaAporte;
import org.sistcoop.socio.models.jpa.entities.CuentaAporteEntity;
import org.sistcoop.socio.models.jpa.entities.NumeroCuentaAporteEntity;

public class CuentaAporteAdapter implements CuentaAporteModel {

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
    public String getId() {
        return this.cuentaAporteEntity.getId();
    }

    @Override
    public String getNumeroCuenta() {
        NumeroCuentaAporteEntity numeroCuentaAporteEntity = cuentaAporteEntity.getNumeroCuenta();
        Long numeroCuenta = numeroCuentaAporteEntity.getNumeroCuenta();
        return String.valueOf(numeroCuenta.intValue());
    }

    @Override
    public BigDecimal getSaldo() {
        return this.cuentaAporteEntity.getSaldo();
    }

    @Override
    public void setSaldo(BigDecimal saldo) {
        cuentaAporteEntity.setSaldo(saldo);
    }

    @Override
    public String getMoneda() {
        return cuentaAporteEntity.getMoneda();
    }

    @Override
    public EstadoCuentaAporte getEstado() {
        return cuentaAporteEntity.getEstado();
    }

    @Override
    public void setEstado(EstadoCuentaAporte estadoCuenta) {
        cuentaAporteEntity.setEstado(estadoCuenta);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNumeroCuenta() == null) ? 0 : getNumeroCuenta().hashCode());
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
        CuentaAporteModel other = (CuentaAporteModel) obj;
        if (getNumeroCuenta() == null) {
            if (other.getNumeroCuenta() != null)
                return false;
        } else if (!getNumeroCuenta().equals(other.getNumeroCuenta()))
            return false;
        return true;
    }

}
