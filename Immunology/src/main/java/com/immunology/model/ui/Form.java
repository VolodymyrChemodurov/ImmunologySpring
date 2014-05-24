package com.immunology.model.ui;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Form {

	@Id
	@GeneratedValue
	@Column(name = "form_id")
	private long id;
	private String name;
	@OneToMany(mappedBy = "form", fetch = FetchType.EAGER )
	private List<Panel> panels;

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
	public List<Panel> getPanels() {
		return panels;
	}
	public void setPanels(List<Panel> panels) {
		this.panels = panels;
	}
	@Override
	public String toString() {
		return "Form [id=" + id + ", name=" + name + ", panels=" + panels + "]";
	}
	
}
