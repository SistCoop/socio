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
import org.sistcoop.socio.models.search.PagingModel;
import org.sistcoop.socio.models.search.SearchCriteriaFilterOperator;
import org.sistcoop.socio.models.search.SearchCriteriaModel;
import org.sistcoop.socio.models.search.SearchResultsModel;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.models.utils.RepresentationToModel;
import org.sistcoop.socio.representations.idm.CuentaPersonalRepresentation;
import org.sistcoop.socio.representations.idm.search.SearchResultsRepresentation;

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

    @Override
    public SearchResultsRepresentation<CuentaPersonalRepresentation> search(String tipoCuenta,
            String numeroCuenta, String moneda, boolean estado, String filterText, int page, int pageSize) {

        PagingModel paging = new PagingModel();
        paging.setPage(page);
        paging.setPageSize(pageSize);

        SearchCriteriaModel searchCriteriaBean = new SearchCriteriaModel();
        searchCriteriaBean.setPaging(paging);

        if (tipoCuenta != null) {
            searchCriteriaBean.addFilter("tipoCuenta", tipoCuenta, SearchCriteriaFilterOperator.eq);
        }
        if (numeroCuenta != null) {
            searchCriteriaBean.addFilter("numeroCuenta", numeroCuenta, SearchCriteriaFilterOperator.eq);
        }
        if (moneda != null) {
            searchCriteriaBean.addFilter("moneda", moneda, SearchCriteriaFilterOperator.eq);
        }
        searchCriteriaBean.addFilter("estado", estado, SearchCriteriaFilterOperator.bool_eq);

        SearchResultsModel<CuentaPersonalModel> results = null;
        if (filterText != null) {
            results = cuentaPersonalProvider.search(getSocioModel(), searchCriteriaBean);
        } else {
            results = cuentaPersonalProvider.search(getSocioModel(), searchCriteriaBean, filterText);
        }

        SearchResultsRepresentation<CuentaPersonalRepresentation> rep = new SearchResultsRepresentation<>();
        List<CuentaPersonalRepresentation> representations = new ArrayList<>();
        for (CuentaPersonalModel model : results.getModels()) {
            representations.add(ModelToRepresentation.toRepresentation(model));
        }

        rep.setTotalSize(results.getTotalSize());
        rep.setItems(representations);
        return rep;
    }
}
