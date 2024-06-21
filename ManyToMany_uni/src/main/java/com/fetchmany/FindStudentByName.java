package com.fetchmany;
import javax.persistence.*;
import java.util.*;
import com.toomany.*;
public class FindStudentByName {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the name of the student");
	String sname = sc.nextLine();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select s from Student s where s.name =?1");
	query.setParameter(1, sname);
	List<Student> st = query.getResultList();
	if(st.isEmpty()) {
		System.err.println("Empty list");
	}else {
		for(Student s:st) 
		{
			System.out.println(s);
		}
	}
}
}
