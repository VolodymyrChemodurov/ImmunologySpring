package com.immunology.logic.dao;

import java.util.List;

import com.immunology.model.ui.Survey;

public interface SurveyDao {

	void createSurveyTemplate(Survey template) throws Exception;
	
	List<Survey> getSurveyTemplatesByUserId(long id);
}
