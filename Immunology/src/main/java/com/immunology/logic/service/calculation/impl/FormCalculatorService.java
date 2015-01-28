package com.immunology.logic.service.calculation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import net.objecthunter.exp4j.ExpressionBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.immunology.logic.service.calculation.CalculatorService;
import com.immunology.model.calculation.Formula;
import com.immunology.model.ui.Form;
import com.immunology.model.ui.elements.Computable;
import com.immunology.model.ui.elements.Element;
import com.immunology.model.ui.elements.impl.Panel;

@Service
public class FormCalculatorService implements CalculatorService<Form> {
	private static final Logger LOG = LoggerFactory.getLogger(FormCalculatorService.class);
	
	private static final String VARIABLE_NAME = "x";
	private List<Element> templateElements;

	public Double calculate(Form entity, Form template, Formula formula) {
		initTemplateElementsList(template);
		Double result = 0.0;
		if (formula != null && formula.getFormulaExpression() != null && entity != null) {
			List<Panel> panels = entity.getPanels();
			for (Panel panel : panels) {
				result += calculate(panel, formula);
			}
		}
		return result;
	}

	private Double calculate(Panel panel, Formula formula) {
		Double result = 0.0;
		for (Element element : panel.getElements()) {
			if (element.getClass().equals(Panel.class)) {
				result += calculate((Panel) element, formula);
			} else {
				if (element instanceof Computable && element.isChecked()) {
					Computable computableElement = (Computable) element;
					if(computableElement.getValue() != null) {
						Double multiplier = findElementMultiplier(element);
						result += new ExpressionBuilder(
							formula.getFormulaExpression())
							.variable(VARIABLE_NAME)
							.build()
							.setVariable(VARIABLE_NAME, multiplier * computableElement.getValue())
							.evaluate();
					}
				}
			}
		}
		return result;
	}
	
	private Double findElementMultiplier(final Element element) {
		Double result = new Double(0);
		try {
			Element templateElement = Iterables.find(templateElements, new Predicate<Element>() {
				public boolean apply(Element templateElement) {
					return templateElement.getFormElementId().equals(element.getFormElementId()) ? true : false;
				}
			});
			result = ((Computable) templateElement).getMultiplier();
		} catch (NoSuchElementException e) {
			LOG.warn("Couldn't find element with elementId {} in template", element.getFormElementId());
		}
		return result;
	}
	
	private void initTemplateElementsList(Form formTemplate) {
		templateElements = new ArrayList<Element>();
		List<Panel> panels = formTemplate.getPanels();
		for (Panel panel : panels) {
			getPanelElements(panel);
		}
	}
	
	private void getPanelElements(Panel panel) {
		for (Element element : panel.getElements()) {
			if (element.getClass().equals(Panel.class)) {
				getPanelElements((Panel) element);
			} else {
				if (element instanceof Computable) {
					templateElements.add(element);
				}
			}
		}
	}
}
