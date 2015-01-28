package com.immunology.model.ui.elements;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.immunology.model.ui.elements.impl.ButtonGroup;
import com.immunology.model.ui.elements.impl.DropDown;
import com.immunology.model.ui.elements.impl.Panel;
import com.immunology.model.ui.elements.impl.TextBox;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Panel.class),
        @JsonSubTypes.Type(value=DropDown.class),
        @JsonSubTypes.Type(value=TextBox.class),
        @JsonSubTypes.Type(value=ButtonGroup.class)
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@JsonInclude(Include.NON_NULL)
public abstract class Element {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "element_id")
	protected Long id;
	
	protected Long formElementId;
	
	protected String name;
	
	protected Integer place;

	protected Boolean checked;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "panel_id")
	private Panel panel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Panel getPanel() {
		return panel;
	}

	public void setPanel(Panel panel) {
		this.panel = panel;
	}

	public Integer getPlace() {
		return place;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public Boolean isChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public Long getFormElementId() {
		return formElementId;
	}

	public void setFormElementId(Long formElementId) {
		this.formElementId = formElementId;
	}

	@Override
	public String toString() {
		return "Element [id=" + id + ", formElementId=" + formElementId
				+ ", name=" + name + ", place=" + place + ", checked="
				+ checked + "]";
	}

}