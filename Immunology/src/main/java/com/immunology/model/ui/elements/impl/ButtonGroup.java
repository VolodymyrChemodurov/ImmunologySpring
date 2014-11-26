package com.immunology.model.ui.elements.impl;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.immunology.model.ui.elements.Computable;
import com.immunology.model.ui.elements.Element;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")

@Entity
@Table(name = "button_group")
public class ButtonGroup extends Element implements Computable {

	@JsonIgnore
	private Double value;
	
	@Transient
	private Double multiplier;

	public Double getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(Double multiplier) {
		this.multiplier = multiplier;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ButtonGroup [value=" + value + ", multiplier=" + multiplier
				+ "]";
	}

}
