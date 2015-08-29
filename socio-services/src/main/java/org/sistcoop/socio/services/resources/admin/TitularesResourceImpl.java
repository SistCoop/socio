package org.sistcoop.socio.services.resources.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.sistcoop.socio.admin.client.resource.TitularResource;
import org.sistcoop.socio.admin.client.resource.TitularesResource;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalProvider;
import org.sistcoop.socio.models.TitularModel;
import org.sistcoop.socio.models.TitularProvider;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.representations.idm.TitularRepresentation;

@Stateless
public class TitularesResourceImpl implements TitularesResource {

    @PathParam("cuentaPersonal")
    private String cuentaPersonal;

    @Inject
    private CuentaPersonalProvider cuentaPersonalProvider;

    @Inject
    private TitularProvider titularProvider;

    @Inject
    private TitularResource titularResource;

    @Context
    private UriInfo uriInfo;

    private CuentaPersonalModel getCuentaPersonalModel() {
        return cuentaPersonalProvider.findById(cuentaPersonal);
    }

    @Override
    public TitularResource titular(String titular) {
        return titularResource;
    }

    @Override
    public Response create(TitularRepresentation representation) {
        throw new NotFoundException();
    }

    @Override
    public List<TitularRepresentation> findAll() {
        List<TitularModel> results = titularProvider.findAll(getCuentaPersonalModel());
        List<TitularRepresentation> rep = new ArrayList<>();
        for (TitularModel model : results) {
            rep.add(ModelToRepresentation.toRepresentation(model));
        }
        return rep;
    }

}
