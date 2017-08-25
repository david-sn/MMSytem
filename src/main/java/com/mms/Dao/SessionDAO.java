package com.mms.Dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SessionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public <T> Serializable create(final T entity) {
        return sessionFactory.getCurrentSession().save(entity);
    }

    public <T> T SaveOrUpdate(final T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        return entity;
    }
    
    public <T> T Save(final T entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    public <T> T update(final T entity) {
        sessionFactory.getCurrentSession().update(entity);
        return entity;
    }

    public <T> void delete(final T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public <T> void delete(Serializable id, Class<T> entityClass) {
        T entity = fetchById(id, entityClass);
        delete(entity);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> fetchAll(Class<T> entityClass) {
        return sessionFactory.getCurrentSession().createQuery(" FROM " + entityClass.getName()).list();
    }

    @SuppressWarnings("rawtypes")
    public <T> List fetchAll(String query) {
        return sessionFactory.getCurrentSession().createSQLQuery(query).list();
    }

    public <T> List getByName(String PrpoertyName, String value, Class<T> entityClass) {
        Criteria c = sessionFactory.getCurrentSession().createCriteria(entityClass);
        c.add(Restrictions.ilike(PrpoertyName, value));
        return c.list();
    }

    @SuppressWarnings("unchecked")
    public <T> T fetchById(Serializable id, Class<T> entityClass) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id);
    }

}
