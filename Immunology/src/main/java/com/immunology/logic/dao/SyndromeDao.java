package com.immunology.logic.dao;

import java.util.List;

import com.immunology.model.Syndrome;

public interface SyndromeDao {

	Syndrome getPatientSyndrome(Long patientId, String syndromeName);
	
	Syndrome getUserSyndromeTemplate(Long userId, String syndromeName);
	
	List<String> getPatientSyndromeNames(Long patinetId);
	
	List<Syndrome> getUserSyndromeTemplates(Long userId);
	
	List<String> getUserSyndromeTemplatesNames(Long userId);
	
	List<String> getSyndromeNames();
	
	Boolean saveSyndromeTemplate(Syndrome syndrome);
	
	Boolean updateSyndromeTemplate(String templateName, Syndrome syndrome);
	
	Syndrome findSyndrome(String templateName);
	
	List retrieveSyndromePatientStatistic();
	
}
