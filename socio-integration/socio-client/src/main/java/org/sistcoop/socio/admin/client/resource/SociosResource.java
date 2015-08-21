package org.sistcoop.socio.admin.client.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sistcoop.socio.representations.idm.SocioRepresentation;
import org.sistcoop.socio.representations.idm.search.SearchResultsRepresentation;

@Path("socios")
@Consumes(MediaType.APPLICATION_JSON)
public interface SociosResource {

    @Path("{socio}")
    public SocioResource socio(@PathParam("socio") String socio);

    @POST
    public Response create(SocioRepresentation representation);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SocioRepresentation> findAll();

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<SocioRepresentation> search(
            @QueryParam("tipoDocumento") String tipoDocumento,
            @QueryParam("numeroDocumento") String numeroDocumento,
            @QueryParam("tipoPersona") String tipoPersona,
            @QueryParam("estado") @DefaultValue(value = "true") boolean estado,
            @QueryParam("filterText") String filterText,
            @QueryParam("page") @DefaultValue(value = "1") int page,
            @QueryParam("pageSize") @DefaultValue(value = "20") int pageSize);

}