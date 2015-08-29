package org.sistcoop.socio.services.managers;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.representations.idm.AutorizadoRepresentation;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AutorizadoManager {

    public void update(AutorizadoModel model, AutorizadoRepresentation rep) {
        //
    }

    public void disable(AutorizadoModel autorizadoModel) {
        autorizadoModel.desactivar();
        autorizadoModel.commit();        
    }

}