package org.sistcoop.socio.models;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import org.sistcoop.socio.provider.Provider;

@Local
public interface TasaCuentaPersonalProvider extends Provider {

    TasaCuentaPersonalModel create(CuentaPersonalModel cuentaPersonalModel, String tipoDocumento,
            BigDecimal bigDecimal);

    boolean remove(TasaCuentaPersonalModel titular);

    TasaCuentaPersonalModel findById(String id);

    List<TasaCuentaPersonalModel> findAll(CuentaPersonalModel cuentaPersonal);

}
