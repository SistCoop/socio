package org.sistcoop.socio.models;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import org.sistcoop.socio.models.enums.TipoCuentaPersonal;
import org.sistcoop.socio.provider.Provider;

@Local
public interface CuentaPersonalProvider extends Provider {

    CuentaPersonalModel create(SocioModel socio, TipoCuentaPersonal tipoCuenta, String moneda,
            int cantidadRetirantes, Date fechaCierre);

    boolean remove(CuentaPersonalModel cuentaPersonal);

    CuentaPersonalModel findById(String id);

    List<CuentaPersonalModel> findAll(SocioModel socio);

}
