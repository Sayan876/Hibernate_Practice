package com.fake.username;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveOrUpdate {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		user usr = new user();//Transient state
		usr.setId(7);
		usr.setName("Tariq D Law");
		usr.setEmail("tariq@gmail.com");
		usr.setPhone(12345601);
		usr.setPassword("asdlkfjas");
		session.saveOrUpdate(usr);
		transaction.commit();
	}
}
