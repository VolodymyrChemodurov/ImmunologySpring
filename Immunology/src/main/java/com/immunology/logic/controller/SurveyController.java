package com.immunology.logic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.immunology.logic.service.PatientService;
import com.immunology.logic.service.SurveyService;
import com.immunology.logic.service.SyndromeService;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.UserUtils;
import com.immunology.model.Survey;
import com.immunology.model.Syndrome;

@Controller
@RequestMapping(value = "/survey")
public class SurveyController {

	private static final Logger LOG = LoggerFactory.getLogger(SurveyController.class);
	
	@Autowired
	private SyndromeService syndromeService;
	@Autowired
	private UserService userService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private SurveyService surveyService;
	
	@RequestMapping(value = "/patientId={id}syndrome={syndromeName}", method = RequestMethod.GET)
	public String  getUserSyndromes(Model model, @PathVariable("id") long patientId, @PathVariable("syndromeName") String syndromeName) {
		User user = UserUtils.getCurrentUser();
		model.addAttribute("user", userService.getUserByLogin(user.getUsername()));
		
		
		model.addAttribute("syndrom", syndromeService.getPatientSyndrome(patientId, syndromeName));
		model.addAttribute("patient", patientService.getPatientById(patientId));
		return "user/survey";
	}
	
	@RequestMapping(value = "/patient/{patientId}/syndrome/{syndromeName}", method = RequestMethod.POST)
	public @ResponseBody Survey saveOrUpdateSurvey(@RequestBody Survey survey, @PathVariable("patientId") Long patientId,
			@PathVariable("syndromeName") String syndromeName) {
		Syndrome syndrome = syndromeService.getPatientSyndrome(patientId, syndromeName);
		survey.setDisease(syndrome);
		return surveyService.saveOrUpdateSurvey(survey);
	}
	
}
