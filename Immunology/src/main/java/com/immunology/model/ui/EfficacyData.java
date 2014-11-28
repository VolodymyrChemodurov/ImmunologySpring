package com.immunology.model.ui;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.immunology.model.Drug;

@Entity
@Table(name = "efficacy_data")
public class EfficacyData {

	@Id
	@GeneratedValue
	private Long id;
	
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
	

	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy = "efficacyData", cascade = CascadeType.ALL)
	private List<Drug> drugs;
	
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
			
}