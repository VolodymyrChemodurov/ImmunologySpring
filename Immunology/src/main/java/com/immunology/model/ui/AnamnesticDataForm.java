package com.immunology.model.ui;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.immunology.model.Disease;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@Entity
@Table(name = "anamnestic_data_forms")
public class AnamnesticDataForm extends Form {

	@OneToOne(mappedBy = "anamnesticData")
	private Disease disease;

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	
}
