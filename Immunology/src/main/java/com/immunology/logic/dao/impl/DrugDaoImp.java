package com.immunology.logic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.immunology.logic.dao.DrugDao;
import com.immunology.model.Drug;

public class DrugDaoImp implements DrugDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<Drug> getAllDrags() {
		TypedQuery<Drug> query = em.createQuery("SELECT * FROM drug", Drug.class);
		List<Drug> results = query.getResultList();
		return results; 
	}

}
