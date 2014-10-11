package com.immunology.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.immunology.model.ui.ClinicalManifestationsForm;
import com.immunology.model.ui.ComplaintsForm;
import com.immunology.model.ui.LaboratoryDataForm;

@Entity
@Table(name = "surveys")
public class Survey {

	@Id
	@GeneratedValue
	private long id;
	
	@JsonIgnore
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;
	
	@JsonIgnore
	@Column(name = "severity_level")
	private double severityLevel;
	
	@JsonIgnore
	@Column(name = "insufficiency_level")
	private double insufficiencyLevel;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "disease_id")
	@JsonBackReference("surveys_reference")
	private Syndrome disease;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "complaints_form_id")
	private ComplaintsForm complaintsForm;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "clinical_manifestations_form_id")
	private ClinicalManifestationsForm clinicalManifestationsForm;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "laboratory_data_form_id")
	private LaboratoryDataForm laboratoryDataForm;
	
	@Transient
	private User user;
	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(double severityLevel) {
		this.severityLevel = severityLevel;
	}

	public double getInsufficiencyLevel() {
		return insufficiencyLevel;
	}

	public void setInsufficiencyLevel(double insufficiencyLevel) {
		this.insufficiencyLevel = insufficiencyLevel;
	}

	public ComplaintsForm getComplaintsForm() {
		return complaintsForm;
	}

	public void setComplaintsForm(ComplaintsForm complaintsForm) {
		this.complaintsForm = complaintsForm;
	}

	public ClinicalManifestationsForm getClinicalManifestationsForm() {
		return clinicalManifestationsForm;
	}

	public void setClinicalManifestationsForm(
			ClinicalManifestationsForm clinicalManifestationsForm) {
		this.clinicalManifestationsForm = clinicalManifestationsForm;
	}

	public LaboratoryDataForm getLaboratoryDataForm() {
		return laboratoryDataForm;
	}

	public void setLaboratoryDataForm(LaboratoryDataForm laboratoryDataForm) {
		this.laboratoryDataForm = laboratoryDataForm;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Syndrome getDisease() {
		return disease;
	}

	public void setDisease(Syndrome disease) {
		this.disease = disease;
	}

}
