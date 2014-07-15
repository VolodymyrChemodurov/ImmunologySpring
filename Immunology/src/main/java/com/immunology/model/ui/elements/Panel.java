package com.immunology.model.ui.elements;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.immunology.logic.utils.ElementDeserializer;
import com.immunology.model.ui.Element;
import com.immunology.model.ui.Form;

@Entity
@Table(name = "panels")
public class Panel {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	private int place;
	
	private boolean checked;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "form_id")
	@JsonBackReference("panels_reference")
	private Form form;
	
	@OneToMany(mappedBy = "panel", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("place ASC")
	//@JsonManagedReference("elements_reference")
	@JsonDeserialize(using = ElementDeserializer.class)
	private Set<Element> elements;
	
	@ManyToOne
	@JsonBackReference("reference")
	private Panel panel;
	
	@OneToMany(mappedBy="panel")
	@OrderBy("place ASC")
	@JsonManagedReference("reference")
	private Set<Panel> panels;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

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
