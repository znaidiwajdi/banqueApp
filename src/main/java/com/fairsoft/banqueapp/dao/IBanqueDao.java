package com.fairsoft.banqueapp.dao;

import java.util.List;

import com.fairsoft.banqueapp.entities.Client;
import com.fairsoft.banqueapp.entities.Compte;
import com.fairsoft.banqueapp.entities.Employe;
import com.fairsoft.banqueapp.entities.Groupe;
import com.fairsoft.banqueapp.entities.Operation;

public interface IBanqueDao {
	public Client addClient(Client c);
	public Employe addEmploye(Employe e, Long codeSup);
	public Groupe addGroupe(Groupe g);
	public void addEmployeToGroupe(Long codeEmp, Long codeGrp);
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp );
	public Operation addOperation(Operation op, String codeCpte,Long codeEmp);
	public Compte consulterCompte(String codeCmpt);
	public List<Operation> consulterOperation(String codeCpte);
	public Client consulterClient(Long codecli);
	public List<Client> consulterClients(String mc);
	public List<Compte> getCompteByClient(Long codeCli);
	public List<Compte> getComptesByEmploye(Long codeEmp);
	public List<Employe> getEmployes();
	public List<Groupe> getGroupes();
	public List<Employe> getEmployesByGroupe(Long codeGrp);
}
