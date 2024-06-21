package com.fake.username;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class DeleteOrg {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the ID to delete user");
	int id = sc.nextInt();
	Session session = new Configuration().configure().buildSessionFactory().openSession();
	Transaction t = session.beginTransaction();
	user usr = session.get(user.class, id);
	if(usr!=null) {
		session.delete(usr);
		t.commit();
	}else {
		System.err.println("Id not found!");
	}
}
}
