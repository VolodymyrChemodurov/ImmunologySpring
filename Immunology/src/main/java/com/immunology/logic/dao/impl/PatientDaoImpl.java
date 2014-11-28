package com.immunology.logic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.immunology.logic.dao.PatientDao;
import com.immunology.model.Patient;
@Repository
public class PatientDaoImpl implements PatientDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Patient> fingByUserId(long userId) {
		TypedQuery<Patient> query = entityManager.createQuery("SELECT patient FROM Patient patient WHERE user_id = :user_id", Patient.class);
		query.setParameter("user_id", userId);
		List<Patient> results = query.getResultList();
		return results.isEmpty() ? null : results; 
	}

	public List retrievePatientSexStatistic() {
		return entityManager.createNativeQuery("SELECT sex, COUNT(id) FROM patient GROUP BY sex").getResultList();
	}

}
