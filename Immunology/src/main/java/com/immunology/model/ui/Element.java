package com.immunology.model.ui;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.immunology.model.ui.elements.CheckBox;
import com.immunology.model.ui.elements.DropDown;
import com.immunology.model.ui.elements.TextBox;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@JsonSubTypes({
        @JsonSubTypes.Type(value=CheckBox.class),
        @JsonSubTypes.Type(value=DropDown.class),
        @JsonSubTypes.Type(value=TextBox.class),
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Element {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "element_id")
	private long id;
	private String name;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "panel_id")
	private Panel panel;

	private int place;
	
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

	@Override
	public String toString() {
		return "Element [id=" + id + ", name=" + name + ", place=" + place + "]";
	}

}
