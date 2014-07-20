package com.immunology.logic.dao;

import com.immunology.model.ui.MedicalCardForm;

public interface MedicalCardFormDao {

	MedicalCardForm getMedicalCardFormTemplate();
	
	boolean updateMedicalCardFormTemplate(MedicalCardForm form);
	
	MedicalCardForm getMedicalCardByPatientId(long id);
}
