package com.immunology.model.ui.elements;

import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.immunology.model.ui.Element;

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
}