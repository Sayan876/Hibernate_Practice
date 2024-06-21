package com.fake.username;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchIDbyName {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name you wanna fetch the ids of!");
		String name = sc.next();
		String hql = "select u.id from user u where u.name=?1";
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query<Integer> query = session.createQuery(hql);
		query.setParameter(1,name);
		
		for(Integer id:query.getResultList()) {
			System.out.println(id);
		}
}
}
