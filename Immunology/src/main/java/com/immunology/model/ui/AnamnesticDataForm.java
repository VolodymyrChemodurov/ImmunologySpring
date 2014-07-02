package com.immunology.model.ui;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.immunology.model.Syndrome;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@Entity
@Table(name = "anamnestic_data_forms")
public class AnamnesticDataForm extends Form {

	@ManyToOne
	@JoinColumn(name = "disease_id")
	@JsonIgnore
	private Syndrome disease;

	public Syndrome getDisease() {
		return disease;
	}

	public void setDisease(Syndrome disease) {
		this.disease = disease;
	}

}