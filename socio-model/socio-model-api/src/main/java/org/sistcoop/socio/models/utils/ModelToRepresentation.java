package org.sistcoop.socio.models.utils;

import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.representations.idm.SocioRepresentation;

public class ModelToRepresentation {

    public static SocioRepresentation toRepresentation(SocioModel model) {
        if (model == null)
            return null;
        SocioRepresentation rep = new SocioRepresentation();

        rep.setId(model.getId());
        rep.setTipoPersona(model.getTipoPersona().toString());
        rep.setTipoDocumento(model.getTipoDocumento());
        rep.setNumeroDocumento(model.getNumeroDocumento());
        rep.setTipoDocumentoRepresentanteLegal(model.getTipoDocumentoRepresentanteLegal());
        rep.setNumeroDocumentoRepresentanteLegal(model.getNumeroDocumentoRepresentanteLegal());
        rep.setFechaInicio(model.getFechaInicio());
        rep.setFechaFin(model.getFechaFin());
        rep.setEstado(model.getEstado());

        return rep;
    }

}
