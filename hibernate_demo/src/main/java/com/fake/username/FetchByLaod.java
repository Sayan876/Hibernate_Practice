package com.fake.username;

import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchByLaod {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id you wanna fetch the details of");
		int id = sc.nextInt();
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		user usr = session.load(user.class, id);
		try {
			System.out.println(usr);
		}catch(ObjectNotFoundException e) {
			System.err.println("Invalid Id");
		}
}
	
}
