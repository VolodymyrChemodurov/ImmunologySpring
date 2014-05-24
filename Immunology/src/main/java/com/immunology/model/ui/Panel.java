package com.immunology.model.ui;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Panel {

	@Id
	@GeneratedValue
	@Column(name = "panel_id")
	private long id;
	private String title;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "form_id")
	private Form form;
	@OneToMany(mappedBy = "panel", fetch = FetchType.EAGER)
	private List<Element> elements;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Element> getElements() {
		return elements;
	}
	public void setElements(List<Element> elements) {
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
		return "Panel [id=" + id + ", title=" + title + ", elements=" + elements + "]";
	}
	
}
