package com.immunology.model.ui.elements;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.immunology.model.ui.Element;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")

@Entity
@Table(name = "buttongroup")
public class ButtonGroup extends Element{

	private int choosed;

	public int getChoosed() {
		return choosed;
	}

	public void setChoosed(int choosed) {
		this.choosed = choosed;
	}

	@Override
	public String toString() {
		return "ButtonGroup [choosed=" + choosed + "]";
	}
	
}
