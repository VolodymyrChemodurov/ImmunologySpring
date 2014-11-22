package com.immunology.logic.utils.enums;


public enum FormulaType {

	SEVERITY_LEVEL("severityLevel"), INSUFFICIENCY_LEVEL("insufficiencyLevel");
	
	private FormulaType(String name) {
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}
	
	public static FormulaType getByName(String name) {
		FormulaType result = null;
		for(FormulaType type: FormulaType.values()) {
			if(type.getName().equals(name)) {
				result = type;
				break;
			}
		}
		return result;
	}
}
