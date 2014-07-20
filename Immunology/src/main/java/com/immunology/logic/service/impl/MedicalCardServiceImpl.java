package com.immunology.logic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.MedicalCardFormDao;
import com.immunology.logic.service.MedicalCardFormService;
import com.immunology.model.ui.MedicalCardForm;

@Service
public class MedicalCardServiceImpl implements MedicalCardFormService{

	@Autowired
	private CrudDao crudDao;
	
	@Autowired
	private MedicalCardFormDao medicalCardDao;
	
	public MedicalCardForm getById(long id) {
		return crudDao.find(MedicalCardForm.class, id);
	}

	public MedicalCardForm updateMedicalCardForm(MedicalCardForm medCardForm) {
		return crudDao.saveOrUpdate(medCardForm);
	}

	public MedicalCardForm getMedicalCardTemplate() {
		return medicalCardDao.getMedicalCardFormTemplate();
	}

	public boolean updateMedicalCardTemplate(MedicalCardForm template) {
		return medicalCardDao.updateMedicalCardFormTemplate(template);
	}

	public MedicalCardForm getMedicalCardByPatientId(long id) {
		return medicalCardDao.getMedicalCardByPatientId(id);
	}
	
	
}
