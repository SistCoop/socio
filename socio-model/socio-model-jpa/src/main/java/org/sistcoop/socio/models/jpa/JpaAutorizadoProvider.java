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

import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.AutorizadoProvider;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.jpa.entities.AutorizadoEntity;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;

@Named
@Stateless
@Local(AutorizadoProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaAutorizadoProvider extends AbstractHibernateStorage implements AutorizadoProvider {

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
    public AutorizadoModel create(CuentaPersonalModel cuentaPersonal, String tipoDocumento,
            String numeroDocumento) {
        CuentaPersonalEntity cuentaPersonalEntity = this.em.find(CuentaPersonalEntity.class,
                cuentaPersonal.getId());

        AutorizadoEntity autorizadoEntity = new AutorizadoEntity();
        autorizadoEntity.setTipoDocumento(tipoDocumento);
        autorizadoEntity.setNumeroDocumento(numeroDocumento);
        autorizadoEntity.setCuentaPersonal(cuentaPersonalEntity);

        em.persist(autorizadoEntity);
        return new AutorizadoAdapter(em, autorizadoEntity);
    }

    @Override
    public boolean remove(AutorizadoModel autorizado) {
        AutorizadoEntity autorizadoEntity = em.find(AutorizadoEntity.class, autorizado.getId());
        if (autorizadoEntity == null) {
            return false;
        }
        em.remove(autorizadoEntity);
        return true;
    }

    @Override
    public AutorizadoModel findById(String id) {
        AutorizadoEntity autorizadoEntity = this.em.find(AutorizadoEntity.class, id);
        return autorizadoEntity != null ? new AutorizadoAdapter(em, autorizadoEntity) : null;
    }

    @Override
    public List<AutorizadoModel> findAll(CuentaPersonalModel cuentaPersonal) {
        CuentaPersonalEntity cuentaPersonalEntity = this.em.find(CuentaPersonalEntity.class,
                cuentaPersonal.getId());
        Set<AutorizadoEntity> list = cuentaPersonalEntity.getAutorizados();
        List<AutorizadoModel> result = new ArrayList<>();
        for (AutorizadoEntity entity : list) {
            result.add(new AutorizadoAdapter(em, entity));
        }
        return result;
    }

}
