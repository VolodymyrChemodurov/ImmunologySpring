package com.immunology.logic.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.DrugDao;
import com.immunology.logic.service.DrugService;
import com.immunology.model.Survey;
import com.immunology.model.drug.Drug;
import com.immunology.model.drug.DrugSpecies;
import com.immunology.model.drug.DrugType;
import com.immunology.model.ui.EfficacyData;

@Service
public class DrugServiceImpl implements DrugService {

	private static final Logger LOG = LoggerFactory.getLogger(DrugServiceImpl.class);
	
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
			data.setUpdateDate(new Date());
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

	public Boolean saveOrUpdate(Drug drug) {
		DrugSpecies species = new DrugSpecies();
		species.setName(drug.getSpeciesName());
		species.setId(drugDao.getDrugSpeciesIdByName(species.getName()));
		drug.setSpecies(species);
		DrugType type = new DrugType();
		type.setName(drug.getTypeName());
		type.setId(drugDao.getDrugTypeIdByName(type.getName()));
		species.setType(type);
		return crudDao.saveOrUpdate(drug) != null ? true : false;
	}

	public Drug getById(Long id) {
		return crudDao.find(Drug.class, id);
	}

	public Boolean saveOrUpdate(DrugType drugType) {
		return crudDao.saveOrUpdate(drugType) != null ? true : false;
	}

	public Boolean saveOrUpdate(DrugSpecies drugSpecies) {
		drugSpecies.getType().setId(drugDao.getDrugTypeIdByName(drugSpecies.getType().getName()));
		return crudDao.saveOrUpdate(drugSpecies) != null ? true : false;
	}

	public Boolean deleteDrug(Long drugId) {
		return drugDao.deleteById(drugId);
	}

	public List<Drug> getSyndromeDrugs(String syndromeName) {
		return drugDao.getSyndromeDrugs(syndromeName);
	}

	@Override
	public Long findDrugId(String type, String species, String name) {
		return drugDao.findDrugId(type, species, name);
	}

}