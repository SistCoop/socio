package org.sistcoop.socio.models;

import java.util.List;

import javax.ejb.Local;

import org.sistcoop.socio.models.enums.TipoPersona;
import org.sistcoop.socio.provider.Provider;

@Local
public interface SocioProvider extends Provider {

	SocioModel addSocio(
			TipoPersona tipoPersona, 
			String tipoDocumento, 
			String numeroDocumento, 
			String tipoDocumentoRepresentanteLegal);

	boolean removeSocio(SocioModel socioModel);

	SocioModel getSocioById(Long id);

	SocioModel getSocioByTipoNumeroDocumento(String tipoDocumento, String numeroDocumento);

	int getSociosCount();

	List<SocioModel> getSocios();

	List<SocioModel> getSocios(String filterText);

	List<SocioModel> getSocios(int firstResult, int maxResults);

	List<SocioModel> getSocios(String filterText, int firstResult, int maxResults);

}
