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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
@JsonInclude(Include.NON_NULL)
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	private String login;

	private String password;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", 
				joinColumns = {@JoinColumn(name = "user_id")},
				inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private Set<Role> roles = new HashSet<Role>();
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_patient", 
				joinColumns = {@JoinColumn(name = "user_id")},
				inverseJoinColumns = {@JoinColumn(name = "patient_id")})
	private Set<Patient> patients;
	
//	@ManyToMany
//	@JoinTable(name="users_syndromes", 
//		joinColumns={@JoinColumn(name="user_id")}, 
//		inverseJoinColumns={@JoinColumn(name="syndrome_id")})
	@Transient
	private List<Syndrome> syndromeTemplates;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference("user_reference")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Survey> surveys;
	
	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getMiddleName() {
		return middleName;
	}

	public User setMiddleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public User setLogin(String login) {
		this.login = login;
		return this;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public User setRoles(Set<Role> roles) {
		this.roles = roles;
		return this;
	}
	
	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public List<Syndrome> getSyndromeTemplates() {
		return syndromeTemplates;
	}

	public void setSyndromeTemplates(List<Syndrome> syndromeTemplates) {
		this.syndromeTemplates = syndromeTemplates;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public static class UserBuilder {
		
		private User user;
		
		public UserBuilder() {
			user = new User();
		}
		
		public UserBuilder withId(Long id) {
			user.setId(id);
			return this;
		}
		
		public UserBuilder withFirstName(String firstName) {
			user.setFirstName(firstName);
			return this;
		}
		
		public UserBuilder withLastName(String lastName) {
			user.setLastName(lastName);
			return this;
		}
		
		public UserBuilder withMiddletName(String middleName) {
			user.setMiddleName(middleName);
			return this;
		}
		
		public UserBuilder withLogin(String login) {
			user.setLogin(login);
			return this;
		}
		
		public UserBuilder withPassword(String password) {
			user.setPassword(password);
			return this;
		}
		
		public User build() {
			return user;
		}
	}
}
