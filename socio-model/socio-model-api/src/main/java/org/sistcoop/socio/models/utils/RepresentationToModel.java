package org.sistcoop.socio.models.utils;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.SocioProvider;
import org.sistcoop.socio.models.enums.TipoPersona;
import org.sistcoop.socio.representations.idm.SocioRepresentation;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RepresentationToModel {

    public SocioModel createSocio(SocioRepresentation rep, SocioProvider socioProvider) {
        SocioModel socioModel = socioProvider.create(TipoPersona.valueOf(rep.getTipoPersona().toUpperCase()),
                rep.getTipoDocumento(), rep.getNumeroDocumento());
        return socioModel;
    }
    
}
