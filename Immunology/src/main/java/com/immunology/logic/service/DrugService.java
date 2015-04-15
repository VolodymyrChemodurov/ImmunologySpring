package com.immunology.logic.service;

import java.util.List;

import com.immunology.model.drug.Drug;
import com.immunology.model.drug.DrugSpecies;
import com.immunology.model.drug.DrugType;
import com.immunology.model.ui.EfficacyData;

public interface DrugService {

	List<Drug> getAllDrags();

	List getDrugSpecies(String type);

	List getDrugNames(String species);

	List<Drug> getDrugsType();
	
	void saveEfficiencyData(EfficacyData data, Long surveyId);

	EfficacyData getEfficacyDataBySurveyId(Long surveyId);
	
	Boolean saveOrUpdate(Drug drug);
	
	Boolean saveOrUpdate(DrugType drugType);
	
	Boolean saveOrUpdate(DrugSpecies drugSpecies);
	
	Drug getById(Long id);
	
	Boolean deleteDrug(Long drugId);
}