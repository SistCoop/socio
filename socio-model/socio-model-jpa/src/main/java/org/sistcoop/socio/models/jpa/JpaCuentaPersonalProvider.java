package org.sistcoop.socio.models.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.sistcoop.socio.models.CuentaPersonalModel;
import org.sistcoop.socio.models.CuentaPersonalProvider;
import org.sistcoop.socio.models.SocioModel;
import org.sistcoop.socio.models.TasaCuentaPersonalModel;
import org.sistcoop.socio.models.TitularModel;
import org.sistcoop.socio.models.enums.EstadoCuentaPersonal;
import org.sistcoop.socio.models.enums.TipoCuentaPersonal;
import org.sistcoop.socio.models.jpa.entities.CuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.NumeroCuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.SocioEntity;
import org.sistcoop.socio.models.jpa.entities.TasaCuentaPersonalEntity;
import org.sistcoop.socio.models.jpa.entities.TitularEntity;
import org.sistcoop.socio.models.search.PagingModel;
import org.sistcoop.socio.models.search.SearchCriteriaModel;
import org.sistcoop.socio.models.search.SearchResultsModel;

@Named
@Stateless
@Local(CuentaPersonalProvider.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JpaCuentaPersonalProvider extends AbstractHibernateStorage implements CuentaPersonalProvider {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void close() {
        // TODO Auto-generated method stub
    }

    @Override
    public CuentaPersonalModel create(SocioModel socio, TipoCuentaPersonal tipoCuenta,
            List<TitularModel> titulares, List<TasaCuentaPersonalModel> tasas, String moneda,
            int cantidadRetirantes, Date fechaCierre) {

        SocioEntity socioEntity = this.em.find(SocioEntity.class, socio.getId());

        Set<TitularEntity> titularesEntity = new HashSet<>();
        for (TitularModel titularModel : titulares) {
            TitularEntity titularEntity = this.em.find(TitularEntity.class, titularModel.getId());
            titularesEntity.add(titularEntity);
        }

        Set<TasaCuentaPersonalEntity> tasasEntity = new HashSet<>();
        for (TasaCuentaPersonalModel tasaCuentaPersonalModel : tasas) {
            TasaCuentaPersonalEntity tasaCuentaPersonalEntity = this.em.find(TasaCuentaPersonalEntity.class,
                    tasaCuentaPersonalModel.getId());
            tasasEntity.add(tasaCuentaPersonalEntity);
        }

        NumeroCuentaPersonalEntity numeroCuentaPersonalEntity = new NumeroCuentaPersonalEntity();
        CuentaPersonalEntity cuentaPersonalEntity = new CuentaPersonalEntity();
        cuentaPersonalEntity.setTipoCuenta(tipoCuenta);
        cuentaPersonalEntity.setMoneda(moneda);
        cuentaPersonalEntity.setCantidadRetirantes(cantidadRetirantes);
        cuentaPersonalEntity.setNumeroCuenta(numeroCuentaPersonalEntity);
        cuentaPersonalEntity.setSaldo(BigDecimal.ZERO);
        cuentaPersonalEntity.setFechaApertura(Calendar.getInstance().getTime());
        cuentaPersonalEntity.setFechaCierre(fechaCierre);
        cuentaPersonalEntity
                .setEstado(tipoCuenta.equals(TipoCuentaPersonal.PLAZO_FIJO) ? EstadoCuentaPersonal.POR_ACTIVAR
                        : EstadoCuentaPersonal.ACTIVO);
        cuentaPersonalEntity.setSocio(socioEntity);
        cuentaPersonalEntity.setTasas(tasasEntity);
        cuentaPersonalEntity.setTitulares(titularesEntity);

        em.persist(cuentaPersonalEntity);
        return new CuentaPersonalAdapter(em, cuentaPersonalEntity);
    }

    @Override
    public boolean remove(CuentaPersonalModel cuentaPersonal) {
        CuentaPersonalEntity cuentaPersonalEntity = em.find(CuentaPersonalEntity.class,
                cuentaPersonal.getId());
        if (cuentaPersonalEntity == null) {
            return false;
        }
        em.remove(cuentaPersonalEntity);
        return true;
    }

    @Override
    public CuentaPersonalModel findById(String id) {
        CuentaPersonalEntity cuentaPersonalEntity = this.em.find(CuentaPersonalEntity.class, id);
        return cuentaPersonalEntity != null ? new CuentaPersonalAdapter(em, cuentaPersonalEntity) : null;
    }

    @Override
    public List<CuentaPersonalModel> findAll(SocioModel socio) {
        SocioEntity socioEntity = this.em.find(SocioEntity.class, socio.getId());
        Set<CuentaPersonalEntity> list = socioEntity.getCuentasPersonales();
        List<CuentaPersonalModel> result = new ArrayList<>();
        for (CuentaPersonalEntity entity : list) {
            result.add(new CuentaPersonalAdapter(em, entity));
        }
        return result;
    }

    @Override
    public SearchResultsModel<CuentaPersonalModel> search(SocioModel socio, SearchCriteriaModel criteria) {
        SearchResultsModel<CuentaPersonalEntity> results = new SearchResultsModel<>();
        Session session = getSession();

        // Set some default in the case that paging information was not
        // included in the request.
        PagingModel paging = criteria.getPaging();
        if (paging == null) {
            paging = new PagingModel();
            paging.setPage(1);
            paging.setPageSize(20);
        }
        int page = paging.getPage();
        int pageSize = paging.getPageSize();
        int start = (page - 1) * pageSize;

        Criteria criteriaQuery = session.createCriteria(CuentaPersonalEntity.class);
        applySearchCriteriaToQuery(criteria, CuentaPersonalEntity.class, criteriaQuery, false);
        criteriaQuery.createAlias("SocioEntity", "socio", JoinType.INNER_JOIN);
        criteriaQuery.add(Restrictions.eq("socio.id", socio.getId()));
        criteriaQuery.setFirstResult(start);
        criteriaQuery.setMaxResults(pageSize + 1);
        boolean hasMore = false;

        // Now query for the actual results
        @SuppressWarnings("unchecked")
        List<CuentaPersonalEntity> resultList = criteriaQuery.list();

        // Check if we got back more than we actually needed.
        if (resultList.size() > pageSize) {
            resultList.remove(resultList.size() - 1);
            hasMore = true;
        }

        // If there are more results than we needed, then we will need to do
        // another
        // query to determine how many rows there are in total
        int totalSize = start + resultList.size();
        if (hasMore) {
            Criteria criteriaQuery1 = session.createCriteria(CuentaPersonalEntity.class);
            applySearchCriteriaToQuery(criteria, CuentaPersonalEntity.class, criteriaQuery1, true);
            criteriaQuery1.createAlias("SocioEntity", "socio", JoinType.INNER_JOIN);
            criteriaQuery.add(Restrictions.eq("socio.id", socio.getId()));
            criteriaQuery1.setProjection(Projections.rowCount());
            totalSize = ((Long) criteriaQuery1.uniqueResult()).intValue();
        }
        results.setTotalSize(totalSize);
        results.setModels(resultList);

        SearchResultsModel<CuentaPersonalEntity> entityResult = results;
        SearchResultsModel<CuentaPersonalModel> modelResult = new SearchResultsModel<>();
        List<CuentaPersonalModel> list = new ArrayList<>();
        for (CuentaPersonalEntity entity : entityResult.getModels()) {
            list.add(new CuentaPersonalAdapter(em, entity));
        }
        modelResult.setTotalSize(entityResult.getTotalSize());
        modelResult.setModels(list);
        return modelResult;
    }

    @Override
    public SearchResultsModel<CuentaPersonalModel> search(SocioModel socio, SearchCriteriaModel criteria,
            String filterText) {
        String[] field = { "numeroCuenta" };

        SearchResultsModel<CuentaPersonalEntity> results = new SearchResultsModel<>();
        Session session = getSession();

        // Set some default in the case that paging information was not
        // included in the request.
        PagingModel paging = criteria.getPaging();
        if (paging == null) {
            paging = new PagingModel();
            paging.setPage(1);
            paging.setPageSize(20);
        }
        int page = paging.getPage();
        int pageSize = paging.getPageSize();
        int start = (page - 1) * pageSize;

        Criteria criteriaQuery = session.createCriteria(CuentaPersonalEntity.class);
        applySearchCriteriaToQuery(criteria, CuentaPersonalEntity.class, criteriaQuery, false);

        criteriaQuery.createAlias("SocioEntity", "socio", JoinType.INNER_JOIN);
        criteriaQuery.add(Restrictions.eq("socio.id", socio.getId()));

        // filter text
        List<Criterion> disjuntions = new ArrayList<>();
        for (String fieldName : field) {
            Criterion criterion = Restrictions.ilike(fieldName, filterText, MatchMode.ANYWHERE);
            disjuntions.add(criterion);
        }
        criteriaQuery.add(Restrictions.or(disjuntions.toArray(new Criterion[disjuntions.size()])));

        // paging
        criteriaQuery.setFirstResult(start);
        criteriaQuery.setMaxResults(pageSize + 1);
        boolean hasMore = false;

        // Now query for the actual results
        @SuppressWarnings("unchecked")
        List<CuentaPersonalEntity> resultList = criteriaQuery.list();

        // Check if we got back more than we actually needed.
        if (resultList.size() > pageSize) {
            resultList.remove(resultList.size() - 1);
            hasMore = true;
        }

        // If there are more results than we needed, then we will need to do
        // another
        // query to determine how many rows there are in total
        int totalSize = start + resultList.size();
        if (hasMore) {
            Criteria criteriaQuery1 = session.createCriteria(CuentaPersonalEntity.class);
            applySearchCriteriaToQuery(criteria, CuentaPersonalEntity.class, criteriaQuery1, true);
            criteriaQuery1.createAlias("SocioEntity", "socio", JoinType.INNER_JOIN);
            criteriaQuery.add(Restrictions.eq("socio.id", socio.getId()));

            List<Criterion> disjuntionsCount = new ArrayList<>();
            for (String fieldName : field) {
                Criterion criterion = Restrictions.ilike(fieldName, filterText, MatchMode.ANYWHERE);
                disjuntionsCount.add(criterion);
            }
            criteriaQuery1
                    .add(Restrictions.or(disjuntionsCount.toArray(new Criterion[disjuntionsCount.size()])));
            criteriaQuery1.setProjection(Projections.rowCount());

            totalSize = ((Long) criteriaQuery1.uniqueResult()).intValue();
        }
        results.setTotalSize(totalSize);
        results.setModels(resultList);

        SearchResultsModel<CuentaPersonalEntity> entityResult = results;
        SearchResultsModel<CuentaPersonalModel> modelResult = new SearchResultsModel<>();
        List<CuentaPersonalModel> list = new ArrayList<>();
        for (CuentaPersonalEntity entity : entityResult.getModels()) {
            list.add(new CuentaPersonalAdapter(em, entity));
        }
        modelResult.setTotalSize(entityResult.getTotalSize());
        modelResult.setModels(list);
        return modelResult;
    }

}
