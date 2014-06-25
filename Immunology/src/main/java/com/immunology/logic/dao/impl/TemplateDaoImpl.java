package com.immunology.logic.dao.impl;

import javax.annotation.PostConstruct;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.immunology.logic.dao.TemplateDao;
import com.immunology.model.ui.Survey;
import com.mongodb.DB;

@Repository
public class TemplateDaoImpl implements TemplateDao {

	@Autowired
	private MongoDbFactory mongoFactory;
	private MongoCollection surveys;
	
	@PostConstruct
	public void init() throws Exception {
		DB db = mongoFactory.getDb("immunology");
		Jongo jongo = new Jongo(db);
		surveys = jongo.getCollection("surveys");
	}
	
	public void createTemplate(Survey formTemplate) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(formTemplate);
		surveys.insert(result);
	}

	public Survey getSurveyTemplateByUserId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
