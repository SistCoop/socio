package org.sistcoop.socio.models.jpa;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sistcoop.socio.models.CuentaAporteModel;
import org.sistcoop.socio.models.CuentaAporteProvider;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.jpa.entities.CuentaAporteEntity;
import org.sistcoop.socio.models.jpa.entities.SocioEntity;

@Named
@Stateless
@Local(CuentaAporteProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaCuentaAporteProvider extends AbstractHibernateStorage implements CuentaAporteProvider {

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
    public CuentaAporteModel findById(String id) {
        CuentaAporteEntity cuentaAporteEntity = this.em.find(CuentaAporteEntity.class, id);
        return cuentaAporteEntity != null ? new CuentaAporteAdapter(em, cuentaAporteEntity) : null;
    }

    @Override
    public CuentaAporteModel findBySocio(SocioModel socio) {
        SocioEntity socioEntity = this.em.find(SocioEntity.class, socio.getId());
        CuentaAporteEntity cuentaAporteEntity = socioEntity.getCuentaAporte();
        return new CuentaAporteAdapter(em, cuentaAporteEntity);
    }

}
