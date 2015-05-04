package com.fairsoft.banqueapp.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="RET")
public class Retrait extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait( Date dateOperation, double montant) {
		super(dateOperation, montant);
		// TODO Auto-generated constructor stub
	}

	
	
}
