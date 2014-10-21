package com.immunology.model.ui.elements.impl;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.immunology.model.ui.elements.Computable;
import com.immunology.model.ui.elements.Element;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")

@Entity
@Table(name = "button_group")
public class ButtonGroup extends Element implements Computable {

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Double> values;
	
	private Double selected;
	
	private Double multiplier;

	public Double getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(Double multiplier) {
		this.multiplier = multiplier;
	}

	public Set<Double> getValues() {
		return values;
	}

	public void setValues(Set<Double> values) {
		this.values = values;
	}

	public Double getSelected() {
		return selected;
	}

	public void setSelected(Double selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "ButtonGroup [values=" + values + ", selected=" + selected
				+ ", multiplier=" + multiplier + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((multiplier == null) ? 0 : multiplier.hashCode());
		result = prime * result
				+ ((selected == null) ? 0 : selected.hashCode());
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ButtonGroup other = (ButtonGroup) obj;
		if (multiplier == null) {
			if (other.multiplier != null)
				return false;
		} else if (!multiplier.equals(other.multiplier))
			return false;
		if (selected == null) {
			if (other.selected != null)
				return false;
		} else if (!selected.equals(other.selected))
			return false;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}

}
