package com.immunology.logic.service.calculation;

import com.immunology.logic.utils.enums.FormulaType;
import com.immunology.model.Syndrome;
import com.immunology.model.calculation.Formula;

public class FormulaBuilder {
	
	private Formula formula;
	
	public FormulaBuilder() {
		formula = new Formula();
	}
	
	public FormulaBuilder expression(String expression) {
		formula.setFormulaExpression(expression);
		return this;
	}
	
	public FormulaBuilder formulaType(FormulaType type) {
		formula.setType(type);
		return this;
	}
	
	public FormulaBuilder syndrome(Syndrome syndrome) {
		formula.setSyndrome(syndrome);
		return this;
	}
	
	public Formula build() {
		return formula;
	}
}
