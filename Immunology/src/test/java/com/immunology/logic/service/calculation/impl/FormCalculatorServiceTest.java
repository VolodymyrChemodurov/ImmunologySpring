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
import com.immunology.model.ui.ComplaintsForm;
import com.immunology.model.ui.Form;
import com.immunology.model.ui.elements.Computable;
import com.immunology.model.ui.elements.Element;
import com.immunology.model.ui.elements.impl.ButtonGroup;
import com.immunology.model.ui.elements.impl.Panel;
import com.immunology.model.ui.elements.impl.TextBox;

@RunWith(MockitoJUnitRunner.class)
public class FormCalculatorServiceTest {

	private FormCalculatorService target;
	
	private Form form;
	private Formula formula;
	private List<Element> elements = new ArrayList<Element>();
	
	@Before
	public void init() {
		target = new FormCalculatorService();
		
		formula = new Formula();
		formula.setFormulaExpression("x");
		
		form = new ComplaintsForm();
		Panel panel = new Panel();
		Panel subPanel = new Panel();
		subPanel.setPanel(panel);
		
		TextBox textBox = new TextBox();
		textBox.setChecked(true);
		textBox.setValue(0.5);
		textBox.setMultiplier(1.0);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.setChecked(true);
		buttonGroup.setValue(0.5);
		buttonGroup.setMultiplier(1.0);
		
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
		
		elements.add(textBox);
		elements.add(buttonGroup);
	}
	
	@Test
	public void testCalculate() {
		double result = target.calculate(form, formula);
		double expected = 0.0;
		for(Element element: elements) {
			expected += ((Computable)element).getValue() * ((Computable)element).getMultiplier();
		}
		Assert.assertEquals(expected, result, 0.0001);
	}

}
