package com.immunology.model.ui;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.immunology.model.Syndrome;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@Entity
@Table(name = "anamnestic_data_forms")
public class AnamnesticDataForm extends Form {

	@OneToOne
	@JoinColumn(name="syndrome_id", referencedColumnName = "id")
	@JsonBackReference("anamnestic_reference")
	private Syndrome disease;

	public Syndrome getDisease() {
		return disease;
	}

	public void setDisease(Syndrome disease) {
		this.disease = disease;
	}

}