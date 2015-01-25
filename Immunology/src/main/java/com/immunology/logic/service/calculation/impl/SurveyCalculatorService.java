package com.immunology.logic.service.calculation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.service.calculation.CalculatorService;
import com.immunology.model.Survey;
import com.immunology.model.calculation.Formula;
import com.immunology.model.ui.SurveyForm;

@Service
public class SurveyCalculatorService implements CalculatorService<Survey> {

	@Autowired
	private FormCalculatorService formCalculatorService;
	
	public Double calculate(Survey survey, Formula formula) {
		Double result = new Double(0);
		for(SurveyForm form: survey.getForms()) {
			result += formCalculatorService.calculate(form, formula); 
		}
		return result;
	}

}
