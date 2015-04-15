package com.immunology.logic.dao;

import java.util.List;

import com.immunology.model.drug.Drug;
import com.immunology.model.drug.DrugSpecies;
import com.immunology.model.drug.DrugType;
import com.immunology.model.ui.EfficacyData;

public interface DrugDao {

	List<Drug> getAllDrags();

	List retrieveDrugTolerance(String name);
	
	List getDrugSpecies(String type);
	
	List getDrugNames(String species);
	
	List getDrugsType();
	
	List retrieveDrugEvaluation(String name);

	List retrieveDrugSideEffect(String name);
	
	List retrieveCancel(String name);

	EfficacyData getEfficacyDataBySurveyId(Long surveyId);
	
	DrugType fingDrugTypeByName(String name);
	
	DrugSpecies fingDrugSpeciesByName(String name);
	
	Long getDrugTypeIdByName(String name);
	
	Long getDrugSpeciesIdByName(String name);
	
	Boolean deleteById(Long id);
}
