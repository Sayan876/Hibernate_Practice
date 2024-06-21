package com.toomany;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.*;

public class SaveBatchAndStudent {
 public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	Batch b1 = new Batch();
	b1.setBatch_code("HID-E4");
	b1.setSubject("Hibernate");
	b1.setTrainer("Sam");
	
	Batch b2 = new Batch();
	b2.setBatch_code("ADD-A7");
	b2.setSubject("Advance Java");
	b2.setTrainer("Sham");
	
	Student s1 = new Student();
	s1.setName("Zelda");
	s1.setYop(2015);
	s1.setPerc(84);
	
	Student s2 = new Student();
	s2.setName("Leon");
	s2.setYop(2011);
	s2.setPerc(86);
	
	Student s3 = new Student();
	s3.setName("Anne");
	s3.setYop(2001);
	s3.setPerc(61);
	
	List<Student> forb1 = new ArrayList<Student>(Arrays.asList(s1,s3));
	List<Student> forb2 = new ArrayList<Student>(Arrays.asList(s1,s2,s3));
	
	b1.setStudents(forb1);
	b2.setStudents(forb2);
	manager.persist(b1);
	manager.persist(b2);
	
	transaction.begin();
	transaction.commit();
	
}
}
