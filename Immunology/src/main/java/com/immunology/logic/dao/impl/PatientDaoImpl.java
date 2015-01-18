package com.immunology.logic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.immunology.logic.dao.PatientDao;
import com.immunology.model.Patient;
@Repository
public class PatientDaoImpl implements PatientDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<Patient> fingByUserId(long userId) {
		TypedQuery<Patient> query = entityManager.createQuery("SELECT patient FROM Patient patient WHERE user_id = :user_id", Patient.class);
		query.setParameter("user_id", userId);
		List<Patient> results = query.getResultList();
		initUsersCollection(results);
		return results.isEmpty() ? null : results; 
	}

	public List retrievePatientSexStatistic() {
		return entityManager.createNativeQuery("SELECT sex, COUNT(id) FROM patient GROUP BY sex").getResultList();
	}

	@Transactional
	public Patient getPatientById(Long patientId) {
		TypedQuery<Patient> query = entityManager.createQuery("SELECT patient FROM Patient patient WHERE id = :patient_id", Patient.class);
		query.setParameter("patient_id", patientId);
		List<Patient> result = query.getResultList();
		initUsersCollection(result);
		return result.size() > 0 ? result.get(0) : null; 
	}

	@Transactional
	public List<Patient> getAllPatients() {
		List<Patient> patients = entityManager.createQuery("SELECT patient FROM Patient patient", Patient.class).getResultList();
		initUsersCollection(patients);
		return patients;
	}
	
	private void initUsersCollection(List<Patient> patients) {
		for(Patient patient: patients) {
			patient.getUsers().size();
		}
	}

}
