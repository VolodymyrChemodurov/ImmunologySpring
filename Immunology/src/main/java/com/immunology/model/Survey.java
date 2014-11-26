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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.immunology.model.ui.ClinicalManifestationsForm;
import com.immunology.model.ui.ComplaintsForm;
import com.immunology.model.ui.DiagnosisVerificationData;
import com.immunology.model.ui.EfficacyData;
import com.immunology.model.ui.InstrumentalData;
import com.immunology.model.ui.LaboratoryDataForm;
import com.immunology.model.ui.MainTreatmentData;
import com.immunology.model.ui.MorphologicalData;
import com.immunology.model.ui.PreventiveMeasuresData;
import com.immunology.model.ui.RehabilitationData;

@Entity
@Table(name = "surveys")
@JsonInclude(Include.NON_NULL)
public class Survey {

	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name = "severity_level")
	private Double severityLevel;
	
	@Column(name = "insufficiency_level")
	private Double insufficiencyLevel;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "disease_id")
	@JsonBackReference("surveys_reference")
	private Syndrome disease;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "complaints_form_id")
	private ComplaintsForm complaintsForm;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "clinical_manifestations_form_id")
	private ClinicalManifestationsForm clinicalManifestationsForm;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "laboratory_data_form_id")
	private LaboratoryDataForm laboratoryDataForm;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "morphological_data_id")
	private MorphologicalData morphologicalData;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "instrumental_data_id")
	private InstrumentalData instrumentalData;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "diagnosis_verification_data_id")
	private DiagnosisVerificationData diagnosisVerificationData;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "main_treatment_data_id")
	private MainTreatmentData mainTreatmentData;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "rehabilitation_data_id")
	private RehabilitationData rehabilitationData;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "preventive_measures_data_id")
	private PreventiveMeasuresData preventiveMeasuresData;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "efficacy_data_data_id")
	private EfficacyData efficacyData;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonBackReference("user_reference")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Double getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(Double severityLevel) {
		this.severityLevel = severityLevel;
	}

	public Double getInsufficiencyLevel() {
		return insufficiencyLevel;
	}

	public void setInsufficiencyLevel(Double insufficiencyLevel) {
		this.insufficiencyLevel = insufficiencyLevel;
	}

	public Syndrome getDisease() {
		return disease;
	}

	public void setDisease(Syndrome disease) {
		this.disease = disease;
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

	public MorphologicalData getMorphologicalData() {
		return morphologicalData;
	}

	public void setMorphologicalData(MorphologicalData morphologicalData) {
		this.morphologicalData = morphologicalData;
	}

	public InstrumentalData getInstrumentalData() {
		return instrumentalData;
	}

	public void setInstrumentalData(InstrumentalData instrumentalData) {
		this.instrumentalData = instrumentalData;
	}

	public DiagnosisVerificationData getDiagnosisVerificationData() {
		return diagnosisVerificationData;
	}

	public void setDiagnosisVerificationData(
			DiagnosisVerificationData diagnosisVerificationData) {
		this.diagnosisVerificationData = diagnosisVerificationData;
	}

	public MainTreatmentData getMainTreatmentData() {
		return mainTreatmentData;
	}

	public void setMainTreatmentData(MainTreatmentData mainTreatmentData) {
		this.mainTreatmentData = mainTreatmentData;
	}

	public RehabilitationData getRehabilitationData() {
		return rehabilitationData;
	}

	public void setRehabilitationData(RehabilitationData rehabilitationData) {
		this.rehabilitationData = rehabilitationData;
	}

	public PreventiveMeasuresData getPreventiveMeasuresData() {
		return preventiveMeasuresData;
	}

	public void setPreventiveMeasuresData(
			PreventiveMeasuresData preventiveMeasuresData) {
		this.preventiveMeasuresData = preventiveMeasuresData;
	}

	public EfficacyData getEfficacyData() {
		return efficacyData;
	}

	public void setEfficacyData(EfficacyData efficacyData) {
		this.efficacyData = efficacyData;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
