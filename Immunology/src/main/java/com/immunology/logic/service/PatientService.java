package com.immunology.logic.service;

import java.util.List;

import com.immunology.model.Patient;
import com.immunology.model.User;

public interface PatientService {

	Patient createPatient(Patient patient);
	
	Patient updatePatient(Patient patient);
	
	List<Patient> getAllPatients();
	
	List<Patient> getMyPatients(User user);
	
	Patient getPatientById(long patientId);
	
}
