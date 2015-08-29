package org.sistcoop.socio.models;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Local;

import org.sistcoop.socio.provider.Provider;

@Local
public interface BeneficiarioProvider extends Provider {

    BeneficiarioModel create(CuentaPersonalModel cuentaPersonal, String tipoDocumento,
            String numeroDocumento, String apellidoPaterno, String apellidoMaterno, String nombres,
            BigDecimal porcentajeBeneficio);

    boolean remove(BeneficiarioModel autorizado);

    BeneficiarioModel findById(String id);

    List<BeneficiarioModel> findAll(CuentaPersonalModel cuentaPersonal);

}
