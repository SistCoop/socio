package org.sistcoop.socio.admin.client.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sistcoop.socio.representations.idm.BeneficiarioRepresentation;

public interface BeneficiarioResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BeneficiarioRepresentation beneficiario();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(BeneficiarioRepresentation representation);

    @DELETE
    public void remove();

}