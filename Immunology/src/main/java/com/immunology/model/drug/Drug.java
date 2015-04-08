package com.immunology.model.drug;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.immunology.model.ui.EfficacyData;

@Entity
@Table(name = "drugs")
@JsonInclude(Include.NON_NULL)
public class Drug {
	
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "species_id")
	@JsonBackReference(value = "drug_reference")
	private DrugSpecies species;
	
	@Column(name = "name")
	private String name;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="drug_efficacy_data", 
		joinColumns={@JoinColumn(name="drug_id")}, 
		inverseJoinColumns={@JoinColumn(name="efficacy_data_id")})
	private List<EfficacyData> efficacyData;

	@Transient
	private String speciesName;
	
	@Transient
	private String typeName;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DrugSpecies getSpecies() {
		return species;
	}

	public void setSpecies(DrugSpecies species) {
		this.species = species;
	}

	public List<EfficacyData> getEfficacyData() {
		return efficacyData;
	}

	public void setEfficacyData(List<EfficacyData> efficacyData) {
		this.efficacyData = efficacyData;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}