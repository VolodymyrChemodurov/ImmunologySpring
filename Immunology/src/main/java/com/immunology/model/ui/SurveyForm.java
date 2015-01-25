package com.immunology.model.ui;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.immunology.logic.utils.enums.FormType;
import com.immunology.model.Survey;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@Entity
@Table(name = "survey_forms")
public class SurveyForm extends Form {

	@Column(name = "form_type")
	@Enumerated(EnumType.STRING)
	private FormType formType;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "survey_id")
	@JsonBackReference("survey_forms_reference")
	private Survey survey;
	
	public FormType getFormType() {
		return formType;
	}

	public void setFormType(FormType formType) {
		this.formType = formType;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	
}
