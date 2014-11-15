package com.immunology.logic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.immunology.logic.service.PatientService;
import com.immunology.logic.service.SyndromeService;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.URIUtils;
import com.immunology.logic.utils.UserUtils;
import com.immunology.logic.utils.enums.SyndromeFormulaType;
import com.immunology.model.Patient;
import com.immunology.model.Syndrome;

@Controller
@RequestMapping(value = "/syndromes")
public class SyndromeController {

	private static final Logger LOG = LoggerFactory.getLogger(SyndromeController.class);
	
	@Autowired
	private SyndromeService syndromeService;
	@Autowired
	private UserService userService;
	@Autowired
	private PatientService patientService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Syndrome> getUserSyndromes() {
		User user = UserUtils.getCurrentUser();
		return syndromeService.getUserSyndromeTemplates(userService.getUserByLogin(user.getUsername()).getId());
	}
	
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
	public @ResponseBody List<String> getPatientSyndromes(@PathVariable("id") Long id) {
		LOG.info("getPatientSyndromes");
		return syndromeService.getPatientSyndromeNames(id);
	}
	
	@RequestMapping(value = "/patient/{id}/{name}", method = RequestMethod.GET)
	public @ResponseBody Syndrome getPatientSyndrome(@PathVariable("id") Long id,  @PathVariable("name") String syndromeName, HttpServletRequest request) {
		
		LOG.info("getPatientSyndrome");
		return syndromeService.getPatientSyndrome(id, URIUtils.decodePathVariable(request.getRequestURI(), 3));
	}
	
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.POST)
	public @ResponseBody Boolean savePatientSyndrome(@PathVariable("id") Long id, @RequestBody Syndrome syndrome) {
		LOG.info("savePatientSyndrome");
		Patient patient = patientService.getPatientById(id);
		syndrome.setPatient(patient);
		syndrome = syndromeService.saveSyndrome(syndrome);
		return syndrome != null ? true : false;
	}
	
	@RequestMapping(value = "/patient/{patientId}/syndrome/{syndromeId}", method = RequestMethod.POST)
	public @ResponseBody Boolean updatePatientSyndrome(@PathVariable("patientId") Long patientId, 
			@PathVariable("syndromeId") Long syndromeId, @RequestBody Syndrome syndrome) {
		LOG.info("updatePatientSyndrome");
		Patient patient = patientService.getPatientById(patientId);
		syndrome.setPatient(patient);
		syndrome = syndromeService.saveSyndrome(syndrome);
		return syndrome != null ? true : false;
	}
	
	@RequestMapping(value = "/names", method = RequestMethod.GET)
	public @ResponseBody List<String> getSyndromesNames() {
		LOG.info("get syndromes names");
		List<String> names = syndromeService.getSyndromeNames(); 
		return names;
	}
	
	@RequestMapping(value = "/template", method = RequestMethod.POST)
	public @ResponseBody Boolean saveSyndromeTemplate(@RequestBody Syndrome syndrome) {
		return syndromeService.saveSyndromeTemplate(syndrome);
	}
	
	@RequestMapping(value = "/template/{name}", method = RequestMethod.POST)
	public @ResponseBody Boolean updateSyndromeTemplate(@PathVariable("name") String name, @RequestBody Syndrome syndrome, HttpServletRequest request) {
		return syndromeService.updateSyndromeTemplate(URIUtils.decodePathVariable(request.getRequestURI(), 2), syndrome);
	}
	
	@RequestMapping(value = "/template/{name}/user/{id}", method = RequestMethod.POST)
	public @ResponseBody Boolean wireUserToSyndromeTemplate(@PathVariable("name") String syndromeName, @PathVariable("id") Long userId, HttpServletRequest request) {
		return syndromeService.wireUserToSyndromeTemplate(URIUtils.decodePathVariable(request.getRequestURI(), 2), userId);
	}
	
	@RequestMapping(value = "template/{name}", method = RequestMethod.GET)
	public @ResponseBody Syndrome getSyndromeByName(@PathVariable("name") String templateName, HttpServletRequest request) {
		return syndromeService.getSyndromeByName(URIUtils.decodePathVariable(request.getRequestURI(), 2));
	}

	@RequestMapping(value = "/template/{name}/severityLevelFormula", method = RequestMethod.GET)
	public @ResponseBody String getSyndromeSeverityLevelFormula(HttpServletRequest request) {
		String decodedSyndromeName = URIUtils.decodePathVariable(request.getRequestURI(), 2);
		return syndromeService.getSybdromeFormula(decodedSyndromeName, SyndromeFormulaType.SEVERITY_LEVEL).getFormulaExpression();
	}

	@RequestMapping(value = "/template/{name}/insufficiencyLevelFormula", method = RequestMethod.GET)
	public @ResponseBody String getSyndromeInsufficiencyLevelFormula(HttpServletRequest request) {
		String decodedSyndromeName = URIUtils.decodePathVariable(request.getRequestURI(), 2);
		return syndromeService.getSybdromeFormula(decodedSyndromeName, SyndromeFormulaType.INSUFFICIENCY_LEVEL).getFormulaExpression();
	}
	
	@RequestMapping(value = "/template/{name}/severityLevelFormula", method = RequestMethod.POST)
	public @ResponseBody Boolean saveSyndromeSeverityLevelFormula(@RequestParam("formula") String formula, HttpServletRequest request) {
		//TODO validate formula
		String decodedSyndromeName = URIUtils.decodePathVariable(request.getRequestURI(), 2);
		syndromeService.saveSyndromeFormula(decodedSyndromeName, SyndromeFormulaType.SEVERITY_LEVEL, formula);
		return true;
	}

	@RequestMapping(value = "/template/{name}/insufficiencyLevelFormula", method = RequestMethod.POST)
	public @ResponseBody Boolean saveSyndromeInsufficiencyLevelFormula(@RequestParam("formula") String formula, HttpServletRequest request) {
		//TODO validate formula
		String decodedSyndromeName = URIUtils.decodePathVariable(request.getRequestURI(), 2);
		syndromeService.saveSyndromeFormula(decodedSyndromeName, SyndromeFormulaType.INSUFFICIENCY_LEVEL, formula);
		return true;
	}
	
}
