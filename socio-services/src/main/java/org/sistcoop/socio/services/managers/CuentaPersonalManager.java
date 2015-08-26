package org.sistcoop.socio.services.managers;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.enums.EstadoCuentaPersonal;
import org.sistcoop.socio.representations.idm.CuentaPersonalRepresentation;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CuentaPersonalManager {

    public void update(CuentaPersonalModel model, CuentaPersonalRepresentation rep) {
        model.setEstado(EstadoCuentaPersonal.valueOf(rep.getEstado().toUpperCase()));
        model.commit();
    }

    public void disable(CuentaPersonalModel model) {
        model.setEstado(EstadoCuentaPersonal.INACTIVO);
        model.commit();
    }

}