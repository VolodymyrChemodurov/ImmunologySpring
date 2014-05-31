package com.immunology.model.ui;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@Entity
@Table(name = "medical_forms")
public class MedicalCardForm extends Form {

	@Temporal(TemporalType.DATE)
	@Column(name="creation_date")
	private Date creationDate;
	@Column(name="additional_info")
	private String additionalInfo;
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getAdditionInfo() {
		return additionalInfo;
	}
	public void setAdditionInfo(String additionInfo) {
		this.additionalInfo = additionInfo;
	}
	
}
