package com.fetchmany;
import javax.persistence.*;
import java.util.*;
import com.toomany.*;
public class FindYoungStudents {
    public static void main(String[] args) {
    	System.out.println("Fetching Young students");
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select s from Student s where s.yop>=2021");
		List<Student> st = query.getResultList();
		if(st.isEmpty()) {
			System.err.println("No data");
		}else {
			for(Student s:st) {
				System.out.println(s);
			}
		}
	}
}
