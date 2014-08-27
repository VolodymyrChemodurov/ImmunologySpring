package com.immunology.logic.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Repository;

import com.immunology.logic.dao.SyndromeDao;
import com.immunology.model.Syndrome;
import com.mongodb.DB;

@Repository
public class SyndromeDaoImpl implements SyndromeDao {

	private static final String SYNDROME_TEMPLATE_COLLECTION = "syndromeTemplates";
	private static final String GET_USER_TEMPLATES = "{'users.id':%s}";
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private MongoDbFactory mongoFactory;
	private MongoCollection syndromeCollection;
	
	@PostConstruct
	public void init() throws Exception {
		DB db = mongoFactory.getDb();
		Jongo jongo = new Jongo(db);
		syndromeCollection = jongo.getCollection(SYNDROME_TEMPLATE_COLLECTION);
	}
	
	public Syndrome getPatientSyndrome(Long patientId, String syndromeName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Syndrome saveSyndrome(Syndrome syndrome) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getPatientSyndromeNames(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Syndrome> getUserSyndromeTemplates(Long userId) {
		Iterable<Syndrome> templates = syndromeCollection.find(String.format(GET_USER_TEMPLATES, userId))
				.projection("{_id: 0}").as(Syndrome.class);
		return convertToList(templates);
	}

	public List<String> getUserSyndromeTemplatesNames(Long userId) {
		Iterable<Syndrome> templates = syndromeCollection.find(String.format(GET_USER_TEMPLATES, userId))
				.projection("{_id: 0, anamnesticData: 0, surveys: 0, users: 0}").as(Syndrome.class);
		return retrieveSyndromeNames(templates);
	}
	
	private List<Syndrome> convertToList(Iterable<Syndrome> templates) {
		 List<Syndrome> syndromes = new ArrayList<Syndrome>();
		 Iterator<Syndrome> iterator = templates.iterator();
		 while(iterator.hasNext()) {
			 syndromes.add(iterator.next());
		 }
		 return syndromes;
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
