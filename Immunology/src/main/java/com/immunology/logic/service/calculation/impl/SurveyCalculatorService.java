package com.immunology.logic.service.calculation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.service.calculation.CalculatorService;
import com.immunology.model.Survey;
import com.immunology.model.calculation.Formula;

@Service
public class SurveyCalculatorService implements CalculatorService<Survey> {

	@Autowired
	private FormCalculatorService formCalculatorService;
	
	public Double calculate(Survey survey, Formula formula) {
		Double result = null;
		
		result = formCalculatorService.calculate(survey.getComplaintsForm(), formula) 
				+ formCalculatorService.calculate(survey.getLaboratoryDataForm(), formula)
				+ formCalculatorService.calculate(survey.getClinicalManifestationsForm(), formula)
				+ formCalculatorService.calculate(survey.getDiagnosisVerificationData(), formula)
				+ formCalculatorService.calculate(survey.getInstrumentalData(), formula)
				+ formCalculatorService.calculate(survey.getMainTreatmentData(), formula)
				+ formCalculatorService.calculate(survey.getMorphologicalData(), formula)
				+ formCalculatorService.calculate(survey.getPreventiveMeasuresData(), formula)
				+ formCalculatorService.calculate(survey.getRehabilitationData(), formula); 
		return result;
	}

}
