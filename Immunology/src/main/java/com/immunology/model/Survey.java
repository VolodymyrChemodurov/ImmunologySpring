package com.immunology.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.immunology.logic.utils.json.CustomJsonDateDeserializer;
import com.immunology.logic.utils.json.CustomJsonDateSerializer;
import com.immunology.model.ui.EfficacyData;
import com.immunology.model.ui.SurveyForm;

@Entity
@Table(name = "surveys")
@JsonInclude(Include.NON_NULL)
public class Survey {

	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	@JsonSerialize(using = CustomJsonDateSerializer.class)
	private Date creationDate;
	
	@Column(name = "severity_level")
	private Double severityLevel;
	
	@Column(name = "insufficiency_level")
	private Double insufficiencyLevel;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "disease_id")
	@JsonBackReference("surveys_reference")
	private Syndrome disease;
	
	@OneToMany(mappedBy = "survey", cascade = CascadeType.MERGE)
	@JsonManagedReference("survey_forms_reference")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<SurveyForm> forms = new ArrayList<SurveyForm>();
	
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

	public List<SurveyForm> getForms() {
		return forms;
	}

	public void setForms(List<SurveyForm> forms) {
		this.forms = forms;
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
