package org.sistcoop.socio.services.resources.admin;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.sistcoop.socio.Jsend;
import org.sistcoop.socio.admin.client.resource.SocioResource;
import org.sistcoop.socio.admin.client.resource.SociosResource;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.SocioProvider;
import org.sistcoop.socio.models.enums.TipoPersona;
import org.sistcoop.socio.models.search.PagingModel;
import org.sistcoop.socio.models.search.SearchCriteriaFilterOperator;
import org.sistcoop.socio.models.search.SearchCriteriaModel;
import org.sistcoop.socio.models.search.SearchResultsModel;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.models.utils.RepresentationToModel;
import org.sistcoop.socio.representations.idm.SocioRepresentation;
import org.sistcoop.socio.representations.idm.search.SearchResultsRepresentation;

@Stateless
public class SociosResourceImpl implements SociosResource {

    @Inject
    private RepresentationToModel representationToModel;

    @Inject
    private SocioProvider socioProvider;

    @Inject
    private SocioResource socioResource;

    @Context
    private UriInfo uriInfo;

    @Override
    public SocioResource socio(String socio) {
        return socioResource;
    }

    @Override
    public Response create(SocioRepresentation representation) {
        SocioModel model = representationToModel.createSocio(representation, socioProvider);
        return Response.created(uriInfo.getAbsolutePathBuilder().path(model.getId()).build())
                .header("Access-Control-Expose-Headers", "Location")
                .entity(Jsend.getSuccessJSend(model.getId())).build();
    }

    @Override
    public List<SocioRepresentation> findAll() {
        List<SocioModel> results = socioProvider.findAll();
        List<SocioRepresentation> rep = new ArrayList<SocioRepresentation>();
        for (SocioModel model : results) {
            rep.add(ModelToRepresentation.toRepresentation(model));
        }
        return rep;
    }

    @Override
    public SearchResultsRepresentation<SocioRepresentation> search(String tipoDocumento,
            String numeroDocumento, String tipoPersona, boolean estado, String filterText, int page,
            int pageSize) {

        PagingModel paging = new PagingModel();
        paging.setPage(page);
        paging.setPageSize(pageSize);

        SearchCriteriaModel searchCriteriaBean = new SearchCriteriaModel();
        searchCriteriaBean.setPaging(paging);

        if (tipoDocumento != null) {
            searchCriteriaBean.addFilter("tipoDocumento", tipoDocumento, SearchCriteriaFilterOperator.eq);
        }
        if (numeroDocumento != null) {
            searchCriteriaBean.addFilter("numeroDocumento", numeroDocumento, SearchCriteriaFilterOperator.eq);
        }
        if (tipoPersona != null) {
            searchCriteriaBean.addFilter("tipoPersona", TipoPersona.valueOf(tipoPersona.toUpperCase()),
                    SearchCriteriaFilterOperator.eq);
        }
        searchCriteriaBean.addFilter("estado", estado, SearchCriteriaFilterOperator.bool_eq);

        SearchResultsModel<SocioModel> results = null;
        if (filterText != null) {
            results = socioProvider.search(searchCriteriaBean);
        } else {
            results = socioProvider.search(searchCriteriaBean, filterText);
        }

        SearchResultsRepresentation<SocioRepresentation> rep = new SearchResultsRepresentation<>();
        List<SocioRepresentation> representations = new ArrayList<>();
        for (SocioModel model : results.getModels()) {
            representations.add(ModelToRepresentation.toRepresentation(model));
        }

        rep.setTotalSize(results.getTotalSize());
        rep.setItems(representations);
        return rep;
    }

}
