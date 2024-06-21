package com.fetchmany;

import java.util.*;
import com.toomany.*;
import javax.persistence.*;
public class FindStudentBySuperSixty {
   public static void main(String[] args) {
	
	System.out.println("Students who got 60 or more");
    EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
    Query query = manager.createQuery("select s from Student s where s.perc>=60");
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
