package com.immunology.logic.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.SyndromeDao;
import com.immunology.logic.dao.UserDao;
import com.immunology.logic.service.SyndromeService;
import com.immunology.logic.service.calculation.FormulaBuilder;
import com.immunology.logic.service.calculation.impl.SurveyCalculatorService;
import com.immunology.logic.utils.ReferenceHelper;
import com.immunology.logic.utils.UserUtils;
import com.immunology.logic.utils.enums.FormulaType;
import com.immunology.model.Syndrome;
import com.immunology.model.calculation.Formula;

@Service
public class SyndromeServiceImpl implements SyndromeService {

	private static final Logger LOG = LoggerFactory.getLogger(SyndromeServiceImpl.class);
	
	@Autowired
	private SyndromeDao syndromeDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CrudDao crudDao;
	
	@Autowired
	private SurveyCalculatorService surveyCalculatorService;
	
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
		cleanSyndromeTemplateBeforeSaving(syndrome);
		return syndromeDao.saveSyndromeTemplate(syndrome);
	}

	public Boolean updateSyndromeTemplate(String templateName, Syndrome syndrome) {
		cleanSyndromeTemplateBeforeSaving(syndrome);
/*		List<Syndrome> syndromes = syndromeDao.getSyndromesByName(templateName);
		for(Syndrome currentSyndrome: syndromes) {
			adjustSyndromeMultipliers(currentSyndrome, syndrome);
		}*/
		return syndromeDao.updateSyndromeTemplate(templateName, syndrome);
	}

	@Transactional
	public Boolean wireUserToSyndromeTemplate(String syndromeName, Long userId) {
		Syndrome syndrome = syndromeDao.findSyndrome(syndromeName);
		com.immunology.model.User user  = crudDao.find(com.immunology.model.User.class, userId);
		syndrome.getUsers().add(new com.immunology.model.User.UserBuilder().withId(user.getId()).build());
		return syndromeDao.updateSyndromeTemplate(syndromeName, syndrome);
	}

	public Syndrome getSyndromeByName(String syndromeName) {
		return syndromeDao.findSyndrome(syndromeName);
	}

	public Formula getSyndromeFormula(String syndromeName, FormulaType formulaType) {
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
		Iterator<Formula> iterator = syndrome.getFormulas().iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getType().equals(formula.getType())) {
				iterator.remove();
				break;
			}
		}
		syndrome.getFormulas().add(formula);
		syndromeDao.updateSyndromeTemplate(syndoromeName, syndrome);
	}

	public void removeSyndromeTemplateFromUser(String syndromeName, Long userId) {
		LOG.info("removeSyndromeTemplateFromUser method: syndromeName={}, userId={}", syndromeName, userId);
		Syndrome syndrome = syndromeDao.findSyndrome(syndromeName);
		List<com.immunology.model.User> users = syndrome.getUsers();
		Iterator<com.immunology.model.User> iterator = users.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getId() == userId) {
				LOG.info("Removing " + userId);
				iterator.remove();
			}
		}
		syndromeDao.updateSyndromeTemplate(syndromeName, syndrome);
	}
	
	private void cleanSyndromeTemplateBeforeSaving(Syndrome syndromeTemplate) {
		List<com.immunology.model.User> cleanedUsers = new ArrayList<com.immunology.model.User>(syndromeTemplate.getUsers().size());
		for(com.immunology.model.User user: syndromeTemplate.getUsers()) {
			cleanedUsers.add(new com.immunology.model.User.UserBuilder().withId(user.getId()).build());
		}
		syndromeTemplate.setUsers(cleanedUsers);
	}
	
/*	private void adjustSyndromeMultipliers(Syndrome syndrome, Syndrome template) {
		List<Survey> surveys = syndrome.getSurveys();
		for(Survey survey: surveys) {
			
		}
	}
	
	private void adjustFormMultipliers(Form form, From template) {
		List<Panel> panels = form.getPanels(); 
		for(int i = 0; i < panels.size(); i++) {
			Element[] elements = new Element[panels.get(i).getElements().size()];
			panels.get(i).getElements().toArray(elements);
			for(int j = 0; j < elements.length; j++) {
				Element element = elements[j];
				if(element instanceof Computable) {
					((Computable) element).setMultiplier(multiplier);
				}
			}
		}
	}*/
}
