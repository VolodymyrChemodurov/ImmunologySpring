package com.immunology.logic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.immunology.logic.dao.CrudDao;
@Transactional
@Repository
public class CrudDaoImpl implements CrudDao{

	@PersistenceContext
	private EntityManager em;
	
	public <T> T create(T object) {
		em.persist(object);
		em.flush();
		em.refresh(object);
		return object;
	}

	public <T> T find(Class<T> type, Object id) {
		return (T) this.em.find(type, id);
	}

	public <T> void delete(Class<T> type, Object id) {
		Object ref = this.em.getReference(type, id);
		this.em.remove(ref);
	}

	public void delete(Object object) {
		this.em.remove(em.merge(object));
	}

	public <T> T saveOrUpdate(T object) {
		return (T) this.em.merge(object);
	}

	public <T> List<T> getAll(Class<T> clazz) {
		CriteriaBuilder cb = this.em.getCriteriaBuilder();
		CriteriaQuery<T> criteria = cb.createQuery(clazz);
		Root<T> category = criteria.from(clazz);
		criteria.select(category);
		return this.em.createQuery(criteria).getResultList();
	}
}
