package org.sistcoop.socio.services.resources.admin;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PathParam;

import org.sistcoop.socio.admin.client.resource.TitularResource;
import org.sistcoop.socio.models.TitularModel;
import org.sistcoop.socio.models.TitularProvider;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.representations.idm.TitularRepresentation;

@Stateless
public class TitularResourceImpl implements TitularResource {

    @PathParam("titular")
    private String titular;

    @Inject
    private TitularProvider titularProvider;

    private TitularModel getTitularModel() {
        return titularProvider.findById(titular);
    }

    @Override
    public TitularRepresentation titular() {
        TitularRepresentation rep = ModelToRepresentation.toRepresentation(getTitularModel());
        if (rep != null) {
            return rep;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void update(TitularRepresentation representation) {
        throw new NotFoundException();
    }

    @Override
    public void remove() {
        throw new NotFoundException();
    }

}
