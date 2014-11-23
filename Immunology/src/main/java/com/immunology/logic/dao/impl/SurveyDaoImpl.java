package com.immunology.logic.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immunology.logic.dao.GenericMongoDao;
import com.immunology.logic.dao.SurveyDao;
import com.immunology.model.Survey;

@Repository
public class SurveyDaoImpl extends GenericMongoDao<Survey> implements SurveyDao {

	private static final String SURVEYS_TEMPLATES_COLLECTION = "surveys";

	private static final Logger LOG = LoggerFactory.getLogger(SurveyDaoImpl.class);
	
	@PostConstruct
	public void init() {
		super.init(SURVEYS_TEMPLATES_COLLECTION);
	}
	
	@PersistenceContext
	private EntityManager em;

	
	public boolean createSurveyTemplate(Survey formTemplate) {
		boolean saveResult = false;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String result = mapper.writeValueAsString(formTemplate);
			collection.insert(result);
			saveResult = true;
		} catch (JsonProcessingException e) {
			LOG.error(e.toString());
		}
		return saveResult;
	}

	public List<Survey> getSurveyTemplatesByUserId(long id) {
		Iterable<Survey> templates = collection.find("{id: #}", id).as(Survey.class);
		return convertToList(templates);
	}
	
	public List  retrieveInsufficiency(long userId) {
		System.out.println("id"+userId);
		return em.createNativeQuery("SELECT insufficiency_level,to_char(creation_date,'DD-MM-YYYY') FROM surveys WHERE user_id = :user_id").setParameter("user_id", userId).getResultList();
		}
}
