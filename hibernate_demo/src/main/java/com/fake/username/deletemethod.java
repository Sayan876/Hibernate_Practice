package com.fake.username;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class deletemethod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the ID you wanna delete");
		int id = sc.nextInt();
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
	
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		user usr = session.get(user.class, id);
		session.delete(usr);
		transaction.commit();
		
	}
}
