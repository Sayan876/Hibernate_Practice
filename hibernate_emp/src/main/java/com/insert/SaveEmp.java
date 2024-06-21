package com.insert;
import java.util.*;
import org.emp.same.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class SaveEmp {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Employee emp = new Employee();
	System.out.println("Enter the name");
	String name = sc.nextLine();
	emp.setName(name);
	System.out.println("Enter phone number and it's must be unique");
	int phone = sc.nextInt();
	emp.setPhone(phone);
	System.out.println("Enter email and it shouldn't be existing");
	String email = sc.next();
	emp.setEmail(email);
	System.out.println("Enter the designation");
	String designation = sc.next();
	emp.setDesignation(designation);
	System.out.println("Enter the salary");
	int salary = sc.nextInt();
	emp.setSalary(salary);
	System.out.println("Now set the Password");
	String password = sc.next();
	emp.setPassword(password);
	Session session = new Configuration().configure().buildSessionFactory().openSession();
	int id = (Integer) session.save(emp);
	Transaction t = session.beginTransaction();
	t.commit();
	System.out.println("User saved with the id");
}
}
