package com.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveDepartmentEmp {
   public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	Department d = new Department();
	d.setLocation("Ohio");
	d.setName("Development");
	
	Employee e1 = new Employee();
	e1.setName("Max Payne");
	e1.setDesg("Senior SDE");
	e1.setSalary(10000);
	e1.setDepartment(d);
	
	Employee e2 = new Employee();
	e2.setName("Max Payne");
	e2.setDesg("Senior SDE");
	e2.setSalary(10000);
	e2.setDepartment(d);
	
	Employee e3 = new Employee();
	e3.setName("Max Payne");
	e3.setDesg("Senior SDE");
	e3.setSalary(10000);
	e3.setDepartment(d);
	
	
	
	manager.persist(e1);
	manager.persist(e2);
	manager.persist(e3);
	
	transaction.begin();
	transaction.commit();
}
}
