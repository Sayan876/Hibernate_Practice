package com.fake.username;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchAllNames {
  public static void main(String[] args) {
	  String hql = "select u.id from user u";
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query<Integer> query = session.createQuery(hql);
		for(Integer id:query.getResultList()) {
			System.out.println(id);
		}
}
}
