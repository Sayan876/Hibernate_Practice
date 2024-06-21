package com.fake.username;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

public class FetchAllUsers {
   public static void main(String[] args) {
	Session session = new Configuration().configure().buildSessionFactory().openSession();
	Query<user> query = session.createQuery("select u from user u");
	List<user> users = query.getResultList();
	if(users.isEmpty()) {
		System.err.println("No users present");
		
	}else {
		for(user usr:users) {
			System.out.println(usr);
		}
	}
}
}
