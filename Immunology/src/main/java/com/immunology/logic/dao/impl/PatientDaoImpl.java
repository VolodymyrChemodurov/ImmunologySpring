package com.immunology.logic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.immunology.logic.dao.PatientDao;
import com.immunology.model.Patient;
import com.immunology.model.User;
@Repository
public class PatientDaoImpl implements PatientDao{
	
	@PersistenceContext
	private EntityManager em;

	public List<Patient> fingByUserId(long userId) {
		TypedQuery<Patient> query = em.createQuery("SELECT patient FROM Patient patient WHERE user_id = :user_id", Patient.class);
		query.setParameter("user_id", userId);
		List<Patient> results = query.getResultList();
		return results.isEmpty() ? null : results; 
	}

}
