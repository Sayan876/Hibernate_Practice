package com.fetchmany;
import java.util.*;
import javax.persistence.*;
import com.toomany.*;
public class FindStudentById {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the student id to fetch whole Student database");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select s from Student s where s.id=?1");
	query.setParameter(1, id);
	
	try {
		Student st = (Student) query.getSingleResult();
		System.out.println(st);
	}catch(NoResultException e) {
		System.err.println("Error 404");
	}
}
}
