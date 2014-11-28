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
	
	public List<Drug> getDrugsType() {	
		return em.createNativeQuery("SELECT DISTINCT(type) FROM drugs")
				.getResultList();
	}
	
	public List  getDrugSpecies(String type) {
		return em.createNativeQuery("SELECT DISTINCT(species) FROM drugs WHERE type= :type").setParameter("type", type).getResultList();
		}

	public List  getDrugNames(String species) {
		return em.createNativeQuery("SELECT name FROM drugs WHERE species= :species").setParameter("species", species).getResultList();
		}
	
	public List  retrieveDrugTolerance(String name) {
	return em.createNativeQuery("SELECT drug_tolerance,count(drug_tolerance) FROM efficacy_data JOIN drug_efficacy_data ON drug_efficacy_data.efficacy_data_id=efficacy_data.id JOIN drugs ON drug_efficacy_data.drug_id=drugs.id WHERE name= :name GROUP BY drug_tolerance").setParameter("name", name).getResultList();
	}
	
	public List  retrieveDrugEvaluation(String name) {
		return em.createNativeQuery("SELECT efficacy_evaluation,count(drug_tolerance) FROM efficacy_data JOIN drug_efficacy_data ON drug_efficacy_data.efficacy_data_id=efficacy_data.id JOIN drugs ON drug_efficacy_data.drug_id=drugs.id WHERE name= :name GROUP BY efficacy_evaluation").setParameter("name", name).getResultList();
		}
	
	public List  retrieveDrugSideEffect(String name) {
		return em.createNativeQuery("SELECT side_effects_severity_degree,count(drug_tolerance) FROM efficacy_data JOIN drug_efficacy_data ON drug_efficacy_data.efficacy_data_id=efficacy_data.id JOIN drugs ON drug_efficacy_data.drug_id=drugs.id WHERE name= :name GROUP BY side_effects_severity_degree").setParameter("name", name).getResultList();
		}
	
	public List  retrieveCancel(String name) {
		return em.createNativeQuery("SELECT cancel,count(drug_tolerance) FROM efficacy_data JOIN drug_efficacy_data ON drug_efficacy_data.efficacy_data_id=efficacy_data.id JOIN drugs ON drug_efficacy_data.drug_id=drugs.id WHERE name= :name GROUP BY cancel").setParameter("name", name).getResultList();
		}
}
