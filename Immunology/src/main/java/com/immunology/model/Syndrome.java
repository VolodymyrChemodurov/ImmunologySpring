package com.immunology.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.immunology.model.ui.AnamnesticDataForm;

@Entity
@Table(name = "diseases")
public class Syndrome {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "disease_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@OneToMany(mappedBy = "disease")
	private List<AnamnesticDataForm> anamnesticData;
	
	@OneToMany(mappedBy = "disease")
	private List<Survey> surveys;

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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<AnamnesticDataForm> getAnamnesticData() {
		return anamnesticData;
	}

	public void setAnamnesticData(List<AnamnesticDataForm> anamnesticData) {
		this.anamnesticData = anamnesticData;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

}
