package com.immunology.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.immunology.model.calculation.Formula;
import com.immunology.model.drug.Drug;
import com.immunology.model.ui.AnamnesticDataForm;

@Entity
@Table(name = "diseases")
@JsonInclude(Include.NON_NULL)
public class Syndrome {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "disease_name")
	private String name;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@OneToOne(mappedBy="disease", cascade=CascadeType.MERGE)
	@JsonManagedReference("anamnestic_reference")
	private AnamnesticDataForm anamnesticData;
	
	@OneToMany(mappedBy = "disease")
	@JsonManagedReference("surveys_reference")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Survey> surveys;

	@ManyToMany
	@JoinTable(name = "syndrome_drugs", 
				joinColumns = {@JoinColumn(name = "syndrome_id")},
				inverseJoinColumns = {@JoinColumn(name = "drug_id")})
	private List<Drug> drugs;
	
//	@ManyToMany(mappedBy = "syndromeTemplates")
//	@LazyCollection(LazyCollectionOption.FALSE)
	@Transient
	private List<User> users = new ArrayList<User>();
	
//	@OneToMany(mappedBy = "syndrome")
//	@JsonManagedReference("formula_reference")
//	@LazyCollection(LazyCollectionOption.FALSE)
	@Transient
	private List<Formula> formulas = new ArrayList<Formula>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<Formula> getFormulas() {
		return formulas;
	}

	public void setFormulas(List<Formula> formulas) {
		this.formulas = formulas;
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	@Override
	public String toString() {
		return "Syndrome [id=" + id + ", name=" + name + "]";
	}

}
