package com.immunology.logic.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immunology.logic.dao.GenericMongoDao;
import com.immunology.logic.dao.MedicalCardFormDao;
import com.immunology.model.ui.MedicalCardForm;

@Repository
public class MedicalCardDaoImpl extends GenericMongoDao<MedicalCardForm> implements MedicalCardFormDao{

	private static final String MEDICAL_FORM_TEMPLATE_COLLECTION = "medicalForm";
	private static final Logger LOG = LoggerFactory.getLogger(MedicalCardDaoImpl.class);
	
	@PersistenceContext
	EntityManager entityManager;
	
	@PostConstruct
	public void init() {
		super.init(MEDICAL_FORM_TEMPLATE_COLLECTION);
	}
	
	public MedicalCardForm getMedicalCardFormTemplate() {
		Iterable<MedicalCardForm> templates = collection.find("{}").projection("{_id: 0}").as(MedicalCardForm.class);
		return convertToList(templates).get(0);
	}

	public boolean updateMedicalCardFormTemplate(MedicalCardForm form) {
		boolean saveResult = false;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String result = mapper.writeValueAsString(form);
			collection.remove("{}");
			collection.insert(result);
			saveResult = true;
		} catch (JsonProcessingException e) {
			LOG.error(e.toString());
		}
		return saveResult;
	}

	public MedicalCardForm getMedicalCardByPatientId(long id) {
		TypedQuery<MedicalCardForm> query = entityManager.createQuery("SELECT patient.medicalCard FROM Patient patient WHERE patient.id = :patient_id", MedicalCardForm.class);
		query.setParameter("patient_id", id);
		List<MedicalCardForm> medicalCards = query.getResultList();
		return medicalCards.size() > 0 ? medicalCards.get(0) : null;
	}

}
