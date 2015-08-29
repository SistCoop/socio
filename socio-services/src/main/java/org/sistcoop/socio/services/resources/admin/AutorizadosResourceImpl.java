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
import org.sistcoop.socio.admin.client.resource.AutorizadoResource;
import org.sistcoop.socio.admin.client.resource.AutorizadosResource;
import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.AutorizadoProvider;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalProvider;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.models.utils.RepresentationToModel;
import org.sistcoop.socio.representations.idm.AutorizadoRepresentation;

@Stateless
public class AutorizadosResourceImpl implements AutorizadosResource {

    @PathParam("cuentaPersonal")
    private String cuentaPersonal;

    @Inject
    private CuentaPersonalProvider cuentaPersonalProvider;

    @Inject
    private AutorizadoProvider autorizadoProvider;

    @Inject
    private RepresentationToModel representationToModel;

    @Inject
    private AutorizadoResource autorizadoResource;

    @Context
    private UriInfo uriInfo;

    private CuentaPersonalModel getCuentaPersonalModel() {
        return cuentaPersonalProvider.findById(cuentaPersonal);
    }

    @Override
    public AutorizadoResource autorizado(String autorizado) {
        return autorizadoResource;
    }

    @Override
    public Response create(AutorizadoRepresentation representation) {
        AutorizadoModel model = representationToModel.createAutorizado(representation,
                getCuentaPersonalModel(), autorizadoProvider);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build())
                .header("Access-Control-Expose-Headers", "Location")
                .entity(Jsend.getSuccessJSend(model.getId())).build();
    }

    @Override
    public List<AutorizadoRepresentation> findAll() {
        List<AutorizadoModel> results = autorizadoProvider.findAll(getCuentaPersonalModel());
        List<AutorizadoRepresentation> rep = new ArrayList<>();
        for (AutorizadoModel model : results) {
            rep.add(ModelToRepresentation.toRepresentation(model));
        }
        return rep;
    }

}
