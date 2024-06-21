package com.entitys;
import com.entitys.*;

import java.time.LocalDate;

import javax.persistence.*;
public class InsertUserPan {
	
	public static void main(String[] args) {
		User u = new User();
		u.setName("Shanks");
		u.setPhone(12341244L);
		u.setPassword("12asd2f");
		u.setEmail("shanks@gmail.com");
		
		PanCard card = new PanCard();
		card.setDob(LocalDate.of(1957, 5, 17));
		card.setNumber("ASDF1234");
		card.setPincode(560076);
		u.setCard(card);
		card.setUser(u);
		
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(u);
		transaction.begin();
		transaction.commit();
	}

}
