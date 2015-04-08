package com.immunology.model.ui;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.immunology.logic.utils.enums.DrugTolerance;
import com.immunology.logic.utils.enums.EfficacyEvaluation;
import com.immunology.logic.utils.enums.SideEffectsSeverityDegree;
import com.immunology.logic.utils.json.CustomJsonDateDeserializer;
import com.immunology.logic.utils.json.CustomJsonDateSerializer;
import com.immunology.model.Survey;
import com.immunology.model.drug.Drug;

@Entity
@Table(name = "efficacy_data")
public class EfficacyData {

	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	private Date updateDate;
	
	@OneToOne
	@JoinColumn(name="syndrome_id", referencedColumnName = "id")
	@JsonBackReference("efficacy_reference")
	private Survey survey;
	
	@Column(name = "drug_tolerance")
	@Enumerated(EnumType.STRING)
	private DrugTolerance drugTolerance; 
	
	@Column(name = "efficacy_evaluation")
	@Enumerated(EnumType.STRING)
	private EfficacyEvaluation efficacyEvaluation;
	
	@Column(name = "side_effect_description")
	private String sideEffectDescription;
	
	@Column(name = "side_effects_severity_degree")
	@Enumerated(EnumType.STRING)
	private SideEffectsSeverityDegree sideEffectsSeverityDegree;
	
	private Boolean cancel;
	
	@ManyToMany(mappedBy = "efficacyData", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Drug> drugs;
	
	@PrePersist
	private void prePersist() {
		this.update();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.update();
	}
	
	private void update() {
		this.updateDate = new Date();
	}
	
	public DrugTolerance getDrugTolerance() {
		return drugTolerance;
	}

	public void setDrugTolerance(DrugTolerance drugTolerance) {
		this.drugTolerance = drugTolerance;
	}

	public EfficacyEvaluation getEfficacyEvaluation() {
		return efficacyEvaluation;
	}

	public void setEfficacyEvaluation(EfficacyEvaluation efficacyEvaluation) {
		this.efficacyEvaluation = efficacyEvaluation;
	}

	public String getSideEffectDescription() {
		return sideEffectDescription;
	}

	public void setSideEffectDescription(String sideEffectDescription) {
		this.sideEffectDescription = sideEffectDescription;
	}

	public SideEffectsSeverityDegree getSideEffectsSeverityDegree() {
		return sideEffectsSeverityDegree;
	}

	public void setSideEffectsSeverityDegree(
			SideEffectsSeverityDegree sideEffectsSeverityDegree) {
		this.sideEffectsSeverityDegree = sideEffectsSeverityDegree;
	}

	public Boolean getCancel() {
		return cancel;
	}

	public void setCancel(Boolean cancel) {
		this.cancel = cancel;
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrug(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
			
}