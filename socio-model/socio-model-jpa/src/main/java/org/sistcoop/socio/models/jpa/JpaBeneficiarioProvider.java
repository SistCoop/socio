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

import org.sistcoop.socio.models.BeneficiarioModel;
import org.sistcoop.socio.models.BeneficiarioProvider;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.jpa.entities.BeneficiarioEntity;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;

@Named
@Stateless
@Local(BeneficiarioProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaBeneficiarioProvider extends AbstractHibernateStorage implements BeneficiarioProvider {

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
    public BeneficiarioModel create(CuentaPersonalModel cuentaPersonal, String tipoDocumento,
            String numeroDocumento, String apellidoPaterno, String apellidoMaterno, String nombres,
            BigDecimal porcentajeBeneficio) {
        CuentaPersonalEntity cuentaPersonalEntity = this.em.find(CuentaPersonalEntity.class,
                cuentaPersonal.getId());

        BeneficiarioEntity beneficiarioEntity = new BeneficiarioEntity();
        beneficiarioEntity.setTipoDocumento(tipoDocumento);
        beneficiarioEntity.setNumeroDocumento(numeroDocumento);
        beneficiarioEntity.setApellidoPaterno(apellidoPaterno);
        beneficiarioEntity.setApellidoMaterno(apellidoMaterno);
        beneficiarioEntity.setNombres(nombres);
        beneficiarioEntity.setPorcentajeBeneficio(porcentajeBeneficio);
        beneficiarioEntity.setCuentaPersonal(cuentaPersonalEntity);

        em.persist(beneficiarioEntity);
        return new BeneficiarioAdapter(em, beneficiarioEntity);
    }

    @Override
    public boolean remove(BeneficiarioModel beneficiario) {
        BeneficiarioEntity beneficiarioEntity = em.find(BeneficiarioEntity.class, beneficiario.getId());
        if (beneficiarioEntity == null) {
            return false;
        }
        em.remove(beneficiarioEntity);
        return true;
    }

    @Override
    public BeneficiarioModel findById(String id) {
        BeneficiarioEntity beneficiarioEntity = this.em.find(BeneficiarioEntity.class, id);
        return beneficiarioEntity != null ? new BeneficiarioAdapter(em, beneficiarioEntity) : null;
    }

    @Override
    public List<BeneficiarioModel> findAll(CuentaPersonalModel cuentaPersonal) {
        CuentaPersonalEntity cuentaPersonalEntity = this.em.find(CuentaPersonalEntity.class,
                cuentaPersonal.getId());
        Set<BeneficiarioEntity> list = cuentaPersonalEntity.getBeneficiarios();
        List<BeneficiarioModel> result = new ArrayList<>();
        for (BeneficiarioEntity entity : list) {
            result.add(new BeneficiarioAdapter(em, entity));
        }
        return result;
    }

}
