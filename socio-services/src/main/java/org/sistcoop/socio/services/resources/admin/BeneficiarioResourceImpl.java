package org.sistcoop.socio.services.resources.admin;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PathParam;

import org.sistcoop.socio.admin.client.resource.BeneficiarioResource;
import org.sistcoop.socio.models.BeneficiarioModel;
import org.sistcoop.socio.models.BeneficiarioProvider;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.representations.idm.BeneficiarioRepresentation;
import org.sistcoop.socio.services.managers.BeneficiarioManager;

@Stateless
public class BeneficiarioResourceImpl implements BeneficiarioResource {

    @PathParam("beneficiario")
    private String beneficiario;

    @Inject
    private BeneficiarioProvider beneficiarioProvider;

    @Inject
    private BeneficiarioManager beneficiarioManager;

    private BeneficiarioModel getBeneficiarioModel() {
        return beneficiarioProvider.findById(beneficiario);
    }

    @Override
    public BeneficiarioRepresentation beneficiario() {
        BeneficiarioRepresentation rep = ModelToRepresentation.toRepresentation(getBeneficiarioModel());
        if (rep != null) {
            return rep;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void update(BeneficiarioRepresentation representation) {
        beneficiarioManager.update(getBeneficiarioModel(), representation);
    }

    @Override
    public void remove() {
        boolean result = beneficiarioProvider.remove(getBeneficiarioModel());
        if (!result) {
            throw new InternalServerErrorException();
        }
    }

}
