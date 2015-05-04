package com.fairsoft.banqueapp.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODE_CLIENT")
	private Long codeClient;
	@Column(name="NOM_CLIENT")
	private String nomClient;
	@Column(name="Adress_CLIENT")
	private String adressClient;
	
	@OneToMany(mappedBy="client", fetch=FetchType.LAZY)
	private Collection<Compte> comptes;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	


	public Client(String nomClient, String adressClient) {
		super();
		this.nomClient = nomClient;
		this.adressClient = adressClient;
	}






	public String getAdressClient() {
		return adressClient;
	}






	public void setAdressClient(String adressClient) {
		this.adressClient = adressClient;
	}






	public Long getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(Long codeClient) {
		this.codeClient = codeClient;
	}
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
	
	
	
	
	
	
}
