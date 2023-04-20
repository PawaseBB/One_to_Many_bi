package com.jsp.Bank.Branch;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("bhushan");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Bank bank=new Bank();
		bank.setName("Union_Bank");
		
		Branch branch1= new Branch();
		branch1.setLocation("Vashi");
		branch1.setIfsc_code("JDJHWH286383");
		
		Branch branch2= new Branch();
		branch2.setLocation("Thane");
		branch2.setIfsc_code("JDJHJHIWUGVD7647");
		
		Branch branch3= new Branch();
		branch3.setLocation("Panvel");
		branch3.setIfsc_code("JDJSHUIHF28374");
		
		ArrayList<Branch> branch=new ArrayList<Branch>();
		branch.add(branch1);
		branch.add(branch2);
		branch.add(branch3);
		
		bank.setBranch(branch);
		
		branch1.setBank(bank);
		branch2.setBank(bank);
		branch3.setBank(bank);
		
		entityTransaction.begin();
		entityManager.persist(bank);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();
	}

}
