package com.immunology.logic.service;

import java.util.List;

import com.immunology.model.Drug;
import com.immunology.model.ui.EfficacyData;

public interface DrugService {

	List<Drug> getAllDrags();

	List getDrugSpecies(String type);

	List getDrugNames(String species);

	List<Drug> getDrugsType();
	
	void saveEfficiencyData(EfficacyData data, Long surveyId);

	EfficacyData getEfficacyDataBySurveyId(Long surveyId);
}