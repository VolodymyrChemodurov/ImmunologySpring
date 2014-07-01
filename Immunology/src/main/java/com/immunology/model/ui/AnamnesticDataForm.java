package com.immunology.model.ui;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.immunology.model.Disease;
import com.immunology.model.Patient;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@Entity
@Table(name = "anamnestic_data_forms")
public class AnamnesticDataForm extends Form {

	@ManyToOne
	@JoinColumn(name = "patient_id")
	@JsonIgnore
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "disease_id")
	@JsonIgnore
	private Disease disease;

}
