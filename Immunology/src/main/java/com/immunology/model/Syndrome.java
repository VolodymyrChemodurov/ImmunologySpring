package com.immunology.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.immunology.model.ui.AnamnesticDataForm;

@Entity
@Table(name = "diseases")
public class Syndrome {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "disease_name")
	private String name;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@OneToOne(mappedBy="disease")
	@JsonManagedReference("anamnestic_reference")
	private AnamnesticDataForm anamnesticData;
	
	@OneToMany(mappedBy = "disease")
	@JsonManagedReference("surveys_reference")
	private List<Survey> surveys;

	@ManyToMany(mappedBy = "syndromeTemplates")
	private List<User> users;
	
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

	public AnamnesticDataForm getAnamnesticData() {
		return anamnesticData;
	}

	public void setAnamnesticData(AnamnesticDataForm anamnesticData) {
		this.anamnesticData = anamnesticData;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
