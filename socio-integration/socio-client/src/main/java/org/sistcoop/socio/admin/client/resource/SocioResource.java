package org.sistcoop.socio.admin.client.resource;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.NotBlank;
import org.sistcoop.socio.representations.idm.SocioRepresentation;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/socios")
public interface SocioResource {

	@GET
	@Path("/{id}")
	public SocioRepresentation findById(
			@PathParam("id") 
			@NotNull 
			@Min(value = 1) Long id);

	@GET
	@Path("/tipoDocumento/{tipoDocumento}/numeroDocumento/{numeroDocumento}")
	public SocioRepresentation findByTipoNumeroDocumento(
			@PathParam("tipoDocumento") 
			@NotNull 
			@NotBlank
			@Size(min = 1, max = 20) String tipoDocumento,
			
			@PathParam("numeroDocumento") 
			@NotNull 
			@NotBlank
			@Size(min = 1, max = 20) String numeroDocumento);
	
	@POST
	public Response create(
			@NotNull
			@Valid SocioRepresentation socioRepresentation);

	@PUT
	@Path("/{id}")
	public void updateById(
			@PathParam("id") 
			@NotNull 
			@Min(value = 1) Long id,
			
			@NotNull
			@Valid SocioRepresentation socioRepresentation);

	@PUT
	@Path("/tipoDocumento/{tipoDocumento}/numeroDocumento/{numeroDocumento}")
	public void updateByTipoNumeroDocumento(
			@PathParam("tipoDocumento") 
			@NotNull 
			@NotBlank
			@Size(min = 1, max = 20) String tipoDocumento,
			
			@PathParam("numeroDocumento") 
			@NotNull 
			@NotBlank
			@Size(min = 1, max = 20) String numeroDocumento, 
			
			@NotNull
			@Valid SocioRepresentation socioRepresentation);
		
	@DELETE
	@Path("/{id}")
	public void removeById(
			@PathParam("id") 
			@NotNull 
			@Min(value = 1) Long id);

	@DELETE
	@Path("/tipoDocumento/{tipoDocumento}/numeroDocumento/{numeroDocumento}")
	public void removeByTipoNumeroDocumento(
			@PathParam("tipoDocumento") 
			@NotNull 
			@NotBlank
			@Size(min = 1, max = 20) String tipoDocumento,
			
			@PathParam("numeroDocumento") 
			@NotNull 
			@NotBlank
			@Size(min = 1, max = 20) String numeroDocumento);
		
	@GET	
	public List<SocioRepresentation> listAll(
			@QueryParam("filterText")
			@Size(min = 1, max = 100) String filterText, 
			
			@QueryParam("firstResult") 
			@Min(value = 0) Integer firstResult, 
			
			@QueryParam("maxResults") 
			@Min(value = 1) Integer maxResults);

	@GET
	@Path("/count")	
	public int countAll();
	
}