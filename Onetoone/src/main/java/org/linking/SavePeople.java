package org.linking;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePeople {
   public static void main(String[] args) {
	Person p = new Person();
	p.setName("Glenn Mcgrath");
	p.setPhone(12345104);
	
	AadharCard card = new AadharCard();
	card.setDob(LocalDate.of(1937,8,17));
	card.setNumber(98765443);
	card.setPincode(560078);
	p.setAdharid(card);
	
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	manager.persist(p);
	manager.persist(card);
	transaction.begin();
	transaction.commit();
}
}
