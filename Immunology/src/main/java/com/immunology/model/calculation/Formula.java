package com.immunology.model.calculation;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.immunology.model.Syndrome;

@Entity
@Table(name = "formula")
public class Formula {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "formula_expression")
	private String formulaExpression;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name = "syndrome_id")
	@JsonBackReference("formula_reference")
	private Syndrome syndrome;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFormulaExpression() {
		return formulaExpression;
	}

	public void setFormulaExpression(String formulaExpression) {
		this.formulaExpression = formulaExpression;
	}

	public Syndrome getSyndrome() {
		return syndrome;
	}

	public void setSyndrome(Syndrome syndrome) {
		this.syndrome = syndrome;
	}

}
