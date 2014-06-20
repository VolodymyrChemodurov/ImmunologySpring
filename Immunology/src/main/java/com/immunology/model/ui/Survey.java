package com.immunology.model.ui;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

	@OneToOne
	@PrimaryKeyJoinColumn
	private ComplaintsForm complaintsForm;
	@OneToOne
	@PrimaryKeyJoinColumn
	private ClinicalManifestationsForm clinicalManifestationsForm;
	@OneToOne
	@PrimaryKeyJoinColumn
	private LaboratoryDataForm laboratoryDataForm;
	
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
	
}
