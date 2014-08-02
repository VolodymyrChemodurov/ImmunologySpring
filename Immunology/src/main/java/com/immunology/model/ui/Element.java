package com.immunology.model.ui;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.immunology.model.ui.elements.DropDown;
import com.immunology.model.ui.elements.Panel;
import com.immunology.model.ui.elements.TextBox;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Panel.class),
        @JsonSubTypes.Type(value=DropDown.class),
        @JsonSubTypes.Type(value=TextBox.class)
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Element {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "element_id")
	private long id;

	private String name;

	private int place;

	private boolean checked;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "panel_id")
	private Panel panel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public int getOrder() {
		return place;
	}

	public void setOrder(int order) {
		this.place = order;
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

	@Override
	public String toString() {
		return "Element [id=" + id + ", name=" + name + ", checked=" + checked
				+ "]";
	}

}