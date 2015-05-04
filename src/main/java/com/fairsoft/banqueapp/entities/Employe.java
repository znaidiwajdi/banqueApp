package com.fairsoft.banqueapp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODE_EMP")
	private Long codeEmploye;
	@Column(name="Name_EMP")
	private String namemploye;
	@ManyToOne
	@JoinColumn(name="CODE_EMP_SUP")
	private Employe employeSup;
	@ManyToMany
	@JoinTable(name="EMP_GRP", 
	joinColumns=@JoinColumn(name="CODE_EMP"), 
	inverseJoinColumns=@JoinColumn(name="CODE_GRP"))
	private Collection<Groupe> groupes;
	
	
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Employe(Long codeEmploye, String namemploye) {
		super();
		this.codeEmploye = codeEmploye;
		this.namemploye = namemploye;
	}


	public Employe(String namemploye) {
		super();
		this.namemploye = namemploye;
	}


	public Long getCodeEmploye() {
		return codeEmploye;
	}
	public void setCodeEmploye(Long codeEmploye) {
		this.codeEmploye = codeEmploye;
	}
	
	
	public String getNamemploye() {
		return namemploye;
	}


	public void setNamemploye(String namemploye) {
		this.namemploye = namemploye;
	}


	public Employe getEmployeSup() {
		return employeSup;
	}
	public void setEmployeSup(Employe employeSup) {
		this.employeSup = employeSup;
	}
	public Collection<Groupe> getGroupes() {
		return groupes;
	}
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
	
	
}
