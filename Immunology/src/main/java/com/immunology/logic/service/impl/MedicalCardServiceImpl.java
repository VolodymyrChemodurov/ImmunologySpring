package com.immunology.logic.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immunology.logic.dao.CrudDao;
import com.immunology.logic.dao.MedicalCardFormDao;
import com.immunology.logic.service.MedicalCardFormService;
import com.immunology.model.ui.Element;
import com.immunology.model.ui.MedicalCardForm;
import com.immunology.model.ui.elements.Panel;

@Service
public class MedicalCardServiceImpl implements MedicalCardFormService{

	@Autowired
	private CrudDao crudDao;
	
	@Autowired
	private MedicalCardFormDao medicalCardDao;
	
	public MedicalCardForm getById(long id) {
		return crudDao.find(MedicalCardForm.class, id);
	}

	public MedicalCardForm updateMedicalCardForm(MedicalCardForm medCardForm) {
		return crudDao.saveOrUpdate(medCardForm);
	}

	public MedicalCardForm getMedicalCardTemplate() {
		return medicalCardDao.getMedicalCardFormTemplate();
	}

	public boolean updateMedicalCardTemplate(MedicalCardForm template) {
		setTemplatesReferences(template);
		return medicalCardDao.updateMedicalCardFormTemplate(template);
	}

	public MedicalCardForm getMedicalCardByPatientId(long id) {
		return medicalCardDao.getMedicalCardByPatientId(id);
	}
	
	private void setTemplatesReferences(MedicalCardForm template) {
		Set<Panel> panels = template.getPanels();
		for(Panel panel: panels) {
			setPanelReferences(panel);
		}
	}
	
	private void setPanelReferences(Panel panel) {
		Set<Element> elements = panel.getElements();
		for(Element element: elements) {
			if(element.getPanel() == null) {
				element.setPanel(panel);
				if(element.getClass().equals(Panel.class)) {
					setPanelReferences((Panel)element);
				}
			}
		}
	}
}
