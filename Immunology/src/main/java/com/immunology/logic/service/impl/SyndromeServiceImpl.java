package com.immunology.logic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.SyndromeDao;
import com.immunology.logic.service.SyndromeService;
import com.immunology.model.Syndrome;

@Service
public class SyndromeServiceImpl implements SyndromeService {

	@Autowired
	private SyndromeDao syndromeDao;
	
	public Syndrome getPatientSyndrome(Long patientId, String syndromeName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Syndrome saveSyndrome(Syndrome syndrome) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getPatientSyndromeNames(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Syndrome> getUserSyndromeTemplates(Long userId) {
		return syndromeDao.getUserSyndromeTemplates(userId);
	}

	public List<String> getUserSyndromeTemplateNames(Long userId) {
		return syndromeDao.getUserSyndromeTemplatesNames(userId);
	}

}
