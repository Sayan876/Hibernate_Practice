package com.fake.username;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {
	
	public static void main(String[] args) {
		user usr = new user();
		usr.setName("Luffy");
		usr.setPhone(876587123L);
		usr.setEmail("mdluffy@gmail.com");
		usr.setPassword("nami");
		Configuration cfg = new Configuration ().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		int id = (Integer) session.save(usr);
		Transaction t = session.beginTransaction();
		t.commit();
		System.out.println("User saved with id: " + id);
		
	}

}
