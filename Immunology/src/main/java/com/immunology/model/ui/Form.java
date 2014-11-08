package com.immunology.model.ui;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.immunology.model.ui.elements.impl.Panel;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@JsonSubTypes({
        @JsonSubTypes.Type(value=MedicalCardForm.class),
        @JsonSubTypes.Type(value=LaboratoryDataForm.class),
        @JsonSubTypes.Type(value=ClinicalManifestationsForm.class),
        @JsonSubTypes.Type(value=ComplaintsForm.class),
        @JsonSubTypes.Type(value=AnamnesticDataForm.class),
        @JsonSubTypes.Type(value=DiagnosisVerificationData.class),
        @JsonSubTypes.Type(value=InstrumentalData.class),
        @JsonSubTypes.Type(value=MainTreatmentData.class),
        @JsonSubTypes.Type(value=MorphologicalData.class),
        @JsonSubTypes.Type(value=PreventiveMeasuresData.class),
        @JsonSubTypes.Type(value=RehabilitationData.class)
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Form {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "form_id")
	private Long id;
	
	@Column(name = "form_name")
	private String name;
	
	@OneToMany(mappedBy = "form", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy("place ASC")
	@JsonManagedReference("panels_reference")
	private List<Panel> panels;

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
	
	public List<Panel> getPanels() {
		return panels;
	}
	
	public void setPanels(List<Panel> panels) {
		this.panels = panels;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", name=" + name + ", panels=" + panels + "]";
	}
	
}
