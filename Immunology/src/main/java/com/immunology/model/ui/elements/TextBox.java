package com.immunology.model.ui.elements;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.immunology.model.ui.Element;

@Entity
@Table(name = "text_boxes")
public class TextBox extends Element{

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
