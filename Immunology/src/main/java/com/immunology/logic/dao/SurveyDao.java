package com.immunology.logic.dao;

import java.util.List;

import com.immunology.model.Survey;

public interface SurveyDao {

	boolean createSurveyTemplate(Survey template);

	List<Survey> getSurveyTemplatesByUserId(long id);

	List retrieveInsufficiency(long userId);
}
