package com.immunology.logic.utils.enums;

public enum USER_ROLES {

	ROLE_ADMIN("ROLE_ADMIN"), ROLE_USER("ROLE_USER"), ROLE_DOCTOR("ROLE_DOCTOR");

	private String value;
	
	private USER_ROLES(String roleName) {
		this.value = roleName;
	}

	public String getValue() {
		return value;
	}
}
