package com.controller;

import java.util.*;
import javax.persistence.*;
import com.dto.*;
import com.Dao.*;

public class EmployeeControl {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		EmployeeDao eDao = new EmployeeDao();
		System.out.println("Enter an option below");
		System.out.println("1.Enter the details to assigne an Employee" + "\n2.Update the Employee"
				+ "\n3.Find Employee by id" + "\n4.Find Employee by department name"
				+ "\n5.Find Employees by designation" + "\n6.Find Employees by Name" + "\n7.Find Employees by Salary"
				+ "\n8.Filter Employees by Salary");
		int op = sc.nextInt();

		switch (op) {
		case 1: {
			System.out.println("Start entering details");
			System.out.println("hey hey! but first enter the department id");
			int id = sc.nextInt();
			Employee emp = new Employee();
			System.out.println("Enter name");
			emp.setName(sc.next());
			System.out.println("Enter the designation");
			emp.setDesignation(sc.next());
			System.out.println("Set a password");
			emp.setPassword(sc.next());
			System.out.println("Enter a unique phone number");
			emp.setPhone(sc.nextLong());
			System.out.println("Enter the salary");
			emp.setSalary(sc.nextDouble());

			emp = eDao.saveEmployee(emp, id);
			if (emp != null) {
				System.out.println("Data inserted successfully!");

			} else {
				System.out.println("Maybe you have done something wrong");
			}
		}
			break;

		case 2: {
			System.out.println("Enter the id to update the Employee data");
			Employee emp = new Employee();

			emp.setId(sc.nextInt());
			System.out.println("Name");
			emp.setName(sc.next());
			System.out.println("Designation");
			emp.setDesignation(sc.next());
			System.out.println("Phone");
			emp.setPhone(sc.nextLong());
			System.out.println("Password");
			emp.setPassword(sc.next());
			System.out.println("Salary");
			emp.setSalary(sc.nextDouble());

			emp = eDao.updateEmployee(emp);

			if (emp != null) {
				System.out.println("Updated!");
			} else {
				System.out.println("Oh no..something's not right");
			}
		}
			break;

		case 3: {
			System.out.println("Enter the id to fetch the Employee details");
			Employee emp = eDao.findbyId(sc.nextInt());
			if (emp != null) {
				System.out.println(emp);
			} else {
				System.err.println("No data");
			}
		}
			break;

		case 4: {
			System.out.println("Enter the Department name to fetch the employees");
			List<Employee> empl = eDao.findbydeptname(sc.next());
			if (empl.isEmpty()) {
				System.err.println("No data");
			} else {
				System.out.println(empl);
			}
		}
			break;

		case 5: {
			System.out.println("Enter the Designation of the Employee");
			List<Employee> empl = eDao.findbyDesg(sc.next());
			if (empl.isEmpty()) {

				System.err.println("no data");
			} else {
				System.out.println(empl);
			}
		}
			break;

		case 6: {
			System.out.println("Enter the Name of the Employee");
			List<Employee> empl = eDao.findByName(sc.next());
			if (empl.isEmpty()) {
				System.err.println("Nothing is here");
			} else {
				System.out.println(empl);
			}

		}
			break;

		case 7: {
			System.out.println("Enter the salary");
			List<Employee> empl = eDao.findbySal(sc.nextDouble());
			if (empl.isEmpty()) {
				System.err.println("No data");
			} else {
				System.out.println(empl);
			}
		}
			break;

		case 8: {
			System.out.println("Enter the max range of the salary");
			List<Employee> empl = eDao.salRange(sc.nextDouble());
			if (empl.isEmpty()) {
				System.err.println("What are you doing?");
			} else {
				System.out.println(empl);
			}
		}
			break;
		default: {
			System.out.println("invalid option");
		}
		}
	}
}
