package com.fetchmany;
import javax.persistence.*;
import java.util.*;
import com.toomany.*;
public class FindStudentBySubject {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the subject name to fetch students");
	String sub = sc.nextLine();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select b.students from Batch b where b.subject=?1");
	query.setParameter(1, sub);
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
