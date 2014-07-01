package com.immunology.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.immunology.model.ui.AnamnesticDataForm;
import com.immunology.model.ui.MedicalCardForm;
import com.immunology.model.ui.Survey;

@Entity
@Table(name = "diseases")
public class Disease {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "disease_name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private AnamnesticDataForm anamnesticData;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private MedicalCardForm medicalCard;
	
	@OneToMany(mappedBy = "disease")
	private List<Survey> surveys;

	public AnamnesticDataForm getAnamnesticData() {
		return anamnesticData;
	}

	public void setAnamnesticData(AnamnesticDataForm anamnesticData) {
		this.anamnesticData = anamnesticData;
	}

	public MedicalCardForm getMedicalCard() {
		return medicalCard;
	}

	public void setMedicalCard(MedicalCardForm medicalCard) {
		this.medicalCard = medicalCard;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

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
	
}
