package org.sistcoop.socio.models;

import java.util.List;

import javax.ejb.Local;

import org.sistcoop.socio.models.enums.TipoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoPersona;
import org.sistcoop.socio.models.search.SearchCriteriaModel;
import org.sistcoop.socio.models.search.SearchResultsModel;
import org.sistcoop.socio.provider.Provider;

@Local
public interface CuentaPersonalProvider extends Provider {

    CuentaPersonalModel create(SocioModel socioModel, TipoCuentaPersonal tipoCuentaPersonal, String moneda,
            int cantidadRetirantes);

    boolean remove(CuentaPersonalModel cuentaPersonalModel);

    CuentaPersonalModel findById(String id);

    List<CuentaPersonalModel> findAll(SocioModel socioModel);

    SearchResultsModel<CuentaPersonalModel> search(SocioModel socioModel,
            SearchCriteriaModel searchCriteriaBean);

    SearchResultsModel<CuentaPersonalModel> search(SocioModel socioModel,
            SearchCriteriaModel searchCriteriaBean, String filterText);

}
