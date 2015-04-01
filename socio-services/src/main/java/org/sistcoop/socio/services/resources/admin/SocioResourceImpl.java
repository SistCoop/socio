package org.sistcoop.socio.services.resources.admin;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.sistcoop.socio.admin.client.resource.SocioResource;
import org.sistcoop.socio.models.SocioProvider;
import org.sistcoop.socio.models.utils.RepresentationToModel;
import org.sistcoop.socio.representations.idm.SocioRepresentation;

@Stateless
public class SocioResourceImpl implements SocioResource {

	@Inject
	private SocioProvider socioProvider;

	@Inject
	private RepresentationToModel representationToModel;

	@Context
	private UriInfo uriInfo;

	@Override
	public SocioRepresentation findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SocioRepresentation findByTipoNumeroDocumento(String tipoDocumento, String numeroDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response create(SocioRepresentation socioRepresentation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateById(Long id, SocioRepresentation socioRepresentation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateByTipoNumeroDocumento(String tipoDocumento, String numeroDocumento, SocioRepresentation socioRepresentation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeByTipoNumeroDocumento(String tipoDocumento, String numeroDocumento) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SocioRepresentation> listAll(String filterText, Integer firstResult, Integer maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

}
