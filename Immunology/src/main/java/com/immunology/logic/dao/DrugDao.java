package com.immunology.logic.dao;

import java.util.List;

import com.immunology.model.Drug;

public interface DrugDao {

	public List<Drug> getAllDrags();
	
	public List  retrieveDrugTolerance(String name);
}
