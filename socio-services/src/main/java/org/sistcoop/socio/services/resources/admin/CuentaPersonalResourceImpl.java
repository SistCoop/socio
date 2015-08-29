package org.sistcoop.socio.services.resources.admin;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PathParam;

import org.sistcoop.socio.admin.client.resource.AutorizadosResource;
import org.sistcoop.socio.admin.client.resource.BeneficiariosResource;
import org.sistcoop.socio.admin.client.resource.CuentaPersonalResource;
import org.sistcoop.socio.admin.client.resource.TitularesResource;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalProvider;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.representations.idm.CuentaPersonalRepresentation;
import org.sistcoop.socio.services.managers.CuentaPersonalManager;

@Stateless
public class CuentaPersonalResourceImpl implements CuentaPersonalResource {

    @PathParam("cuentaPersonal")
    private String cuentaPersonal;

    @Inject
    private CuentaPersonalProvider cuentaPersonalProvider;

    @Inject
    private CuentaPersonalManager cuentaPersonalManager;

    @Inject
    private AutorizadosResource autorizadosResource;

    @Inject
    private BeneficiariosResource beneficiariosResource;

    @Inject
    private TitularesResource titularesResource;

    private CuentaPersonalModel getCuentaPersonalModel() {
        return cuentaPersonalProvider.findById(cuentaPersonal);
    }

    @Override
    public CuentaPersonalRepresentation cuentaPersonal() {
        CuentaPersonalRepresentation rep = ModelToRepresentation.toRepresentation(getCuentaPersonalModel());
        if (rep != null) {
            return rep;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void update(CuentaPersonalRepresentation representation) {
        cuentaPersonalManager.update(getCuentaPersonalModel(), representation);
    }

    @Override
    public void enable() {
        throw new NotFoundException();
    }

    @Override
    public void disable() {
        cuentaPersonalManager.disable(getCuentaPersonalModel());
    }

    @Override
    public void remove() {
        throw new NotFoundException();
    }

    @Override
    public AutorizadosResource autorizados() {
        return autorizadosResource;
    }

    @Override
    public BeneficiariosResource beneficiarios() {
        return beneficiariosResource;
    }

    @Override
    public TitularesResource titulares() {
        return titularesResource;
    }

}
