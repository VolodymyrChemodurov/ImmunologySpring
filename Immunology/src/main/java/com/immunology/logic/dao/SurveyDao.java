package com.immunology.logic.dao;

import java.util.List;

import com.immunology.model.ui.Survey;

public interface SurveyDao {

	boolean createSurveyTemplate(Survey template);
	
	List<Survey> getSurveyTemplatesByUserId(long id);
}
