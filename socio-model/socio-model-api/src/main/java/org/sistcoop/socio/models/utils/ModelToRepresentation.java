package org.sistcoop.socio.models.utils;

import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.representations.idm.CuentaPersonalRepresentation;
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

    public static CuentaPersonalRepresentation toRepresentation(CuentaPersonalModel model) {
        if (model == null)
            return null;

        CuentaPersonalRepresentation rep = new CuentaPersonalRepresentation();
        rep.setId(model.getId());
        rep.setTipoCuenta(model.getTipoCuenta().toString());
        rep.setNumeroCuenta(model.getNumeroCuenta());
        rep.setMoneda(model.getMoneda());
        rep.setSaldo(model.getSaldo());
        rep.setCantidadRetirantes(model.getCantidadRetirantes());
        rep.setFechaApertura(model.getFechaApertura());
        rep.setFechaCierre(model.getFechaCierre());
        rep.setEstado(model.getEstadoCuenta().toString());

        return rep;
    }

}
