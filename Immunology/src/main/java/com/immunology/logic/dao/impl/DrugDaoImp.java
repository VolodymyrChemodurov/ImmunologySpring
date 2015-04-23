package com.immunology.logic.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.bson.LazyBSONList;
import org.springframework.stereotype.Repository;

import com.immunology.logic.dao.DrugDao;
import com.immunology.logic.dao.GenericMongoDao;
import com.immunology.model.drug.Drug;
import com.immunology.model.drug.DrugSpecies;
import com.immunology.model.drug.DrugType;
import com.immunology.model.ui.EfficacyData;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Repository
public class DrugDaoImp extends GenericMongoDao<Drug> implements DrugDao {
	
	private static final String SYNDROME_TEMPLATE_COLLECTION = "syndromeTemplates";
	
	@PersistenceContext
	private EntityManager em;

	@PostConstruct
	public void init() {
		super.init(SYNDROME_TEMPLATE_COLLECTION);
	}
	
	public List<Drug> getAllDrags() {
		TypedQuery<Drug> query = em.createQuery("SELECT * FROM drugs", Drug.class);
		List<Drug> results = query.getResultList();
		return results; 
	}
	
	public List getDrugsType() {	
		return em.createNativeQuery("SELECT DISTINCT(name) FROM drug_types")
				.getResultList();
	}
	
	public List  getDrugSpecies(String type) {
		return em.createNativeQuery("SELECT DISTINCT(drug_species.name) FROM drug_species JOIN drug_types ON drug_species.type_id = drug_types.id WHERE drug_types.name = :type").setParameter("type", type).getResultList();
	}

	public List  getDrugNames(String species) {
		return em.createNativeQuery("SELECT DISTINCT(drugs.name) FROM drugs JOIN drug_species ON drugs.species_id = drug_species.id WHERE drug_species.name = :species").setParameter("species", species).getResultList();
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

	public EfficacyData getEfficacyDataBySurveyId(Long surveyId) {
		TypedQuery<EfficacyData> query = em.createQuery("SELECT f FROM EfficacyData f WHERE f.survey.id = :surveyId", EfficacyData.class)
				.setParameter("surveyId", surveyId);
		List<EfficacyData> results = query.getResultList();
		return results.isEmpty() ? null : results.get(0); 
	}
	

	public DrugType fingDrugTypeByName(String name) {
		TypedQuery<DrugType> query = em.createQuery("SELECT dt FROM DrugType dt WHERE dt.name = :name", DrugType.class)
				.setParameter("name", name);
		List<DrugType> results = query.getResultList();
		return results.isEmpty() ? null : results.get(0); 
	}

	public DrugSpecies fingDrugSpeciesByName(String name) {
		TypedQuery<DrugSpecies> query = em.createQuery("SELECT ds FROM DrugSpecies ds WHERE ds.name = :name", DrugSpecies.class)
				.setParameter("name", name);
		List<DrugSpecies> results = query.getResultList();
		return results.isEmpty() ? null : results.get(0);
	}

	public Long getDrugTypeIdByName(String name) {
		Long result = ((BigInteger) em.createNativeQuery("SELECT id FROM drug_types WHERE name = :name")
				.setParameter("name", name).getSingleResult()).longValue();
		return result;
	}

	public Long getDrugSpeciesIdByName(String name) {
		Long result = ((BigInteger) em.createNativeQuery("SELECT id FROM drug_species WHERE name = :name")
				.setParameter("name", name).getSingleResult()).longValue();
		return result;
	}

	@Transactional
	public Boolean deleteById(Long id) {
		int result = em.createNativeQuery("DELETE FROM drugs WHERE id = :id").setParameter("id", id).executeUpdate();
		return result > 0 ? true : false;
	}

	public List<Drug> getSyndromeDrugs(String syndromeName) {
		DBObject syndromeDrugsIds = db.getCollection(SYNDROME_TEMPLATE_COLLECTION).findOne(new BasicDBObject("name", syndromeName), new BasicDBObject("drugs", 1));
		List<Long> drugsIds = parseDrugIds(syndromeDrugsIds); 
		
		List<Drug> syndromeDrugs = new ArrayList<Drug>(drugsIds.size());
		for(Long id : drugsIds) {
			Drug currentDrug = em.find(Drug.class, id);
			syndromeDrugs.add(currentDrug);
		}
		
		return syndromeDrugs;
	}
	
	private List<Long> parseDrugIds(DBObject drugIds) {
		List<Long> drugsIds = new ArrayList<Long>();
		LazyBSONList drugs = (LazyBSONList) drugIds.get("drugs");
		for(int i = 0; i < drugs.size(); i++) {
			DBObject currentDrug = (DBObject) drugs.get(i);
			drugsIds.add(Long.parseLong(currentDrug.get("id").toString())); 
		}
		return drugsIds;
	}
}
