package com.fairsoft.banqueapp.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="CC")
public class CompteCourant extends Compte {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double decouvert;

	
	
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CompteCourant(String numCompte, Date dateCreation, double solde,
			double decouvert) {
		super(numCompte, dateCreation, solde);
		this.decouvert = decouvert;
	}


	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	

}
