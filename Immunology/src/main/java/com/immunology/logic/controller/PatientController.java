package com.immunology.logic.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.immunology.logic.service.PatientService;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.enums.USER_ROLES;
import com.immunology.model.Patient;
@Controller
@RequestMapping(value = "/cabinet/patient")
public class PatientController {
	
	private static final Logger LOG = Logger.getLogger(PatientController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	PatientService patientService;
	

	
	
	@RequestMapping(value="/new",  method=RequestMethod.GET )
    public String getNewPatient(Model model ) {
		model.addAttribute("patient",new Patient());
        return "user/components/new-patient";
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String getRegistrateNewPatient(Patient patient, Model model, HttpServletResponse response) {	
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		patient.setUser( userService.getUserByLogin(user.getUsername()));
		
		patientService.createPatient(patient);
		try {
			response.sendRedirect("/Immunology/cabinet");
		} catch (IOException e) {
			LOG.error(e);
		}
		return "forward:cabinet";
	}
	
	@RequestMapping(value = "/id={number}", method = RequestMethod.GET)
	public String showPatient(ModelMap model, @PathVariable("number") int number){
		
		model.addAttribute("patient", patientService.getPatientById(number));
		
		return "user/components/patient-info";
	}
	
}