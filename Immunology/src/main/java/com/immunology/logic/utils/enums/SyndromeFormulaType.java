package com.immunology.logic.utils.enums;

public enum SyndromeFormulaType {

	SEVERITY_LEVEL("severityLevel"), INSUFFICIENCY_LEVEL("insufficiencyLevel");
	
	private SyndromeFormulaType(String name) {
		this.name = name;
	}
	
	private String name;

	public String getName() {
		return name;
	}
}
