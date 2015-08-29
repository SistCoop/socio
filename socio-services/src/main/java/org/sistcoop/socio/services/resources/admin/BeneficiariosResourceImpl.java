package org.sistcoop.socio.services.resources.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.sistcoop.socio.Jsend;
import org.sistcoop.socio.admin.client.resource.BeneficiarioResource;
import org.sistcoop.socio.admin.client.resource.BeneficiariosResource;
import org.sistcoop.socio.models.BeneficiarioModel;
import org.sistcoop.socio.models.BeneficiarioProvider;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalProvider;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.models.utils.RepresentationToModel;
import org.sistcoop.socio.representations.idm.BeneficiarioRepresentation;

@Stateless
public class BeneficiariosResourceImpl implements BeneficiariosResource {

    @PathParam("cuentaPersonal")
    private String cuentaPersonal;

    @Inject
    private CuentaPersonalProvider cuentaPersonalProvider;

    @Inject
    private BeneficiarioProvider beneficiarioProvider;

    @Inject
    private RepresentationToModel representationToModel;

    @Inject
    private BeneficiarioResource beneficiarioResource;

    @Context
    private UriInfo uriInfo;

    private CuentaPersonalModel getCuentaPersonalModel() {
        return cuentaPersonalProvider.findById(cuentaPersonal);
    }

    @Override
    public BeneficiarioResource beneficiario(String beneficiario) {
        return beneficiarioResource;
    }

    @Override
    public Response create(BeneficiarioRepresentation representation) {
        BeneficiarioModel model = representationToModel.createBeneficiario(representation,
                getCuentaPersonalModel(), beneficiarioProvider);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build())
                .header("Access-Control-Expose-Headers", "Location")
                .entity(Jsend.getSuccessJSend(model.getId())).build();
    }

    @Override
    public List<BeneficiarioRepresentation> findAll() {
        List<BeneficiarioModel> results = beneficiarioProvider.findAll(getCuentaPersonalModel());
        List<BeneficiarioRepresentation> rep = new ArrayList<>();
        for (BeneficiarioModel model : results) {
            rep.add(ModelToRepresentation.toRepresentation(model));
        }
        return rep;
    }

}
