package com.fairsoft.banqueapp.services;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fairsoft.banqueapp.dao.IBanqueDao;
import com.fairsoft.banqueapp.entities.Client;
import com.fairsoft.banqueapp.entities.Compte;
import com.fairsoft.banqueapp.entities.Employe;
import com.fairsoft.banqueapp.entities.Groupe;
import com.fairsoft.banqueapp.entities.Operation;
import com.fairsoft.banqueapp.entities.Retrait;
import com.fairsoft.banqueapp.entities.Versement;

@Transactional 
public class BanqueServiceImpl implements IBanqueService{
	
	private IBanqueDao dao;
	
	
	
	public void setDao(IBanqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Client addClient(Client c) {
		dao.addClient(c);
		return c;
	}

	@Override
	public Employe addEmploye(Employe e, Long codeSup) {
		dao.addEmploye(e, codeSup);
		return e;
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		dao.addGroupe(g);
		return g;
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGrp) {
		dao.addEmployeToGroupe(codeEmp, codeGrp);
		
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
		dao.addCompte(cp, codeCli, codeEmp);
		
		return cp;
	}

	@Override
	public void verser(double mt, String Cpte, Long codeEmp) {
		
		dao.addOperation(new Versement(new Date(),mt), Cpte, codeEmp); 
		Compte cp=dao.consulterCompte(Cpte);
		cp.setSolde(cp.getSolde()+ mt);
		
	}

	@Override
	public void retirer(double mt, String Cpte, Long codeEmp) {
		dao.addOperation(new Retrait(new Date(),mt), Cpte, codeEmp); 
		Compte cp=dao.consulterCompte(Cpte);
		cp.setSolde(cp.getSolde() - mt);
	}

	@Override
	public void virement(double mt, String Cpte1, String Cpte2, Long codeEmp) {
		
		retirer(mt, Cpte1, codeEmp);
		verser(mt, Cpte2, codeEmp);
		
		
	}

	@Override
	public Compte consulterCompte(String codeCmpt) {
		Compte c=dao.consulterCompte(codeCmpt);
		return c;
	}

	@Override
	public List<Operation> consulterOperation(String codeCpte) {
		
		return dao.consulterOperation(codeCpte);
	}

	@Override
	public Client consulterClient(Long codecli) {
		
		return dao.consulterClient(codecli);
	}

	@Override
	public List<Client> consulterClients(String mc) {
		
		return dao.consulterClients(mc);
	}

	@Override
	public List<Compte> getCompteByClient(Long codeCli) {
		
		return dao.getCompteByClient(codeCli);
	}

	@Override
	public List<Compte> getComptesByEmploye(Long codeEmp) {
		
		return dao.getComptesByEmploye(codeEmp);
	}

	@Override
	public List<Employe> getEmployes() {
		
		return dao.getEmployes();
	}

	@Override
	public List<Groupe> getGroupes() {
		
		return dao.getGroupes();
	}

	@Override
	public List<Employe> getEmployesByGroupe(Long codeGrp) {
		
		return dao.getEmployesByGroupe(codeGrp);
	}

	@Override
	public Client addClientSf(Client c) {
		
		return dao.addClientSf(c);
	}

}
