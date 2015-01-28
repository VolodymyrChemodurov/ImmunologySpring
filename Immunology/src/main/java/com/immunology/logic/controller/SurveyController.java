package com.immunology.logic.controller;

import javax.servlet.http.HttpServletRequest;

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
import com.immunology.logic.service.calculation.impl.SurveyCalculatorService;
import com.immunology.logic.utils.ReferenceHelper;
import com.immunology.logic.utils.URIUtils;
import com.immunology.logic.utils.UserUtils;
import com.immunology.logic.utils.enums.FormulaType;
import com.immunology.model.Survey;
import com.immunology.model.Syndrome;
import com.immunology.model.calculation.Formula;

@Controller
@RequestMapping(value = "/survey")
public class SurveyController {

	@Autowired
	private SyndromeService syndromeService;
	@Autowired
	private UserService userService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private SurveyCalculatorService surveyCalculatorService;
	
	@RequestMapping(value = "/patientId/{id}/syndrome/{syndromeName}", method = RequestMethod.GET)
	public String  getUserSyndromes(Model model, @PathVariable("id") long patientId, @PathVariable("syndromeName") String syndromeName, HttpServletRequest request) {
		User user = UserUtils.getCurrentUser();
		model.addAttribute("user", userService.getUserByLogin(user.getUsername()));
		
		model.addAttribute("syndrom", syndromeService.getPatientSyndrome(patientId, URIUtils.decodePathVariable(request.getRequestURI(), 4)));
		model.addAttribute("patient", patientService.getPatientById(patientId));
		return "user/survey";
	}
	
	@RequestMapping(value = "/edit/patientId/{id}/surveyId/{surveyId}/syndrome/{syndromeName}", method = RequestMethod.GET)
	public String  editUserSyndromes(Model model, @PathVariable("id") long patientId, @PathVariable("surveyId") long surveyId, @PathVariable("syndromeName") String syndromeName, HttpServletRequest request) {
		User user = UserUtils.getCurrentUser();
		model.addAttribute("user", userService.getUserByLogin(user.getUsername()));
		
		Syndrome syndrome = syndromeService.getPatientSyndrome(patientId, URIUtils.decodePathVariable(request.getRequestURI(), 7));
		Survey survey = null;
		for(Survey currentSurvey: syndrome.getSurveys()) {
			if(currentSurvey.getId() == surveyId) {
				survey = currentSurvey;
			}
		}
		model.addAttribute("syndrom", syndrome);
		model.addAttribute("surveyId", surveyId);
		model.addAttribute("survey", survey);
		model.addAttribute("patient", patientService.getPatientById(patientId));
		return "user/survey";
	}
	
	@RequestMapping(value = "/patient/{patientId}/syndrome/{syndromeName}", method = RequestMethod.POST)
	public @ResponseBody Survey saveOrUpdateSurvey(@RequestBody Survey survey, @PathVariable("patientId") Long patientId,
			@PathVariable("syndromeName") String syndromeName, HttpServletRequest request) {
		String decodedSyndromeName = URIUtils.decodePathVariable(request.getRequestURI(), 4);
		Syndrome syndrome = syndromeService.getPatientSyndrome(patientId, decodedSyndromeName);
		if(syndrome.getPatient() == null) {
			syndrome.setPatient(patientService.getPatientById(patientId));
			ReferenceHelper.setTemplatesReferences(syndrome);
		}
		survey.setDisease(syndrome);
		User user = UserUtils.getCurrentUser();
		survey.setUser(userService.getUserByLogin(user.getUsername()));
		
		Survey surveyTemplate = syndromeService.getSyndromeByName(decodedSyndromeName).getSurveys().get(0);
		Formula insufficiencyLevelFormula = syndromeService.getSyndromeFormula(syndrome.getName(), FormulaType.INSUFFICIENCY_LEVEL);
		Formula severityLevelFormula = syndromeService.getSyndromeFormula(syndrome.getName(), FormulaType.SEVERITY_LEVEL);
		survey.setInsufficiencyLevel(surveyCalculatorService.calculate(survey, surveyTemplate, insufficiencyLevelFormula));
		survey.setSeverityLevel(surveyCalculatorService.calculate(survey, surveyTemplate, severityLevelFormula));
		
		return surveyService.saveOrUpdateSurvey(survey);
	}
	
	@RequestMapping(value = "/patient/{patientId}/survey/{surveyId}", method = RequestMethod.GET)
	public @ResponseBody Survey getPatientSurvey(@PathVariable("patientId") Long patientId, @PathVariable("surveyId") Long syrveyId) {
		Survey survey = surveyService.getById(syrveyId);
		return survey;
	}
}
