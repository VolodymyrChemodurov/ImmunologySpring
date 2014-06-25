package com.immunology.model.ui;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.immunology.model.Patient;
import com.immunology.model.User;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@Entity
@Table(name = "surveys")
public class Survey extends Form {
	
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name = "severity_level")
	private double severityLevel;
	
	@Column(name = "insufficiency_level")
	private double insufficiencyLevel;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private ComplaintsForm complaintsForm;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private ClinicalManifestationsForm clinicalManifestationsForm;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private LaboratoryDataForm laboratoryDataForm;
	
	@Transient
	private User user;
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

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

	@Override
	public String toString() {
		return "Survey [creationDate=" + creationDate + ", severityLevel="
				+ severityLevel + ", insufficiencyLevel=" + insufficiencyLevel
				+ ", patient=" + patient + ", complaintsForm=" + complaintsForm
				+ ", clinicalManifestationsForm=" + clinicalManifestationsForm
				+ ", laboratoryDataForm=" + laboratoryDataForm + ", user="
				+ user + "]";
	}

}
