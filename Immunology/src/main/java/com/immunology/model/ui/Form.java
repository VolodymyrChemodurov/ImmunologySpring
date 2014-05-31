package com.immunology.model.ui;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Form {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "form_id")
	private long id;
	private String name;
	@OneToMany(mappedBy = "form", fetch = FetchType.EAGER )
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
	public Set<Panel> getPanels() {
		return panels;
	}
	public void setPanels(Set<Panel> panels) {
		this.panels = panels;
	}
	@Override
	public String toString() {
		return "Form [id=" + id + ", name=" + name + ", panels=" + panels + "]";
	}
	
}
