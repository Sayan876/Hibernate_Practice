package com.fake.username;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchAllphone {
   public static void main(String[] args) {
	String hql = "select u.phone from user u";
	Session session = new Configuration().configure().buildSessionFactory().openSession();
	Query<Long> query = session.createQuery(hql);
	for(Long phone:query.getResultList()) {
		System.out.println(phone);
	}
}
}
