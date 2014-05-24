package com.immunology.model.ui.elements;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.immunology.model.ui.Element;

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
}
