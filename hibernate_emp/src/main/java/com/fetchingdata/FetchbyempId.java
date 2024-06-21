package com.fetchingdata;

import java.util.List;
import java.util.Scanner;

import org.emp.same.Employee;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class FetchbyempId {
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id you wanna fetch the details of!");
		int id = sc.nextInt();
		String hql = "select e from Employee e where e.id=?1";
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Query<Employee> query = session.createQuery(hql);
		query.setParameter(1,id);
		List<Employee> emps = query.getResultList();
		
		if(emps.isEmpty()) {
			System.out.println("Sorry no users under this id");
		}else {
			for(Employee emp:emps) {
				System.out.println(emp);
			}
		}
}
}
