package com.immunology.logic.dao;

import java.util.List;

import com.immunology.model.Drug;

public interface DrugDao {

	List<Drug> getAllDrags();

	List retrieveDrugTolerance(String name);
	
	List getDrugSpecies(String type);
	
	List getDrugNames(String species);
	
	List<Drug> getDrugsType();
	
	List retrieveDrugEvaluation(String name);

	List retrieveDrugSideEffect(String name);
	
	List retrieveCancel(String name);

}
