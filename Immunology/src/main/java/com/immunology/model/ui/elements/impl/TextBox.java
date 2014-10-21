package com.immunology.model.ui.elements.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.immunology.model.ui.elements.Element;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "objectType")
@Entity
@Table(name = "text_boxes")
public class TextBox extends Element {

	private String text;

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

}
