package com.immunology.logic.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.immunology.logic.service.PatientService;
import com.immunology.logic.service.UserService;
import com.immunology.logic.utils.UserUtils;
import com.immunology.model.Patient;


@Controller
@RequestMapping(value = "/cabinet/patient")
public class PatientController {
	
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
		User user = UserUtils.getCurrentUser();
		patient.addUser(userService.getUserByLogin(user.getUsername()));
		patientService.updatePatient(patient);
		return "redirect:/cabinet";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePatient(Patient patient, Model model, HttpServletResponse response) {	
		patientService.updatePatient(patient);
		
		return "redirect:/cabinet";
	}
	
	@RequestMapping(value = "/id={number}", method = RequestMethod.GET)
	public String showPatient(ModelMap model, @PathVariable("number") int number){
		model.addAttribute("patient", patientService.getPatientById(number));
		
		return "user/components/patient-info";
	}
	
	@RequestMapping(value = "/id={number}", method = RequestMethod.POST)
	public String addPatientToUser( @PathVariable("number") int number, HttpServletResponse response){
	
		User currentUser = UserUtils.getCurrentUser();
		Patient patient = patientService.getPatientById(number);
		com.immunology.model.User user = userService.getUserByLogin(currentUser.getUsername());
		
			user.getPatients().add(patient);
			userService.updateUser(user);
		
		return "redirect:/cabinet";
	}
	
}