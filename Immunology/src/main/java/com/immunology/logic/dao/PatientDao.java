package com.immunology.logic.dao;

import java.util.List;

import com.immunology.model.Patient;

public interface PatientDao {

	
	List<Patient> fingByUserId(long userId);
}
