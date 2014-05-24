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

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Element {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "element_id")
	private long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "panel_id")
	private Panel panel;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
