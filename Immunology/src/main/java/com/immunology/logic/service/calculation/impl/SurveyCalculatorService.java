package com.immunology.logic.service.calculation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.service.SyndromeService;
import com.immunology.logic.service.calculation.CalculatorService;
import com.immunology.logic.utils.enums.FormulaType;
import com.immunology.model.Survey;
import com.immunology.model.calculation.Formula;
import com.immunology.model.ui.SurveyForm;

@Service
public class SurveyCalculatorService implements CalculatorService<Survey> {

	@Autowired
	private FormCalculatorService formCalculatorService;
	@Autowired
	private SyndromeService syndromeService;
	
	public void calculateSurveyValues(Survey survey, Survey surveyTemplate, String syndromeName) {
		Formula insufficiencyLevelFormula = syndromeService.getSyndromeFormula(syndromeName, FormulaType.INSUFFICIENCY_LEVEL);
		Formula severityLevelFormula = syndromeService.getSyndromeFormula(syndromeName, FormulaType.SEVERITY_LEVEL);
		survey.setInsufficiencyLevel(this.calculate(survey, surveyTemplate, insufficiencyLevelFormula));
		survey.setSeverityLevel(this.calculate(survey, surveyTemplate, severityLevelFormula));
	}
	
	public Double calculate(Survey survey, Survey template, Formula formula) {
		Double result = new Double(0);
		for(SurveyForm form: survey.getForms()) {
			SurveyForm formTemplate = findSurveyFormTemplate(form, template);
			result += formCalculatorService.calculate(form, formTemplate, formula); 
		}
		return (double) (Math.round(result * 100)) / 100;
	}

	private SurveyForm findSurveyFormTemplate(SurveyForm form, Survey template) {
		SurveyForm result = null;
		for(SurveyForm currentTemplate: template.getForms()) {
			if(currentTemplate.getFormType().equals(form.getFormType())) {
				result = currentTemplate;
				break;
			}
		}
		return result;
	}
}
