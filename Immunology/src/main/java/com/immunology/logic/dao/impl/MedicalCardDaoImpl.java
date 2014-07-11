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
import com.immunology.logic.dao.MedicalCardFormDao;
import com.immunology.model.ui.MedicalCardForm;
import com.mongodb.DB;

@Repository
public class MedicalCardDaoImpl implements MedicalCardFormDao{

	private static final String MEDICAL_FORM_TEMPLATE_COLLECTION = "medicalForm";
	private static final Logger LOG = LoggerFactory.getLogger(MedicalCardDaoImpl.class);
	
	@Autowired
	private MongoDbFactory mongoFactory;
	private MongoCollection medicalForm;
	
	@PostConstruct
	public void init() throws Exception {
		DB db = mongoFactory.getDb();
		Jongo jongo = new Jongo(db);
		medicalForm = jongo.getCollection(MEDICAL_FORM_TEMPLATE_COLLECTION);
	}
	
	public MedicalCardForm getMedicalCardFormTemplate() {
		Iterable<MedicalCardForm> templates = medicalForm.find("{}").projection("{_id: 0}").as(MedicalCardForm.class);
		return convertToList(templates).get(0);
	}

	public boolean updateMedicalCardFormTemplate(MedicalCardForm form) {
		boolean saveResult = false;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String result = mapper.writeValueAsString(form);
			medicalForm.insert(result);
			saveResult = true;
		} catch (JsonProcessingException e) {
			LOG.error(e.toString());
		}
		return saveResult;
	}

	private List<MedicalCardForm> convertToList(Iterable<MedicalCardForm> templates) {
		 List<MedicalCardForm> medicalForms = new ArrayList<MedicalCardForm>();
		 Iterator<MedicalCardForm> iterator = templates.iterator();
		 while(iterator.hasNext()) {
			 medicalForms.add(iterator.next());
		 }
		 return medicalForms;
	}
}
