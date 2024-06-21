package com.controller;

import javax.persistence.*;
import com.Dao.*;
import com.dto.*;
import java.util.*;

public class DepartmentController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao dDao = new DepartmentDao();
		System.out.println("Select an Option below");
		System.out.println("1.Save Department\n2.Update Department");

		int op = sc.nextInt();
		switch (op) {
		case 1: {
			System.out.println("Insert the details to create a department");
			Department dep = new Department();
			System.out.println("Enter the name of Department");
			dep.setName(sc.next());
			System.out.println("Enter the department Location");
			dep.setLocation(sc.next());

			dep = dDao.saveDept(dep);
			if (dep != null) {
				System.out.println("Inserted successfully!");
			} else {
				System.out.println("Sorry! Something's wrong!");
			}

		}
			break;

		case 2: {
			System.out.println("Update department details");
			Department dep = new Department();
			dep.setId(sc.nextInt());
			dep.setName(sc.next());
			dep.setLocation(sc.next());
			dep = dDao.updateDept(dep);
			if (dep != null) {
				System.out.println("Successfully Updated");
			}else {
				System.err.println("Something might be wrong");
			}
			
		}break;
		default: {
			System.out.println("Invalid option");
			System.exit(0);
		}
		}
	}
}
