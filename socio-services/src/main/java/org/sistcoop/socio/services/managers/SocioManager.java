package org.sistcoop.socio.services.managers;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.representations.idm.SocioRepresentation;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SocioManager {

    public void update(SocioModel model, SocioRepresentation rep) {
        model.setTipoDocumentoRepresentanteLegal(rep.getTipoDocumentoRepresentanteLegal());
        model.setNumeroDocumentoRepresentanteLegal(rep.getNumeroDocumentoRepresentanteLegal());
        model.commit();
    }

    public void disable(SocioModel model) {
        model.desactivar();
        model.commit();
    }

}