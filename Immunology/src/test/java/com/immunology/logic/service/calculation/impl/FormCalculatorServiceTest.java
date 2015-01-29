package com.immunology.logic.service.calculation.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.immunology.model.calculation.Formula;
import com.immunology.model.ui.Form;
import com.immunology.model.ui.SurveyForm;
import com.immunology.model.ui.elements.Element;
import com.immunology.model.ui.elements.impl.ButtonGroup;
import com.immunology.model.ui.elements.impl.Panel;
import com.immunology.model.ui.elements.impl.TextBox;

@RunWith(MockitoJUnitRunner.class)
public class FormCalculatorServiceTest {

	private static final double RESULT = 2.5;

	private FormCalculatorService target;
	
	private Form form;
	private Form formTemplate;
	private Formula formula;
	
	@Before
	public void init() {
		target = new FormCalculatorService();
		
		formula = new Formula();
		formula.setFormulaExpression("x");
		
		form = buildForm(false);
		formTemplate = buildForm(true);
	}
	
	@Test
	public void testCalculate() {
		double result = target.calculate(form, formTemplate, formula);
		Assert.assertEquals(RESULT, result, 0.0001);
	}

	private Form buildForm(Boolean isTemplate) {
		SurveyForm form = new SurveyForm();
		Panel panel = new Panel();
		Panel subPanel = new Panel();
		subPanel.setPanel(panel);
		
		TextBox textBox = new TextBox();
		textBox.setChecked(true);
		textBox.setFormElementId(1L);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.setChecked(true);
		buttonGroup.setFormElementId(2L);
		
		if(isTemplate) {
			textBox.setMultiplier(0.5);
			buttonGroup.setMultiplier(1.0);
		} else {
			textBox.setValue(1.0);
			buttonGroup.setValue(2.0);
		}
		
		List<Panel> formPanels = new ArrayList<Panel>();
		formPanels.add(panel);
		
		Set<Element> panelElements = new HashSet<Element>();
		panelElements.add(subPanel);
		panelElements.add(textBox);
		panel.setElements(panelElements);
		
		Set<Element> subPanelElements = new HashSet<Element>();
		subPanelElements.add(buttonGroup);
		subPanel.setElements(subPanelElements);
		
		form.setPanels(formPanels);
		return form;
	}
}
