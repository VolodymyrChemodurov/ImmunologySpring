package com.immunology.logic.service.calculation.impl;

import java.util.List;

import net.objecthunter.exp4j.ExpressionBuilder;

import org.springframework.stereotype.Service;

import com.immunology.logic.service.calculation.CalculatorService;
import com.immunology.model.calculation.Formula;
import com.immunology.model.ui.Form;
import com.immunology.model.ui.elements.Computable;
import com.immunology.model.ui.elements.Element;
import com.immunology.model.ui.elements.impl.Panel;

@Service
public class FormCalculatorService implements CalculatorService<Form> {

	private static final String VARIABLE_NAME = "x";

	public Double calculate(Form entity, Formula formula) {
		Double result = 0.0;
		List<Panel> panels = entity.getPanels();
		for(Panel panel: panels) {
			for(Element element: panel.getElements()) {
				if(element.getClass().equals(Computable.class)) {
					Computable computableElement = (Computable) element;
					result += new ExpressionBuilder(formula.getFormulaExpression()).variable(VARIABLE_NAME)
							.build()
							.setVariable(VARIABLE_NAME, computableElement.getMultiplier() * computableElement.getValue())
							.evaluate();
				}
			}
		}
		return result;
	}

}