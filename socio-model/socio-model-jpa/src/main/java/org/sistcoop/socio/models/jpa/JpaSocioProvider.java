package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.SocioProvider;
import org.sistcoop.socio.models.enums.EstadoCuentaAporte;
import org.sistcoop.socio.models.enums.Frecuencia;
import org.sistcoop.socio.models.enums.TipoPersona;
import org.sistcoop.socio.models.jpa.entities.ComisionSocioAsignadaEntity;
import org.sistcoop.socio.models.jpa.entities.ComisionSocioEntity;
import org.sistcoop.socio.models.jpa.entities.CuentaAporteEntity;
import org.sistcoop.socio.models.jpa.entities.CuentaAporteMonedaEntity;
import org.sistcoop.socio.models.jpa.entities.NumeroCuentaAporteEntity;
import org.sistcoop.socio.models.jpa.entities.SocioEntity;
import org.sistcoop.socio.models.search.SearchCriteriaModel;
import org.sistcoop.socio.models.search.SearchResultsModel;

@Named
@Stateless
@Local(SocioProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaSocioProvider extends AbstractHibernateStorage implements SocioProvider {

    @PersistenceContext
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    public SocioModel create(TipoPersona tipoPersona, String tipoDocumento, String numeroDocumento) {
        // Buscar moneda por defecto
        TypedQuery<CuentaAporteMonedaEntity> queryMonedas = em.createNamedQuery(
                "CuentaAporteMonedaEntity.findByEstado", CuentaAporteMonedaEntity.class);
        queryMonedas.setParameter("estado", true);
        List<CuentaAporteMonedaEntity> resultMonedas = queryMonedas.getResultList();
        CuentaAporteMonedaEntity cuentaAporteMonedaEntity = resultMonedas.get(0);

        // Buscar comisiones existentes
        TypedQuery<ComisionSocioEntity> queryComisiones = em.createNamedQuery(
                "ComisionSocioEntity.findByEstado", ComisionSocioEntity.class);
        queryComisiones.setParameter("estado", true);
        List<ComisionSocioEntity> resultComisiones = queryComisiones.getResultList();

        List<ComisionSocioEntity> resultComisionesDeInicio = new ArrayList<ComisionSocioEntity>();
        for (ComisionSocioEntity comisionSocioEntity : resultComisiones) {
            if (comisionSocioEntity.getFrecuencia().equals(Frecuencia.UNICO_INICIO)) {
                resultComisionesDeInicio.add(comisionSocioEntity);
            }
        }

        // Crear
        Set<ComisionSocioAsignadaEntity> comisiones = new HashSet<>();
        for (ComisionSocioEntity comisionProgramada : resultComisiones) {
            ComisionSocioAsignadaEntity comisionAsignada = new ComisionSocioAsignadaEntity();
            comisionAsignada.setDenominacion(comisionProgramada.getDenominacion());
            comisionAsignada.setFrecuencia(comisionProgramada.getFrecuencia());
            comisionAsignada.setTipoValor(comisionProgramada.getTipoValor());
            comisionAsignada.setValor(comisionProgramada.getValor());
            comisionAsignada.setEstado(comisionProgramada.isEstado());
            comisiones.add(comisionAsignada);
        }

        NumeroCuentaAporteEntity numeroCuentaAporteEntity = new NumeroCuentaAporteEntity();
        CuentaAporteEntity cuentaAporteEntity = new CuentaAporteEntity();
        cuentaAporteEntity.setEstado(resultComisionesDeInicio.isEmpty() ? EstadoCuentaAporte.ACTIVO
                : EstadoCuentaAporte.POR_ACTIVAR);
        cuentaAporteEntity.setMoneda(cuentaAporteMonedaEntity.getMoneda());
        cuentaAporteEntity.setNumeroCuenta(numeroCuentaAporteEntity);
        cuentaAporteEntity.setSaldo(BigDecimal.ZERO);

        SocioEntity socioEntity = new SocioEntity();
        socioEntity.setTipoPersona(tipoPersona);
        socioEntity.setTipoDocumento(tipoDocumento);
        socioEntity.setNumeroDocumento(numeroDocumento);
        socioEntity.setFechaInicio(Calendar.getInstance().getTime());
        socioEntity.setEstado(resultComisionesDeInicio.isEmpty() ? true : false);
        socioEntity.setCuentaAporte(cuentaAporteEntity);
        socioEntity.setComisione(comisiones);

        em.persist(socioEntity);
        return new SocioAdapter(em, socioEntity);
    }

    @Override
    public boolean remove(SocioModel socioModel) {
        SocioEntity socioEntity = em.find(SocioEntity.class, socioModel.getId());
        if (socioEntity == null) {
            return false;
        }
        em.remove(socioEntity);
        return true;
    }

    @Override
    public SocioModel findById(String id) {
        SocioEntity socioEntity = this.em.find(SocioEntity.class, id);
        return socioEntity != null ? new SocioAdapter(em, socioEntity) : null;
    }

    @Override
    public List<SocioModel> findAll() {
        TypedQuery<SocioEntity> query = em.createNamedQuery("SocioEntity.findAll", SocioEntity.class);
        List<SocioEntity> list = query.getResultList();
        List<SocioModel> result = new ArrayList<>();
        for (SocioEntity entity : list) {
            result.add(new SocioAdapter(em, entity));
        }
        return result;
    }

    @Override
    public SearchResultsModel<SocioModel> search(SearchCriteriaModel criteria) {
        SearchResultsModel<SocioEntity> entityResult = find(criteria, SocioEntity.class);

        SearchResultsModel<SocioModel> modelResult = new SearchResultsModel<>();
        List<SocioModel> list = new ArrayList<>();
        for (SocioEntity entity : entityResult.getModels()) {
            list.add(new SocioAdapter(em, entity));
        }
        modelResult.setTotalSize(entityResult.getTotalSize());
        modelResult.setModels(list);
        return modelResult;
    }

    @Override
    public SearchResultsModel<SocioModel> search(SearchCriteriaModel criteria, String filterText) {
        SearchResultsModel<SocioEntity> entityResult = findFullText(criteria, SocioEntity.class, filterText,
                "tipoDocumento", "numeroDocumento");

        SearchResultsModel<SocioModel> modelResult = new SearchResultsModel<>();
        List<SocioModel> list = new ArrayList<>();
        for (SocioEntity entity : entityResult.getModels()) {
            list.add(new SocioAdapter(em, entity));
        }
        modelResult.setTotalSize(entityResult.getTotalSize());
        modelResult.setModels(list);
        return modelResult;
    }

}
