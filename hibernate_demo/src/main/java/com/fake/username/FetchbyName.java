package com.fake.username;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
public class FetchbyName {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the name you wanna fetch the details of!");
	String name = sc.next();
	String hql = "select u from user u where u.name=?1";
	Session session = new Configuration().configure().buildSessionFactory().openSession();
	Query<user> query = session.createQuery(hql);
	query.setParameter(1,name);
	List<user> users = query.getResultList();
	
	if(users.isEmpty()) {
		System.out.println("Sorry no users under this name");
	}else {
		for(user usr:users) {
			System.out.println(usr);
		}
	}
	
}
}
