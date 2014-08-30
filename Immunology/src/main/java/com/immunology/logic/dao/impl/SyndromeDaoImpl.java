package com.immunology.logic.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.immunology.logic.dao.GenericMongoDao;
import com.immunology.logic.dao.SyndromeDao;
import com.immunology.model.Syndrome;

@Repository
public class SyndromeDaoImpl extends GenericMongoDao<Syndrome> implements SyndromeDao {

	private static final String SYNDROME_TEMPLATE_COLLECTION = "syndromeTemplates";
	private static final String GET_USER_TEMPLATES = "{'users.id':#}";
	private static final String GET_USER_TEMPLATE_BY_NAME = "{'users.id':#, 'name':'#'}";
	private static final String GET_PATIENT_SYNDROME = "SELECT syndrome FROM Syndrome syndrome WHERE syndrome.name = :name AND syndrome.patient.id = :id";
	
	@PersistenceContext
	EntityManager entityManager;
	
	@PostConstruct
	public void init() {
		super.init(SYNDROME_TEMPLATE_COLLECTION);
	}
	
	public Syndrome getPatientSyndrome(Long patientId, String syndromeName) {
		TypedQuery<Syndrome> query = entityManager.createQuery(GET_PATIENT_SYNDROME, Syndrome.class)
				.setParameter("name", syndromeName).setParameter("id", patientId);
		List<Syndrome> syndromes = query.getResultList();
		return syndromes.size() > 0 ? syndromes.get(0) : null;
	}

	public Syndrome getUserSyndromeTemplate(Long userId, String syndromeName) {
		Iterable<Syndrome> templates = collection.find(GET_USER_TEMPLATE_BY_NAME, userId, syndromeName)
				.projection("{_id: 0}").as(Syndrome.class);
		List<Syndrome> syndromes = convertToList(templates);
		return syndromes.size() > 0 ? syndromes.get(0) : null;
	}
	
	public List<String> getPatientSyndromeNames(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Syndrome> getUserSyndromeTemplates(Long userId) {
		Iterable<Syndrome> templates = collection.find(GET_USER_TEMPLATES, userId)
				.projection("{_id: 0}").as(Syndrome.class);
		return convertToList(templates);
	}

	public List<String> getUserSyndromeTemplatesNames(Long userId) {
		Iterable<Syndrome> templates = collection.find(GET_USER_TEMPLATES, userId)
				.projection("{_id: 0, anamnesticData: 0, surveys: 0, users: 0}").as(Syndrome.class);
		return retrieveSyndromeNames(templates);
	}
	
	private List<String> retrieveSyndromeNames(Iterable<Syndrome> syndromes) {
		List<String> names = new ArrayList<String>();
		Iterator<Syndrome> iterator = syndromes.iterator();
		 while(iterator.hasNext()) {
			 names.add(iterator.next().getName());
		 }
		return names;
	}

}
