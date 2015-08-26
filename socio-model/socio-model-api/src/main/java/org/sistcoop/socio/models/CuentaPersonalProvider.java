package org.sistcoop.socio.models;

import java.util.List;

import javax.ejb.Local;

import org.sistcoop.socio.models.enums.TipoCuentaPersonal;
import org.sistcoop.socio.models.search.SearchCriteriaModel;
import org.sistcoop.socio.models.search.SearchResultsModel;
import org.sistcoop.socio.provider.Provider;

@Local
public interface CuentaPersonalProvider extends Provider {

    CuentaPersonalModel create(SocioModel socio, TipoCuentaPersonal tipoCuentaPersonal, String moneda,
            int cantidadRetirantes);

    boolean remove(CuentaPersonalModel cuentaPersonal);

    CuentaPersonalModel findById(String id);

    List<CuentaPersonalModel> findAll(SocioModel socio);

    SearchResultsModel<CuentaPersonalModel> search(SocioModel socio, SearchCriteriaModel criteria);

    SearchResultsModel<CuentaPersonalModel> search(SocioModel socio, SearchCriteriaModel criteria,
            String filterText);

}
