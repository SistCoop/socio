package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.BeneficiarioModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.TasaCuentaPersonalModel;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.TitularModel;
import org.sistcoop.socio.models.enums.EstadoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoCuentaPersonal;
import org.sistcoop.socio.models.jpa.entities.AutorizadoEntity;
import org.sistcoop.socio.models.jpa.entities.BeneficiarioEntity;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.SocioEntity;
import org.sistcoop.socio.models.jpa.entities.TasaCuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.TitularEntity;

public class CuentaPersonalAdapter implements CuentaPersonalModel {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    protected CuentaPersonalEntity cuentaPersonalEntity;
    protected EntityManager em;

    public CuentaPersonalAdapter(EntityManager em, CuentaPersonalEntity cuentaPersonalEntity) {
        this.em = em;
        this.cuentaPersonalEntity = cuentaPersonalEntity;
    }

    public CuentaPersonalEntity getCuentaPersonalEntity() {
        return this.cuentaPersonalEntity;
    }

    public static CuentaPersonalEntity toCuentaPersonalEntity(CuentaPersonalModel model, EntityManager em) {
        if (model instanceof CuentaPersonalAdapter) {
            return ((CuentaPersonalAdapter) model).getCuentaPersonalEntity();
        }
        return em.getReference(CuentaPersonalEntity.class, model.getId());
    }

    @Override
    public void commit() {
        em.merge(cuentaPersonalEntity);
    }

    @Override
    public String getId() {
        return cuentaPersonalEntity.getId();
    }

    @Override
    public TipoCuentaPersonal getTipoCuenta() {
        return cuentaPersonalEntity.getTipoCuenta();
    }

    @Override
    public String getNumeroCuenta() {
        return cuentaPersonalEntity.getNumeroCuenta();
    }

    @Override
    public String getMoneda() {
        return cuentaPersonalEntity.getMoneda();
    }

    @Override
    public Date getFechaApertura() {
        return cuentaPersonalEntity.getFechaApertura();
    }

    @Override
    public Date getFechaCierre() {
        return cuentaPersonalEntity.getFechaCierre();
    }

    @Override
    public void setFechaCierre(Date fechaCierre) {
        cuentaPersonalEntity.setFechaCierre(fechaCierre);
    }

    @Override
    public BigDecimal getSaldo() {
        return cuentaPersonalEntity.getSaldo();
    }

    @Override
    public void setSaldo(BigDecimal saldo) {
        cuentaPersonalEntity.setSaldo(saldo);
    }

    @Override
    public int getCantidadRetirantes() {
        return cuentaPersonalEntity.getCantidadRetirantes();
    }

    @Override
    public EstadoCuentaPersonal getEstado() {
        return cuentaPersonalEntity.getEstado();
    }

    @Override
    public void setEstado(EstadoCuentaPersonal estadoCuenta) {
        cuentaPersonalEntity.setEstado(estadoCuenta);
    }

    @Override
    public SocioModel getSocio() {
        SocioEntity socioEntity = cuentaPersonalEntity.getSocio();
        return new SocioAdapter(em, socioEntity);
    }

    @Override
    public List<TitularModel> getTitulares() {
        Set<TitularEntity> list = cuentaPersonalEntity.getTitulares();
        List<TitularModel> result = new ArrayList<>();
        for (TitularEntity titularEntity : list) {
            result.add(new TitularAdapter(em, titularEntity));
        }
        return result;
    }

    @Override
    public List<AutorizadoModel> getAutorizados() {
        Set<AutorizadoEntity> list = cuentaPersonalEntity.getAutorizados();
        List<AutorizadoModel> result = new ArrayList<>();
        for (AutorizadoEntity autorizadoEntity : list) {
            result.add(new AutorizadoAdapter(em, autorizadoEntity));
        }
        return result;
    }

    @Override
    public List<BeneficiarioModel> getBeneficiarios() {
        Set<BeneficiarioEntity> list = cuentaPersonalEntity.getBeneficiarios();
        List<BeneficiarioModel> result = new ArrayList<>();
        for (BeneficiarioEntity beneficiarioEntity : list) {
            result.add(new BeneficiarioAdapter(em, beneficiarioEntity));
        }
        return result;
    }

    @Override
    public List<TasaCuentaPersonalModel> getTasas() {
        Set<TasaCuentaPersonalEntity> list = cuentaPersonalEntity.getTasas();
        List<TasaCuentaPersonalModel> result = new ArrayList<>();
        for (TasaCuentaPersonalEntity tasaCuentaPersonalEntity : list) {
            result.add(new TasaCuentaPersonalAdapter(em, tasaCuentaPersonalEntity));
        }
        return result;
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
        CuentaPersonalModel other = (CuentaPersonalModel) obj;
        if (getNumeroCuenta() == null) {
            if (other.getNumeroCuenta() != null)
                return false;
        } else if (!getNumeroCuenta().equals(other.getNumeroCuenta()))
            return false;
        return true;
    }
}
