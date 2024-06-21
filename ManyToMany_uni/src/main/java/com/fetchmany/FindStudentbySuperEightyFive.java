package com.fetchmany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.toomany.Student;

public class FindStudentbySuperEightyFive {
	public static void main(String[] args) {
		
		System.out.println("Students who got more than 85");
	    EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	    Query query = manager.createQuery("select s from Student s where s.perc>=85");
	    List<Student> st = query.getResultList();
	    if(st.isEmpty()) {
	    	System.err.println("No records Found");
	    }else {
	    	for(Student s:st) {
	    		System.out.println(s);
	    	}
	    }
	}
}
