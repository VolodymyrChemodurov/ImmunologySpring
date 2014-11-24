package com.immunology.logic.service;

import java.util.List;

import com.immunology.model.Drug;

public interface DrugService {

	List<Drug> getAllDrags();

	List getDrugSpecies(String type);

	List getDrugNames(String species);

	List<Drug> getDrugsType();

}
