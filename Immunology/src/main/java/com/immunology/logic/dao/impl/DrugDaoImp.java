package com.immunology.logic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.immunology.logic.dao.DrugDao;
import com.immunology.model.Drug;

@Repository
public class DrugDaoImp implements DrugDao {
	
	@PersistenceContext
	private EntityManager em;

	public List<Drug> getAllDrags() {
		TypedQuery<Drug> query = em.createQuery("SELECT * FROM drugs", Drug.class);
		List<Drug> results = query.getResultList();
		return results; 
	}

	public List  retrieveDrugTolerance(String name) {
	return em.createQuery("SELECT drug_tolerance,count(drug_tolerance) FROM efficacy_data JOIN drug_efficacy_data ON drug_efficacy_data.efficacy_data_id=efficacy_data.id JOIN drugs ON drug_efficacy_data.drug_id=drugs.id WHERE name= :name GROUP BY drug_tolerance").setParameter("name", name).getResultList();
	}
}
