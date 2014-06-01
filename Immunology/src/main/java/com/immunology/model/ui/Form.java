package com.immunology.model.ui;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.immunology.model.User;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="objectType")
@JsonSubTypes({
        @JsonSubTypes.Type(value=MedicalCardForm.class),
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Form {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "form_id")
	private long id;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy = "form", fetch = FetchType.EAGER)
	private Set<Panel> panels;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Panel> getPanels() {
		return panels;
	}
	public void setPanels(Set<Panel> panels) {
		this.panels = panels;
	}
	@Override
	public String toString() {
		return "Form [id=" + id + ", name=" + name + ", panels=" + panels + "]";
	}
	
}
