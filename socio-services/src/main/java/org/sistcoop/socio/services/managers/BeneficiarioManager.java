package org.sistcoop.socio.services.managers;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.sistcoop.socio.models.BeneficiarioModel;
import org.sistcoop.socio.representations.idm.BeneficiarioRepresentation;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class BeneficiarioManager {

    public void update(BeneficiarioModel model, BeneficiarioRepresentation rep) {
        model.setApellidoPaterno(rep.getApellidoPaterno());
        model.setApellidoMaterno(rep.getApellidoMaterno());
        model.setNombres(rep.getNombres());
        model.setTipoDocumento(rep.getTipoDocumento());
        model.setNumeroDocumento(rep.getNumeroDocumento());
        model.commit();
    }

}