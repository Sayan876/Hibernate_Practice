package com.fake.username;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindbyPhone {
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
		System.out.println("Enter the phone you wanna fetch the details of!");
		long phone = sc.nextLong();
		String hql = "select u from user u where u.phone=?1";
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query<user> query = session.createQuery(hql);
		query.setParameter(1,phone);
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
