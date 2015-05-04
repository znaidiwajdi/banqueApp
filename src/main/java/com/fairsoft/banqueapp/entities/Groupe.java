package com.fairsoft.banqueapp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Groupe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="NUM_GRP")
	private Long numGroupe;
	
	public Groupe(String nomGroupe) {
		super();
		this.nomGroupe = nomGroupe;
	}
	@Column(name="NOM_GRP")
	private String nomGroupe;
	@ManyToMany(mappedBy="groupes")
	private Collection<Employe> employes;
	
	
	
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Groupe(Long numGroupe, String nomGroupe) {
		super();
		this.numGroupe = numGroupe;
		this.nomGroupe = nomGroupe;
	}


	public Long getNumGroupe() {
		return numGroupe;
	}
	public void setNumGroupe(Long numGroupe) {
		this.numGroupe = numGroupe;
	}
	public String getNomGroupe() {
		return nomGroupe;
	}
	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}
	public Collection<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}
	
	
	
}
