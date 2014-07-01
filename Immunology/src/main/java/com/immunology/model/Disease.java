package com.immunology.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private User user;
//	
//	@ManyToOne
//	@JoinColumn(name = "patient_id")
//	private Patient patient;
	
	@OneToMany(mappedBy = "disease")
	private List<AnamnesticDataForm> anamnesticData;
	
	@OneToMany(mappedBy = "disease")
	private List<MedicalCardForm> medicalCard;
	
	@OneToMany(mappedBy = "disease")
	private List<Survey> surveys;


}
