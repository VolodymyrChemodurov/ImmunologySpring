
package com.immunology.logic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.immunology.logic.dao.DrugDao;
import com.immunology.logic.dao.MedicalCardFormDao;
import com.immunology.logic.dao.PatientDao;
import com.immunology.logic.dao.SurveyDao;
import com.immunology.logic.dao.SyndromeDao;
import com.immunology.logic.service.StatisticService;

@Controller
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private MedicalCardFormDao medicalCardDao;
	@Autowired
	private SyndromeDao syndromeDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private SurveyDao surveyDao;
	@Autowired
	private DrugDao drugDao;

	public List retrieveMedicalCardCreationStatistic() {
		return medicalCardDao.retrieveMedicalCardCreationStatistic();
	}

	public List retrieveSyndromePatientStatistic() {
		return syndromeDao.retrieveSyndromePatientStatistic();
	}

	public List retrievePatientSexStatistic() {
		return patientDao.retrievePatientSexStatistic();
	}

	public List retrieveInsufficiency(long patientId) {
		return surveyDao.retrieveInsufficiency(patientId);
	}

	public List retrieveSeverity(long patientId) {
		return surveyDao.retrieveSeverity(patientId);
	}

	public List retrieveDrugTolerance(String name) {
		return drugDao.retrieveDrugTolerance(name);
	}
}
