package org.sistcoop.socio.models;

import java.util.List;

import javax.ejb.Local;

import org.sistcoop.socio.provider.Provider;

@Local
public interface TitularProvider extends Provider {

    TitularModel create(CuentaPersonalModel cuentaPersonal, String tipoDocumento, String numeroDocumento);

    boolean remove(TitularModel titular);

    TitularModel findById(String id);

    List<TitularModel> findAll(CuentaPersonalModel cuentaPersonal);

}
