package com.immunology.logic.dao;

import java.util.List;

import com.immunology.model.Syndrome;

public interface SyndromeDao {

	Syndrome getPatientSyndrome(Long patientId, String syndromeName);
	
	Syndrome saveSyndrome(Syndrome syndrome);
	
	List<String> getPatientSyndromeNames(Long patinetId);
	
	List<Syndrome> getUserSyndromeTemplates(Long userId);
	
	List<String> getUserSyndromeTemplatesNames(Long userId);
}
