package com.fake.username;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.NoResultException;

public class FetchbyEmailAndPassword {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
		System.out.println("Enter the phone email and password to verify the user");
		String email = sc.next();
		System.out.println("Enter the password");
		String password = sc.next();
		String hql = "select u from user u where u.email=?1 and u.password=:ps";
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query<user> query = session.createQuery(hql);
		query.setParameter(1, email);
		query.setParameter("ps", password);
		
		try {
			user usr = query.getSingleResult();
			System.out.println("Verification Successful");
			System.out.println(usr);
		} catch(NoResultException e) {
			System.err.println("No Users under the details");
		}
}
}
