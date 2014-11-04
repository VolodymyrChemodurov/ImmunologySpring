package com.immunology.model.ui.elements.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.immunology.model.ui.elements.Computable;
import com.immunology.model.ui.elements.Element;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType")
@Entity
@Table(name = "text_boxes")
public class TextBox extends Element implements Computable {

	private String text;

	private Double multiplier;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "TextBox [id=" + id + ", name=" + name + ", checked=" + checked
				+ ", place=" + place + ", text=" + text + "]";
	}

	public Double getMultiplier() {
		return multiplier;
	}

	@JsonIgnore
	public void setMultiplier(Double multiplier) {
		this.multiplier = multiplier;
	}

	@JsonIgnore
	public Double getValue() {
		return this.checked ? 1.0 : 0;
	}

	public void setValue(Double value) {
		if(value > 0) {
			checked = true;
		} else {
			checked = false;
		}
	}

}
