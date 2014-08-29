package com.immunology.logic.service;

import java.util.List;

import com.immunology.model.Syndrome;

public interface SyndromeService {

	Syndrome getPatientSyndrome(Long patientId, String syndromeName);
	
	Syndrome saveSyndrome(Syndrome syndrome);
	
	List<String> getPatientSyndromeNames(Long patientId);
	
	List<Syndrome> getUserSyndromeTemplates(Long userId);
	
	List<String> getUserSyndromeTemplateNames(Long userId);
}