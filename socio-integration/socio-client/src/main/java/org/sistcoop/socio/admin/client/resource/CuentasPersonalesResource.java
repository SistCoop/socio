package org.sistcoop.socio.admin.client.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sistcoop.socio.representations.idm.CuentaPersonalRepresentation;

@Consumes(MediaType.APPLICATION_JSON)
public interface CuentasPersonalesResource {

    @Path("{cuentaPersonal}")
    public CuentaPersonalResource cuentaPersonal(@PathParam("cuentaPersonal") String cuentaPersonal);

    @POST
    public Response create(CuentaPersonalRepresentation representation);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CuentaPersonalRepresentation> findAll();

}