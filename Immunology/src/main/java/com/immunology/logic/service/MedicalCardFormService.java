package com.immunology.logic.service;

import com.immunology.model.ui.MedicalCardForm;

public interface MedicalCardFormService {

	MedicalCardForm getById(long id);
	
	MedicalCardForm updateMedicalCardForm(MedicalCardForm medCardForm);
}
