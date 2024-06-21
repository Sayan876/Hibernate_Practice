package com.fake.username;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateObject {
   public static void main(String[] args) {
	Configuration cfg = new Configuration().configure();
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	Transaction transaction = session.beginTransaction();
	user usr = new user();//Transient state
	usr.setId(1);
	usr.setName("Mohammed D Dragon");
	usr.setEmail("dragon@gmail.com");
	usr.setPhone(12345600);
	usr.setPassword("asdlkfjasf");
	session.update(usr);
	transaction.commit();
}
}
