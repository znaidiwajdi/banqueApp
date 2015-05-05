package com.fairsoft.banqueapp.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fairsoft.banqueapp.entities.Client;
import com.fairsoft.banqueapp.entities.Compte;
import com.fairsoft.banqueapp.entities.CompteCourant;
import com.fairsoft.banqueapp.entities.CompteEpargne;
import com.fairsoft.banqueapp.entities.Employe;
import com.fairsoft.banqueapp.entities.Groupe;
import com.fairsoft.banqueapp.entities.Operation;
import com.fairsoft.banqueapp.services.IBanqueService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context= 
				new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
		
		
		IBanqueService metier= (IBanqueService) context.getBean("banqueServiceImpl");
		
//	metier.addClientSf(new Client("P8", "GZZZLLZG")); 
		
		List<Operation> ops= metier.consulterOperation("FR1545457");
	Compte cp= metier.consulterCompte("FR1545457");
		for(Operation op: ops){
			System.out.println("************");
			System.out.println("operation numero  : "+ op.getNumOperation());
			System.out.println("date operation "+op.getDateOperation());
			System.out.println(" Montant transaction "+op.getMontant());
			System.out.println("type tranbsaction: "+op.getClass().getSimpleName());
		}
		System.out.println("************");
		
		System.out.println("solde restant: "+cp.getSolde());
		
		//Compte ce= (Compte) metier.consulterCompte("TN55566644");
		//String codeCli= ce.getNumCompte();
	//	metier.verser(200L, "TN55566644", 2L);
	//	metier.virement(100, "TN55566644", "FR1545457", 3L);
		
		
//		metier.addClient(new Client("A1", "fjedncjd"));
//		metier.addClient(new Client("B5", "njedvvv"));
//		metier.addClient(new Client("R5", "njeddd"));
//		metier.addClient(new Client("Y4", "njedzzzd"));
//		
//		metier.addEmploye(new Employe("1E"), null);
//		metier.addEmploye(new Employe("2E"), (long) 1);
//		metier.addEmploye(new Employe("3E"), (long) 1);
//
//		metier.addGroupe(new Groupe("G1"));
//		metier.addEmployeToGroupe(2L, 1L);
//		metier.addEmployeToGroupe(1L, 1L);
//		metier.addEmployeToGroupe(3L, 1L);
//		CompteCourant cp= (CompteCourant) context.getBean("compteCourant");
//		cp.setDateCreation(new Date());
//		cp.setNumCompte("TN13212545");
//		cp.setSolde(999.222);
//		metier.addCompte(new CompteCourant("TN1562321544", new Date(), 1000L, 100L), 1L, 2L);
		
//		CompteCourant cc=(CompteCourant) context.getBean("compteCourant");
//		cc.setNumCompte("TN55566644");
//		cc.setDateCreation(new Date());
//		cc.setSolde(300L);
//		cc.setDecouvert(100L);
//		metier.addCompte(new CompteCourant("TN55566644", new Date(), 300L, 100L), 2L, 3L);
//		metier.addCompte(new CompteEpargne("FR1545457", new Date(), 2000L, 4.5), 2L, 3L);
		//metier.addCompte(cc, 2L, 3L);
		
	}

}
