package org.sistcoop.socio.models.jpa;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.SocioProvider;
import org.sistcoop.socio.models.enums.TipoPersona;

@Named
@Stateless
@Local(SocioProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaSocioProvider implements SocioProvider {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public SocioModel addSocio(TipoPersona tipoPersona, String tipoDocumento, String numeroDocumento, String tipoDocumentoRepresentanteLegal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeSocio(SocioModel socioModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SocioModel getSocioById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SocioModel getSocioByTipoNumeroDocumento(String tipoDocumento, String numeroDocumento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSociosCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SocioModel> getSocios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SocioModel> getSocios(String filterText) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SocioModel> getSocios(int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SocioModel> getSocios(String filterText, int firstResult, int maxResults) {
		// TODO Auto-generated method stub
		return null;
	}

}
