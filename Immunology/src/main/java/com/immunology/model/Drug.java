package com.immunology.model;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.immunology.model.ui.EfficacyData;

@Entity
@Table(name = "drugs")
public class Drug {
	@Id
	@GeneratedValue
	private long id;

	@Column(name = "species")
	private String species;

	@Column(name = "type")
	private String type;
	
	@Column(name = "name")
	private String name;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name="drug_efficacy_data", 
		joinColumns={@JoinColumn(name="drug_id")}, 
		inverseJoinColumns={@JoinColumn(name="efficacy_data_id")})
	private List<EfficacyData> efficacyData;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public long getId() {
		return id;
	}

	public Drug setId(long id) {
		this.id = id;
		return this;
	}

	public String getSpecies() {
		return species;
	}

	public Drug setSpecies(String species) {
		this.species = species;
		return this;
	}

	public String getType() {
		return type;
	}

	public Drug setType(String type) {
		this.type = type;
		return this;
	}

	public List<EfficacyData> getEfficacyData() {
		return efficacyData;
	}

	public void setEfficacyData(List<EfficacyData> efficacyData) {
		this.efficacyData = efficacyData;
	}

	@Override
	public String toString() {
		return "Drug [id=" + id + ", species=" + species + ", type=" + type
				+ ", name=" + name + ", efficacyData=" + efficacyData + "]";
	}

}