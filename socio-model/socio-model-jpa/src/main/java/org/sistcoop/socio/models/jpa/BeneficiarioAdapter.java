package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.sistcoop.socio.models.BeneficiarioModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.jpa.entities.BeneficiarioEntity;

public class BeneficiarioAdapter implements BeneficiarioModel {

    private static final long serialVersionUID = 1L;

    private BeneficiarioEntity beneficiarioEntity;
    private EntityManager em;

    public BeneficiarioAdapter(EntityManager em, BeneficiarioEntity beneficiarioEntity) {
        this.em = em;
        this.beneficiarioEntity = beneficiarioEntity;
    }

    public BeneficiarioEntity getBeneficiarioEntity() {
        return this.beneficiarioEntity;
    }

    public static BeneficiarioEntity toBeneficiarioEntity(BeneficiarioModel model, EntityManager em) {
        if (model instanceof BeneficiarioAdapter) {
            return ((BeneficiarioAdapter) model).getBeneficiarioEntity();
        }
        return em.getReference(BeneficiarioEntity.class, model.getId());
    }

    @Override
    public void commit() {
        em.merge(beneficiarioEntity);
    }

    @Override
    public String getId() {
        return beneficiarioEntity.getId();
    }

    @Override
    public BigDecimal getPorcentajeBeneficio() {
        return beneficiarioEntity.getPorcentajeBeneficio();
    }

    @Override
    public void setPorcentajeBeneficio(BigDecimal porcentajeBeneficiario) {
        beneficiarioEntity.setPorcentajeBeneficio(porcentajeBeneficiario);
    }

    @Override
    public String getTipoDocumento() {
        return beneficiarioEntity.getTipoDocumento();
    }

    @Override
    public void setTipoDocumento(String tipoDocumento) {
        beneficiarioEntity.setTipoDocumento(tipoDocumento);
    }

    @Override
    public String getNumeroDocumento() {
        return beneficiarioEntity.getNumeroDocumento();
    }

    @Override
    public void setNumeroDocumento(String numeroDocumento) {
        beneficiarioEntity.setNumeroDocumento(numeroDocumento);
    }

    @Override
    public String getApellidoPaterno() {
        return beneficiarioEntity.getApellidoPaterno();
    }

    @Override
    public void setApellidoPaterno(String apellidoPaterno) {
        beneficiarioEntity.setApellidoPaterno(apellidoPaterno);
    }

    @Override
    public String getApellidoMaterno() {
        return beneficiarioEntity.getApellidoMaterno();
    }

    @Override
    public void setApellidoMaterno(String apellidoMaterno) {
        beneficiarioEntity.setApellidoMaterno(apellidoMaterno);
    }

    @Override
    public String getNombres() {
        return beneficiarioEntity.getNombres();
    }

    @Override
    public void setNombres(String nombres) {
        beneficiarioEntity.setNombres(nombres);
    }

    @Override
    public CuentaPersonalModel getCuentaPersonal() {
        return new CuentaPersonalAdapter(em, beneficiarioEntity.getCuentaPersonal());
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
        BeneficiarioModel other = (BeneficiarioModel) obj;
        if (getId() == null) {
            if (other.getId() != null)
                return false;
        } else if (!getId().equals(other.getId()))
            return false;
        return true;
    }

}
