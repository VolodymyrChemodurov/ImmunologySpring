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
				+ formCalculatorService.calculate(survey.getClinicalManifestationsForm(), formula);
		
		return result;
	}

}
