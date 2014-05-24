package com.immunology.logic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.PatientDao;
import com.immunology.logic.service.PatientService;
import com.immunology.model.Patient;
import com.immunology.model.User;
@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private CrudDao crudDao;
	
	public Patient createPatient(Patient patient) {
		return crudDao.create(patient);
	}

	public Patient updatePatient(Patient patient) {
		return crudDao.saveOrUpdate(patient);
	}

	public List<Patient> getAllPatients() {
		return crudDao.getAll(Patient.class);
	}

	public List<Patient> getMyPatients(User user) {
		return patientDao.fingByUserId(user.getId());
	}

	public Patient getPatientById(long patientId) {
		return crudDao.find(Patient.class, patientId);
	}

}
