package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalProvider;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.enums.EstadoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoCuentaPersonal;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.NumeroCuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.SocioEntity;

@Named
@Stateless
@Local(CuentaPersonalProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaCuentaPersonalProvider extends AbstractHibernateStorage implements CuentaPersonalProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    public CuentaPersonalModel create(SocioModel socio, TipoCuentaPersonal tipoCuenta, String moneda,
            int cantidadRetirantes, Date fechaCierre) {
        SocioEntity socioEntity = this.em.find(SocioEntity.class, socio.getId());

        NumeroCuentaPersonalEntity numeroCuentaPersonalEntity = new NumeroCuentaPersonalEntity();
        CuentaPersonalEntity cuentaPersonalEntity = new CuentaPersonalEntity();
        cuentaPersonalEntity.setTipoCuenta(tipoCuenta);
        cuentaPersonalEntity.setMoneda(moneda);
        cuentaPersonalEntity.setCantidadRetirantes(cantidadRetirantes);
        cuentaPersonalEntity.setNumeroCuenta(numeroCuentaPersonalEntity);
        cuentaPersonalEntity.setSaldo(BigDecimal.ZERO);
        cuentaPersonalEntity.setFechaApertura(Calendar.getInstance().getTime());
        cuentaPersonalEntity.setFechaCierre(fechaCierre);
        cuentaPersonalEntity
                .setEstado(tipoCuenta.equals(TipoCuentaPersonal.PLAZO_FIJO) ? EstadoCuentaPersonal.POR_ACTIVAR
                        : EstadoCuentaPersonal.ACTIVO);
        cuentaPersonalEntity.setSocio(socioEntity);

        em.persist(cuentaPersonalEntity);
        return new CuentaPersonalAdapter(em, cuentaPersonalEntity);
    }

    @Override
    public boolean remove(CuentaPersonalModel cuentaPersonal) {
        CuentaPersonalEntity cuentaPersonalEntity = em.find(CuentaPersonalEntity.class,
                cuentaPersonal.getId());
        if (cuentaPersonalEntity == null) {
            return false;
        }
        em.remove(cuentaPersonalEntity);
        return true;
    }

    @Override
    public CuentaPersonalModel findById(String id) {
        CuentaPersonalEntity cuentaPersonalEntity = this.em.find(CuentaPersonalEntity.class, id);
        return cuentaPersonalEntity != null ? new CuentaPersonalAdapter(em, cuentaPersonalEntity) : null;
    }

    @Override
    public List<CuentaPersonalModel> findAll(SocioModel socio) {
        SocioEntity socioEntity = this.em.find(SocioEntity.class, socio.getId());
        Set<CuentaPersonalEntity> list = socioEntity.getCuentasPersonales();
        List<CuentaPersonalModel> result = new ArrayList<>();
        for (CuentaPersonalEntity entity : list) {
            result.add(new CuentaPersonalAdapter(em, entity));
        }
        return result;
    }

}
