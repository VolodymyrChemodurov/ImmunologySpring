package com.immunology.logic.service;

import java.util.List;

import com.immunology.model.Survey;
import com.immunology.model.ui.Form;

public interface FormServive {

	Form createForm(Form form);
	
	Form updateForm(Form form);
	
	List<Form> getAllForms();
	
	Form getFormById(long formId);
	
	void saveTemplate(Survey survey);
	
	List<Survey> getUserSurveyTemplates(long id);
}
