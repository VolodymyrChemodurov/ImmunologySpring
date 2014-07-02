package com.immunology.logic.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immunology.logic.dao.SurveyDao;
import com.immunology.model.Survey;
import com.mongodb.DB;

@Repository
public class SurveyDaoImpl implements SurveyDao {

	private static final String SURVEYS_TEMPLATES_COLLECTION = "surveys";
	private static final Logger LOG = LoggerFactory.getLogger(SurveyDaoImpl.class);
	
	@Autowired
	private MongoDbFactory mongoFactory;
	private MongoCollection surveys;
	
	@PostConstruct
	public void init() throws Exception {
		DB db = mongoFactory.getDb();
		Jongo jongo = new Jongo(db);
		surveys = jongo.getCollection(SURVEYS_TEMPLATES_COLLECTION);
	}
	
	public boolean createSurveyTemplate(Survey formTemplate) {
		boolean saveResult = false;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String result = mapper.writeValueAsString(formTemplate);
			surveys.insert(result);
			saveResult = true;
		} catch (JsonProcessingException e) {
			LOG.error(e.toString());
		}
		return saveResult;
	}

	public List<Survey> getSurveyTemplatesByUserId(long id) {
		Iterable<Survey> templates = surveys.find("{id: #}", id).as(Survey.class);
		return convertToList(templates);
	}
	
	private List<Survey> convertToList(Iterable<Survey> templates) {
		 List<Survey> surveys = new ArrayList<Survey>();
		 Iterator<Survey> iterator = templates.iterator();
		 while(iterator.hasNext()) {
			 surveys.add(iterator.next());
		 }
		 return surveys;
	}
}
