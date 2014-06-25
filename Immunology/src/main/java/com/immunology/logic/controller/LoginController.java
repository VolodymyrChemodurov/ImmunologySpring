package com.immunology.logic.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.immunology.logic.service.FormServive;
import com.immunology.model.ui.ClinicalManifestationsForm;
import com.immunology.model.ui.ComplaintsForm;
import com.immunology.model.ui.LaboratoryDataForm;
import com.immunology.model.ui.Survey;

@Controller
@RequestMapping(value = "/")
public class LoginController {
	
	@Autowired
	private FormServive test;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		Survey survey = new Survey();
		survey.setId(1L);
		survey.setClinicalManifestationsForm(new ClinicalManifestationsForm());
		survey.setComplaintsForm(new ComplaintsForm());
		survey.setCreationDate(new Date());
		survey.setLaboratoryDataForm(new LaboratoryDataForm());
		test.saveTemplate(survey);
		return "login";
	}
	
}
