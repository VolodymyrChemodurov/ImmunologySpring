package com.immunology.logic.service;

import java.util.List;

import com.immunology.logic.utils.enums.SyndromeFormulaType;
import com.immunology.model.Syndrome;

public interface SyndromeService {

	Syndrome getPatientSyndrome(Long patientId, String syndromeName);
	
	Syndrome saveSyndrome(Syndrome syndrome);
	
	List<String> getPatientSyndromeNames(Long patientId);
	
	List<Syndrome> getUserSyndromeTemplates(Long userId);
	
	List<String> getUserSyndromeTemplateNames(Long userId);
	
	List<String> getSyndromeNames();

	Boolean saveSyndromeTemplate(Syndrome syndrome);
	
	Boolean updateSyndromeTemplate(String templateName, Syndrome syndrome);
	
	Boolean wireUserToSyndromeTemplate(String syndromeName, Long userId);
	
	Syndrome getSyndromeByName(String syndromeName);
	
	String getSybdromeFormula(String syndromeName, SyndromeFormulaType formulaType);
	
	void saveSyndromeFormula(String syndormeName, SyndromeFormulaType formulaType, String formula);
}
