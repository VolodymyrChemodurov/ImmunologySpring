package com.immunology.logic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.SyndromeDao;
import com.immunology.logic.dao.UserDao;
import com.immunology.logic.service.SyndromeService;
import com.immunology.logic.utils.ReferenceHelper;
import com.immunology.logic.utils.UserUtils;
import com.immunology.model.Syndrome;

@Service
public class SyndromeServiceImpl implements SyndromeService {

	@Autowired
	private SyndromeDao syndromeDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CrudDao crudDao;
	
	public Syndrome getPatientSyndrome(Long patientId, String syndromeName) {
		Syndrome syndrome = syndromeDao.getPatientSyndrome(patientId, syndromeName);
		if(syndrome == null) {
			User user = UserUtils.getCurrentUser();
			syndrome = syndromeDao.getUserSyndromeTemplate(userDao.findByLogin(user.getUsername()).getId(), syndromeName);
		}
		return syndrome;
	}

	public Syndrome saveSyndrome(Syndrome syndrome) {
		ReferenceHelper.setTemplatesReferences(syndrome);
		return crudDao.saveOrUpdate(syndrome);
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

	public List<String> getSyndromeNames() {
		return syndromeDao.getSyndromeNames();
	}

	public Boolean saveSyndromeTemplate(Syndrome syndrome) {
		return syndromeDao.saveSyndromeTemplate(syndrome);
	}

	public Boolean updateSyndromeTemplate(String templateName, Syndrome syndrome) {
		return syndromeDao.updateSyndromeTemplate(templateName, syndrome);
	}

	public Boolean wireUserToSyndromeTemplate(String syndromeName, Long userId) {
		Syndrome syndrome = syndromeDao.findSyndrome(syndromeName);
		com.immunology.model.User user = new com.immunology.model.User();
		List<com.immunology.model.User> users = new ArrayList<com.immunology.model.User>();
		users.add(user);
		syndrome.setUsers(users);
		return syndromeDao.updateSyndromeTemplate(syndromeName, syndrome);
	}

	public Syndrome getSyndromeByName(String syndromeName) {
		return syndromeDao.findSyndrome(syndromeName);
	}

}
