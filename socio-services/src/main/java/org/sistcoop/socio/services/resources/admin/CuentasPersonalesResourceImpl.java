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
import org.sistcoop.socio.admin.client.resource.CuentaPersonalResource;
import org.sistcoop.socio.admin.client.resource.CuentasPersonalesResource;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalProvider;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.SocioProvider;
import org.sistcoop.socio.models.TasaCuentaPersonalProvider;
import org.sistcoop.socio.models.TitularProvider;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.models.utils.RepresentationToModel;
import org.sistcoop.socio.representations.idm.CuentaPersonalRepresentation;

@Stateless
public class CuentasPersonalesResourceImpl implements CuentasPersonalesResource {

    @PathParam("socio")
    private String socio;

    @Inject
    private SocioProvider socioProvider;

    @Inject
    private CuentaPersonalProvider cuentaPersonalProvider;

    @Inject
    private TitularProvider titularProvider;

    @Inject
    private TasaCuentaPersonalProvider tasaCuentaPersonalProvider;

    @Inject
    private RepresentationToModel representationToModel;

    @Inject
    private CuentaPersonalResource cuentaPersonalResource;

    @Context
    private UriInfo uriInfo;

    private SocioModel getSocioModel() {
        return socioProvider.findById(socio);
    }

    @Override
    public CuentaPersonalResource cuentaPersonal(String cuentaPersonal) {
        return cuentaPersonalResource;
    }

    @Override
    public Response create(CuentaPersonalRepresentation representation) {
        CuentaPersonalModel model = representationToModel.createCuentaPersonal(representation,
                getSocioModel(), cuentaPersonalProvider, titularProvider, tasaCuentaPersonalProvider);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build())
                .header("Access-Control-Expose-Headers", "Location")
                .entity(Jsend.getSuccessJSend(model.getId())).build();
    }

    @Override
    public List<CuentaPersonalRepresentation> findAll() {
        List<CuentaPersonalModel> results = cuentaPersonalProvider.findAll(getSocioModel());
        List<CuentaPersonalRepresentation> rep = new ArrayList<>();
        for (CuentaPersonalModel model : results) {
            rep.add(ModelToRepresentation.toRepresentation(model));
        }
        return rep;
    }

}
