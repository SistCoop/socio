package org.sistcoop.socio.models.jpa;

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
import org.sistcoop.socio.models.TitularModel;
import org.sistcoop.socio.models.TitularProvider;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.TitularEntity;

@Named
@Stateless
@Local(TitularProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaTitularProvider extends AbstractHibernateStorage implements TitularProvider {

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
    public TitularModel create(CuentaPersonalModel cuentaPersonal, String tipoDocumento,
            String numeroDocumento) {
        CuentaPersonalEntity cuentaPersonalEntity = this.em.find(CuentaPersonalEntity.class,
                cuentaPersonal.getId());

        TitularEntity titularEntity = new TitularEntity();
        titularEntity.setTipoDocumento(tipoDocumento);
        titularEntity.setNumeroDocumento(numeroDocumento);
        titularEntity.setCuentaPersonal(cuentaPersonalEntity);

        em.persist(titularEntity);
        return new TitularAdapter(em, titularEntity);
    }

    @Override
    public boolean remove(TitularModel titular) {
        TitularEntity titularEntity = em.find(TitularEntity.class, titular.getId());
        if (titularEntity == null) {
            return false;
        }
        em.remove(titularEntity);
        return true;
    }

    @Override
    public TitularModel findById(String id) {
        TitularEntity titularEntity = this.em.find(TitularEntity.class, id);
        return titularEntity != null ? new TitularAdapter(em, titularEntity) : null;
    }

    @Override
    public List<TitularModel> findAll(CuentaPersonalModel cuentaPersonal) {
        CuentaPersonalEntity cuentaPersonalEntity = this.em.find(CuentaPersonalEntity.class,
                cuentaPersonal.getId());
        Set<TitularEntity> list = cuentaPersonalEntity.getTitulares();
        List<TitularModel> result = new ArrayList<>();
        for (TitularEntity entity : list) {
            result.add(new TitularAdapter(em, entity));
        }
        return result;
    }

}
