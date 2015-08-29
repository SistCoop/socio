package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import org.sistcoop.socio.models.TasaCuentaPersonalModel;
import org.sistcoop.socio.models.TasaCuentaPersonalProvider;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.TasaCuentaPersonalEntity;

@Named
@Stateless
@Local(TasaCuentaPersonalProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaTasaCuentaPersonalProvider extends AbstractHibernateStorage implements
        TasaCuentaPersonalProvider {

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
    public TasaCuentaPersonalModel create(CuentaPersonalModel cuentaPersonal, String denominacion,
            BigDecimal valor) {
        CuentaPersonalEntity cuentaPersonalEntity = this.em.find(CuentaPersonalEntity.class,
                cuentaPersonal.getId());

        TasaCuentaPersonalEntity tasaCuentaPersonalEntity = new TasaCuentaPersonalEntity();
        tasaCuentaPersonalEntity.setDenominacion(denominacion);
        tasaCuentaPersonalEntity.setDenominacion(denominacion);
        tasaCuentaPersonalEntity.setValor(valor);
        tasaCuentaPersonalEntity.setCuentaPersonal(cuentaPersonalEntity);

        em.persist(tasaCuentaPersonalEntity);
        return new TasaCuentaPersonalAdapter(em, tasaCuentaPersonalEntity);
    }

    @Override
    public boolean remove(TasaCuentaPersonalModel tasaCuentaPersonal) {
        TasaCuentaPersonalEntity tasaCuentaPersonalEntity = em.find(TasaCuentaPersonalEntity.class,
                tasaCuentaPersonal.getId());
        if (tasaCuentaPersonalEntity == null) {
            return false;
        }
        em.remove(tasaCuentaPersonalEntity);
        return true;
    }

    @Override
    public TasaCuentaPersonalModel findById(String id) {
        TasaCuentaPersonalEntity tasaCuentaPersonalEntity = this.em.find(TasaCuentaPersonalEntity.class, id);
        return tasaCuentaPersonalEntity != null ? new TasaCuentaPersonalAdapter(em, tasaCuentaPersonalEntity)
                : null;
    }

    @Override
    public List<TasaCuentaPersonalModel> findAll(CuentaPersonalModel cuentaPersonal) {
        CuentaPersonalEntity cuentaPersonalEntity = this.em.find(CuentaPersonalEntity.class,
                cuentaPersonal.getId());
        Set<TasaCuentaPersonalEntity> list = cuentaPersonalEntity.getTasas();
        List<TasaCuentaPersonalModel> result = new ArrayList<>();
        for (TasaCuentaPersonalEntity entity : list) {
            result.add(new TasaCuentaPersonalAdapter(em, entity));
        }
        return result;
    }

}
