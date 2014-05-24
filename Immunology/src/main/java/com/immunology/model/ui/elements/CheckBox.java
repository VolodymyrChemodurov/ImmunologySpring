package com.immunology.model.ui.elements;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.immunology.model.ui.Element;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")

@Entity
@Table(name = "check_boxes")
public class CheckBox extends Element{

	private boolean checked;

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "CheckBox [checked=" + checked + "]";
	}
	
	
}
