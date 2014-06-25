package com.immunology.logic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.immunology.logic.service.FormServive;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private FormServive test;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
//		Survey survey = new Survey();
//		survey.setId(1L);
//		survey.setClinicalManifestationsForm(new ClinicalManifestationsForm());
//		survey.setComplaintsForm(new ComplaintsForm());
//		survey.setCreationDate(new Date());
//		survey.setLaboratoryDataForm(new LaboratoryDataForm());
//		test.saveTemplate(survey);
		LOG.info(test.getUserSurveyTemplates(1L).get(0).toString());
		return "login";
	}
	
}
