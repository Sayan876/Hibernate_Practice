package com.fetchmany;
import javax.persistence.*;
import java.util.*;
import com.toomany.*;
public class FindStudentbyYop {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the year of passing to fetch the student");
    int yp = sc.nextInt();
    EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
    Query query = manager.createQuery("select s from Student s where s.yop=?1");
    query.setParameter(1, yp);
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
