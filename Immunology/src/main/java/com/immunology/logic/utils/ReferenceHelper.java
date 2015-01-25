package com.immunology.logic.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.immunology.model.Survey;
import com.immunology.model.Syndrome;
import com.immunology.model.ui.MedicalCardForm;
import com.immunology.model.ui.SurveyForm;
import com.immunology.model.ui.elements.Element;
import com.immunology.model.ui.elements.impl.Panel;

public class ReferenceHelper {

	public static void setTemplatesReferences(MedicalCardForm medicalCard) {
		List<Panel> panels = medicalCard.getPanels();
		for(Panel panel: panels) {
			setPanelReferences(panel);
		}
	}
	
	public static void setTemplatesReferences(Syndrome syndrome) {
		List<Panel> panels = syndrome.getAnamnesticData().getPanels();
		for(Panel panel: panels) {
			setPanelReferences(panel);
		}
	}
	
	public static void setTemplateReferences(Survey survey) {
		List<Panel> panels = new ArrayList<Panel>();
		for(SurveyForm form: survey.getForms()) {
			panels.addAll(form.getPanels());
		}
		for(Panel panel: panels) {
			setPanelReferences(panel);
		}
	}
	
	private static void setPanelReferences(Panel panel) {
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
