package com.immunology.logic.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immunology.model.Survey;
import com.immunology.model.Syndrome;
import com.immunology.model.ui.ClinicalManifestationsForm;
import com.immunology.model.ui.ComplaintsForm;
import com.immunology.model.ui.LaboratoryDataForm;

@Controller
@RequestMapping(value = "/")
public class LoginController {

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
//		Syndrome syndrome = new Syndrome();
//		List<Survey> surveys = new ArrayList<Survey>();
//		Survey survey = new Survey();
//		
//		ClinicalManifestationsForm clinicalManifestationsForm = new ClinicalManifestationsForm();
//		ComplaintsForm complaintsForm = new ComplaintsForm();
//		LaboratoryDataForm laboratoryDataForm = new LaboratoryDataForm();
//		
//		survey.setLaboratoryDataForm(laboratoryDataForm);
//		survey.setComplaintsForm(complaintsForm);
//		survey.setClinicalManifestationsForm(clinicalManifestationsForm);
//		
//		surveys.add(survey);
//		syndrome.setSurveys(surveys);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			String result = mapper.writeValueAsString(syndrome);
//			LOG.info(result);
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "login";
	}
	
}