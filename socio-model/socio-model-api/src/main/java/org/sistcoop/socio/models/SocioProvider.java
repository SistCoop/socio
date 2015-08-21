package org.sistcoop.socio.models;

import java.util.List;

import javax.ejb.Local;

import org.sistcoop.socio.models.enums.TipoPersona;
import org.sistcoop.socio.models.search.SearchCriteriaModel;
import org.sistcoop.socio.models.search.SearchResultsModel;
import org.sistcoop.socio.provider.Provider;

@Local
public interface SocioProvider extends Provider {

    SocioModel create(TipoPersona tipoPersona, String tipoDocumento, String numeroDocumento);

    boolean remove(SocioModel socioModel);

    SocioModel findById(String id);

    SocioModel findByTipoNumeroDocumento(String tipoDocumento, String numeroDocumento);

    List<SocioModel> findAll();

    SearchResultsModel<SocioModel> search(SearchCriteriaModel searchCriteriaBean);

    SearchResultsModel<SocioModel> search(SearchCriteriaModel searchCriteriaBean, String FfilterText);

}
