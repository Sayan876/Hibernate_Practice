package com.fetchmany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.toomany.Batch;

public class FindBatchBysubject {
	 public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the subject name");
			String sub = sc.nextLine();
			EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
			Query query = manager.createQuery("select b from Batch b where b.subject=?1");
			query.setParameter(1, sub);
			try {
				Batch bew = (Batch) query.getSingleResult();
				System.out.println(bew);
			}catch(NoResultException e) {
				
			System.err.println("sorry no results");
			}
		}
}
