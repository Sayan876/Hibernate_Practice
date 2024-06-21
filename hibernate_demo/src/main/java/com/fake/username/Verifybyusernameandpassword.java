package com.fake.username;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.NoResultException;



public class Verifybyusernameandpassword {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the phone number and password to verify the user");
	long phone = sc.nextLong();
	System.out.println("Enter the password");
	String password = sc.next();
	String hql = "select u from user u where u.phone=?1 and u.password=:ps";
	Session session = new Configuration().configure().buildSessionFactory().openSession();
	Query<user> query = session.createQuery(hql);
	query.setParameter(1, phone);
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
