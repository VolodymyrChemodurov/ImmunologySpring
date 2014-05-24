package com.immunology.model.ui.elements;

import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.immunology.model.ui.Element;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")

@Entity
@Table(name = "dropdowns")
public class Dropdown extends Element{

	@ElementCollection
	private Map<String, Double> values;

	public Map<String, Double> getValues() {
		return values;
	}

	public void setValues(Map<String, Double> values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return "Dropdown [values=" + values + "]";
	}
	
}