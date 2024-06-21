package com.fake.username;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchAndUpdate {
    public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		user usr = session.get(user.class, 1);
		usr.setName("Mohammed D Luffy");
		usr.setEmail("Nami@gmail.com");
		transaction.commit();
	}
}
