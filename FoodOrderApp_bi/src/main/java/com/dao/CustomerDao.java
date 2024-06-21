package com.dao;

import com.dto.*;
import javax.persistence.*;
import java.util.*;

public class CustomerDao {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();

	public Customer saveCustomer(Customer cust) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(cust);
		transaction.commit();
		return cust;
	}

	public Customer updateCustomer(Customer cust) {
		EntityTransaction transaction = manager.getTransaction();
		Customer custo = manager.find(Customer.class, cust.getId());
		if (custo != null) {
			custo.setName(cust.getName());
			custo.setAge(cust.getAge());
			custo.setGender(cust.getGender());
			custo.setPassword(cust.getPassword());
			custo.setPhone(cust.getPhone());
			custo.setEmail(cust.getEmail());
			transaction.begin();
			transaction.commit();

			return cust;
		} else {
			return null;
		}
	}
	
	public Customer findbyid(int id) {
		Query query = manager.createQuery("select c from Customer c where c.id=?1");
		query.setParameter(1,id);
		
		try {
			return (Customer)query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public Customer verifybyPhoneAndPassword(long ph, String pass) {
		Query query = manager.createQuery("select c from Customer c where c.phone=?1 and c.password=?2");
		query.setParameter(1, ph);
		query.setParameter(2, pass);
		try {
			return (Customer)query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public Customer VerifybyEmailAndPassword(String email, String pass) {
		Query query = manager.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, pass);
		
		try {
			return (Customer)query.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
}
