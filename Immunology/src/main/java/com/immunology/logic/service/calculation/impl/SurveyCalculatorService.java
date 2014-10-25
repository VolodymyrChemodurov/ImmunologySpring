package com.immunology.logic.service.calculation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.service.calculation.CalculatorService;
import com.immunology.model.Survey;

@Service
public class SurveyCalculatorService implements CalculatorService<Survey> {

	@Autowired
	private FormCalculatorService formCalculatorService;
	
	public Double calculate(Survey survey) {
		Double result = null;
		
		result = formCalculatorService.calculate(survey.getComplaintsForm()) 
				+ formCalculatorService.calculate(survey.getLaboratoryDataForm())
				+ formCalculatorService.calculate(survey.getClinicalManifestationsForm());
		
		return result;
	}

}
