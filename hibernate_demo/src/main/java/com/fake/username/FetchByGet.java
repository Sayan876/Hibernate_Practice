package com.fake.username;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class FetchByGet {
     public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id you wanna fetch the details of");
		int id = sc.nextInt();
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		user usr = session.get(user.class, id);
		if(usr!=null) {
			System.out.println("User found");
			System.out.println(usr);
		}else {
			System.out.println("Invalid Id");
		}
	}
}
