package com.immunology.logic.service;

import java.util.List;

import com.immunology.logic.utils.enums.FormulaType;
import com.immunology.model.Syndrome;
import com.immunology.model.calculation.Formula;

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
	
	Formula getSybdromeFormula(String syndromeName, FormulaType formulaType);
	
	void saveSyndromeFormula(String syndormeName, FormulaType formulaType, String formula);
	
	void removeSyndromeTemplateFromUser(String syndromeName, Long userId);
}
