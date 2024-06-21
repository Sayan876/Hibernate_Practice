package com.fetchmany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.toomany.Student;

public class FetchStudentByBatchCode {
	 public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the batch the batch code to get Student list");
			String bc = sc.next();
			EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
			Query query = manager.createQuery("select b.students from Batch b where b.batch_code=?1");
			query.setParameter(1, bc);
			List<Student> st = query.getResultList();
			if(st.isEmpty()) 
			{
				System.err.println("No data found");
			}else {
				for(Student s:st) {
					System.out.println(s);
				}
			}}
}
