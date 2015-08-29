package org.sistcoop.socio.models.utils;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.AutorizadoProvider;
import org.sistcoop.socio.models.BeneficiarioModel;
import org.sistcoop.socio.models.BeneficiarioProvider;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalProvider;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.SocioProvider;
import org.sistcoop.socio.models.TasaCuentaPersonalProvider;
import org.sistcoop.socio.models.TitularProvider;
import org.sistcoop.socio.models.enums.TipoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoPersona;
import org.sistcoop.socio.representations.idm.AutorizadoRepresentation;
import org.sistcoop.socio.representations.idm.BeneficiarioRepresentation;
import org.sistcoop.socio.representations.idm.CuentaPersonalRepresentation;
import org.sistcoop.socio.representations.idm.SocioRepresentation;
import org.sistcoop.socio.representations.idm.TasaCuentaPersonalRepresentation;
import org.sistcoop.socio.representations.idm.TitularRepresentation;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RepresentationToModel {

    public SocioModel createSocio(SocioRepresentation rep, SocioProvider socioProvider) {
        return socioProvider.create(TipoPersona.valueOf(rep.getTipoPersona().toUpperCase()),
                rep.getTipoDocumento(), rep.getNumeroDocumento());
    }

    public CuentaPersonalModel createCuentaPersonal(CuentaPersonalRepresentation rep, SocioModel socioModel,
            CuentaPersonalProvider cuentaPersonalProvider, TitularProvider titularProvider,
            TasaCuentaPersonalProvider tasaCuentaPersonalProvider) {

        TitularRepresentation[] titulares = rep.getTitulares();
        TasaCuentaPersonalRepresentation[] tasas = rep.getTasas();

        CuentaPersonalModel cuentaPersonalModel = cuentaPersonalProvider.create(socioModel,
                TipoCuentaPersonal.valueOf(rep.getTipoCuenta().toUpperCase()), rep.getMoneda(),
                rep.getCantidadRetirantes(), rep.getFechaCierre());

        for (TitularRepresentation titularRepresentation : titulares) {
            titularProvider.create(cuentaPersonalModel, titularRepresentation.getTipoDocumento(),
                    titularRepresentation.getNumeroDocumento());
        }
        for (TasaCuentaPersonalRepresentation tasaCuentaPersonalRepresentation : tasas) {
            tasaCuentaPersonalProvider.create(cuentaPersonalModel,
                    tasaCuentaPersonalRepresentation.getDenominacion(),
                    tasaCuentaPersonalRepresentation.getValor());
        }

        return cuentaPersonalModel;
    }

    public AutorizadoModel createAutorizado(AutorizadoRepresentation representation,
            CuentaPersonalModel cuentaPersonalModel, AutorizadoProvider autorizadoProvider) {
        return autorizadoProvider.create(cuentaPersonalModel, representation.getTipoDocumento(),
                representation.getNumeroDocumento());
    }

    public BeneficiarioModel createBeneficiario(BeneficiarioRepresentation representation,
            CuentaPersonalModel cuentaPersonalModel, BeneficiarioProvider beneficiarioProvider) {
        return beneficiarioProvider.create(cuentaPersonalModel, representation.getTipoDocumento(),
                representation.getNumeroDocumento(), representation.getApellidoPaterno(),
                representation.getApellidoMaterno(), representation.getNombres(),
                representation.getPorcentajeBeneficio());
    }
}
