package com.immunology.logic.dao;

import com.immunology.model.ui.Survey;

public interface TemplateDao {

	void createTemplate(Survey formTemplate) throws Exception;
	
	Survey getSurveyTemplateByUserId(long id);
}
