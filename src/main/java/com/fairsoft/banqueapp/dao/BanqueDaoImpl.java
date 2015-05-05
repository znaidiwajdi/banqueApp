package com.fairsoft.banqueapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fairsoft.banqueapp.entities.Client;
import com.fairsoft.banqueapp.entities.Compte;
import com.fairsoft.banqueapp.entities.Employe;
import com.fairsoft.banqueapp.entities.Groupe;
import com.fairsoft.banqueapp.entities.Operation;
@Repository
@Transactional
public class BanqueDaoImpl implements IBanqueDao{
	
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private SessionFactory sf;

	
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Client addClient(Client c) {
		em.persist(c);
		return c;
	}


	public Client addClientSf(Client c) {
		Session session= sf.getCurrentSession();
		session.persist(c);
		return c;
	}
	
	@Override
	public Employe addEmploye(Employe e, Long codeSup) {
		if(codeSup != null){
			Employe sup= em.find(Employe.class, codeSup);
			e.setEmployeSup(sup);
		}
		em.persist(e);
		return e;
	}

	@Override
	public Groupe addGroupe(Groupe g) {
		em.persist(g);
		return null;
	}

	@Override
	public void addEmployeToGroupe(Long codeEmp, Long codeGrp) {
		
		Employe e= em.find(Employe.class, codeEmp);
		Groupe g=em.find(Groupe.class, codeGrp);
		e.getGroupes().add(g);
		g.getEmployes().add(e);
		
		//em.persist(g);
		
	}

	@Override
	public Compte addCompte(Compte cp, Long codeCli, Long codeEmp) {
		Client c=em.find(Client.class, codeCli);
		Employe e=em.find(Employe.class, codeEmp);
		cp.setClient(c);
		cp.setEmploye(e);
		em.persist(cp);
		
		return cp;
	}

	@Override
	public Operation addOperation(Operation op, String codeCpte, Long codeEmp) {
		
		Compte c=consulterCompte(codeCpte);
		Employe e=em.find(Employe.class, codeEmp);
		op.setEmploye(e);
		op.setCompte(c);
		em.persist(op);
		return op;
	}

	@Override
	public Compte consulterCompte(String codeCmpt) {
		
		Compte c= em.find(Compte.class, codeCmpt);
		if(c==null) throw new RuntimeException(" compte introuvable");
		return c;
	}

	@Override
	public List<Operation> consulterOperation(String codeCpte) {
		
		Query q=em.createQuery("select o from Operation o where o.compte.numCompte = :x ");
		q.setParameter("x", codeCpte);
		
		return q.getResultList();
	}

	@Override
	public Client consulterClient(Long codecli) {
		Client c= em.find(Client.class, codecli);
		if(c==null) throw new RuntimeException(" Client introuvable");
		return c;
	}

	@Override
	public List<Client> consulterClients(String mc) {
		Query req=em.createQuery("select c from Client c where c.nomClient like :x");
		req.setParameter("x", "%"+mc+"%");
		return req.getResultList();
	}

	@Override
	public List<Compte> getCompteByClient(Long codeCli) {
		
		Query q=em.createQuery("select cp from Compte cp where cp.client.codeClient = :z");
		q.setParameter("z", codeCli);
		return q.getResultList();
		
		
	}

	@Override
	public List<Compte> getComptesByEmploye(Long codeEmp) {
		
		Query req=em.createQuery("select c from Compte where c.employe.codeEmploye = :e");
		req.setParameter("e", codeEmp);
		
		return req.getResultList();
	}

	@Override
	public List<Employe> getEmployes() {
		Query req=em.createQuery("select e from Employe e");
		return req.getResultList();
	}

	@Override
	public List<Groupe> getGroupes() {
		Query req=em.createQuery("select g from Groupe g");
		return req.getResultList();
	}

	@Override
	public List<Employe> getEmployesByGroupe(Long codeGrp) {
		Query req=em.createQuery("select e from Employe e where e.groupes.numGroupe = :x");
		req.setParameter("x", codeGrp);
		
		return req.getResultList();
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	
}
