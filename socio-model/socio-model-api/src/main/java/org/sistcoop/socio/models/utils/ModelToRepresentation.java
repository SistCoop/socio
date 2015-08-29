package org.sistcoop.socio.models.utils;

import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.BeneficiarioModel;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.TitularModel;
import org.sistcoop.socio.representations.idm.AutorizadoRepresentation;
import org.sistcoop.socio.representations.idm.BeneficiarioRepresentation;
import org.sistcoop.socio.representations.idm.CuentaPersonalRepresentation;
import org.sistcoop.socio.representations.idm.SocioRepresentation;
import org.sistcoop.socio.representations.idm.TitularRepresentation;

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
        rep.setEstado(model.getEstado().toString());

        return rep;
    }

    public static AutorizadoRepresentation toRepresentation(AutorizadoModel model) {
        if (model == null)
            return null;

        AutorizadoRepresentation rep = new AutorizadoRepresentation();
        rep.setId(model.getId());
        rep.setTipoDocumento(model.getTipoDocumento());
        rep.setNumeroDocumento(model.getNumeroDocumento());
        rep.setFechaInicio(model.getFechaInicio());
        rep.setFechaFin(model.getFechaFin());
        rep.setEstado(model.getEstado());

        return rep;
    }

    public static BeneficiarioRepresentation toRepresentation(BeneficiarioModel model) {
        if (model == null)
            return null;

        BeneficiarioRepresentation rep = new BeneficiarioRepresentation();
        rep.setId(model.getId());
        rep.setTipoDocumento(model.getTipoDocumento());
        rep.setNumeroDocumento(model.getNumeroDocumento());
        rep.setApellidoPaterno(model.getApellidoPaterno());
        rep.setApellidoMaterno(model.getApellidoMaterno());
        rep.setNombres(model.getNombres());
        rep.setPorcentajeBeneficio(model.getPorcentajeBeneficio());

        return rep;
    }

    public static TitularRepresentation toRepresentation(TitularModel model) {
        if (model == null)
            return null;

        TitularRepresentation rep = new TitularRepresentation();
        rep.setId(model.getId());
        rep.setTipoDocumento(model.getTipoDocumento());
        rep.setNumeroDocumento(model.getNumeroDocumento());

        return rep;
    }

}
