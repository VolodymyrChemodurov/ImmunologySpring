package com.immunology.logic.service;

import com.immunology.model.Survey;

public interface SurveyService {

	Survey saveOrUpdateSurvey(Survey survey);

	Survey getById(Long surveyId);

}