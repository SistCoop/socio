package org.sistcoop.socio.models;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import org.sistcoop.socio.models.enums.TipoCuentaPersonal;
import org.sistcoop.socio.provider.Provider;

@Local
public interface TitularProvider extends Provider {

    TitularModel create(SocioModel socio, TipoCuentaPersonal tipoCuenta, List<TitularModel> titulares,
            List<TasaCuentaPersonalModel> tasas, String moneda, int cantidadRetirantes, Date fechaCierre);

    boolean remove(TitularModel titular);

    TitularModel findById(String id);

    List<TitularModel> findAll(CuentaPersonalModel cuentaPersonal);

}
