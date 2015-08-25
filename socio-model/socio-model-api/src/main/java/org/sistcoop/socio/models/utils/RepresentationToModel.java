package org.sistcoop.socio.models.utils;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalProvider;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.SocioProvider;
import org.sistcoop.socio.models.enums.TipoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoPersona;
import org.sistcoop.socio.representations.idm.CuentaPersonalRepresentation;
import org.sistcoop.socio.representations.idm.SocioRepresentation;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RepresentationToModel {

    public SocioModel createSocio(SocioRepresentation rep, SocioProvider socioProvider) {
        SocioModel socioModel = socioProvider.create(TipoPersona.valueOf(rep.getTipoPersona().toUpperCase()),
                rep.getTipoDocumento(), rep.getNumeroDocumento());
        return socioModel;
    }

    public CuentaPersonalModel createCuentaPersonal(CuentaPersonalRepresentation rep, SocioModel socioModel,
            CuentaPersonalProvider cuentaPersonalProvider) {
        CuentaPersonalModel model = cuentaPersonalProvider.create(socioModel,
                TipoCuentaPersonal.valueOf(rep.getTipoCuenta().toUpperCase()), rep.getMoneda(),
                rep.getCantidadRetirantes());
        return model;
    }
}
