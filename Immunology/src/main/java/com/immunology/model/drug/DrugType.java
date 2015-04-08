package com.immunology.model.drug;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "drug_types")
@JsonInclude(Include.NON_NULL)
public class DrugType {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "type", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference("species_reference")
	private List<DrugSpecies> drugSpecies;

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

	public List<DrugSpecies> getDrugSpecies() {
		return drugSpecies;
	}

	public void setDrugSpecies(List<DrugSpecies> drugSpecies) {
		this.drugSpecies = drugSpecies;
	}
	
}
