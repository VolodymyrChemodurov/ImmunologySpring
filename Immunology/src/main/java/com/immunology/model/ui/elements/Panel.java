package com.immunology.model.ui.elements;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.immunology.model.ui.Element;
import com.immunology.model.ui.Form;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@Entity
@Table(name = "panels")
public class Panel extends Element {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "form_id")
	@JsonBackReference("panels_reference")
	private Form form;

	@OneToMany(mappedBy = "panel", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("place ASC")
	private Set<Element> elements;

	public Set<Element> getElements() {
		return elements;
	}

	public void setElements(Set<Element> elements) {
		this.elements = elements;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	@Override
	public String toString() {
		return "Panel [elements=" + elements + "]";
	}

}
