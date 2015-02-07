package com.immunology.logic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.DrugDao;
import com.immunology.logic.service.DrugService;
import com.immunology.model.Drug;
import com.immunology.model.Survey;
import com.immunology.model.ui.EfficacyData;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	private CrudDao crudDao;
	@Autowired
	private DrugDao drugDao;
	
	public List<Drug> getAllDrags() {
		return crudDao.getAll(Drug.class);
	}

	public List getDrugSpecies(String type) {
		return drugDao.getDrugSpecies(type);
	}

	public List<Drug> getDrugsType() {
		return drugDao.getDrugsType();
	}

	public List getDrugNames(String species) {
		return drugDao.getDrugNames(species);
	}

	public void saveEfficiencyData(EfficacyData data, Long surveyId) {
		Survey survey = crudDao.find(Survey.class, surveyId);
		if(survey.getEfficacyData() == null) {
			survey.setEfficacyData(data);
		} else {
			data.setId(survey.getEfficacyData().getId());
		}
		data.setSurvey(survey);
		crudDao.saveOrUpdate(data);
	}

	public EfficacyData getEfficacyDataBySurveyId(Long surveyId) {
		return drugDao.getEfficacyDataBySurveyId(surveyId);
	}

}