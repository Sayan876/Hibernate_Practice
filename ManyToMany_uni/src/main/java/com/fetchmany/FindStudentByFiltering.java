package com.fetchmany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.toomany.Student;

public class FindStudentByFiltering {
public static void main(String[] args) {
		
		System.out.println("Students filtered by percentage in between 40 and 70");
	    EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	    Query query = manager.createQuery("select s from Student s where s.perc between 40 AND 70");
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
