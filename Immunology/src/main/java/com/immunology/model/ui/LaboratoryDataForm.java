package com.immunology.model.ui;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@Entity
@Table(name = "laboratory_data_forms")
public class LaboratoryDataForm extends Form {

}
