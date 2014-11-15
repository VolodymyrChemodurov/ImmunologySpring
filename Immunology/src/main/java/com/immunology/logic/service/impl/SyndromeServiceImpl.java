package com.immunology.logic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.SyndromeDao;
import com.immunology.logic.dao.UserDao;
import com.immunology.logic.service.SyndromeService;
import com.immunology.logic.service.calculation.FormulaBuilder;
import com.immunology.logic.utils.ReferenceHelper;
import com.immunology.logic.utils.UserUtils;
import com.immunology.logic.utils.enums.FormulaType;
import com.immunology.model.Syndrome;
import com.immunology.model.calculation.Formula;

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

	@Transactional
	public Boolean wireUserToSyndromeTemplate(String syndromeName, Long userId) {
		Syndrome syndrome = syndromeDao.findSyndrome(syndromeName);
		com.immunology.model.User user  = crudDao.find(com.immunology.model.User.class, userId);
		syndrome.getUsers().add(user);
		return syndromeDao.updateSyndromeTemplate(syndromeName, syndrome);
	}

	public Syndrome getSyndromeByName(String syndromeName) {
		return syndromeDao.findSyndrome(syndromeName);
	}

	public Formula getSybdromeFormula(String syndromeName, FormulaType formulaType) {
		Syndrome syndrome = syndromeDao.findSyndrome(syndromeName);
		Formula formula = null;
		if(syndrome.getFormulas() != null) {
			for(Formula currentFormula: syndrome.getFormulas()) {
				if(currentFormula.getType().equals(formulaType)) {
					formula = currentFormula;
					break;
				}
			}
		}
		return formula;
	}

	public void saveSyndromeFormula(String syndoromeName, FormulaType formulaType, String formulaExpression) {
		Syndrome syndrome = syndromeDao.findSyndrome(syndoromeName);
		Formula formula = new FormulaBuilder().expression(formulaExpression).formulaType(formulaType).syndrome(syndrome).build();
		syndrome.getFormulas().add(formula);
		syndromeDao.updateSyndromeTemplate(syndoromeName, syndrome);
	}

}
