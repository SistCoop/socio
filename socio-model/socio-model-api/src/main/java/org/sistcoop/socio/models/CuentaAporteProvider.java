package org.sistcoop.socio.models;

import javax.ejb.Local;

import org.sistcoop.socio.provider.Provider;

@Local
public interface CuentaAporteProvider extends Provider {

    CuentaAporteModel findById(String id);

    CuentaAporteModel findBySocio(SocioModel socio);

}
