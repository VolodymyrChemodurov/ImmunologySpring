package com.immunology.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.immunology.model.ui.MedicalCardForm;

@Entity
@Table(name = "patient")
public class Patient {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "patients", cascade = CascadeType.ALL)
	private Set<User> users = new HashSet<User>();
	
	@OneToMany(mappedBy = "patient")
	@JsonManagedReference
	private List<Syndrome> diseases;
	
	@OneToOne(mappedBy="patient", cascade=CascadeType.ALL)
	private MedicalCardForm medicalCard;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	
	@Column(name = "country")
	private String country;

	@Column(name = "region")
	private String region;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "house")
	private String house;

	public boolean addUser(User user) {
		return users.add(user);
	}
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public List<Syndrome> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Syndrome> diseases) {
		this.diseases = diseases;
	}

	public MedicalCardForm getMedicalCard() {
		return medicalCard;
	}

	public void setMedicalCard(MedicalCardForm medicalCard) {
		this.medicalCard = medicalCard;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName="
				+ firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", sex=" + sex + ", dateOfBirth=" + dateOfBirth
				+ ", country=" + country + ", region=" + region + ", city="
				+ city + ", street=" + street + ", house=" + house + "]";
	}
	
}
