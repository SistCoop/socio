package org.sistcoop.socio.models;

import java.util.List;

import javax.ejb.Local;

import org.sistcoop.socio.provider.Provider;

@Local
public interface AutorizadoProvider extends Provider {

    AutorizadoModel create(CuentaPersonalModel cuentaPersonal, String tipoDocumento, String numeroDocumento);

    boolean remove(AutorizadoModel autorizado);

    AutorizadoModel findById(String id);

    List<AutorizadoModel> findAll(CuentaPersonalModel cuentaPersonal);

}
