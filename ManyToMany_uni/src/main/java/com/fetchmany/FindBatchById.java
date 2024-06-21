package com.fetchmany;
import com.toomany.*;
import javax.persistence.*;
import java.util.*;
public class FindBatchById {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the batch id");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select b from Batch b where b.id=?1");
	query.setParameter(1, id);
	try {
		Batch bew = (Batch) query.getSingleResult();
		System.out.println(bew);
	}catch(NoResultException e) {
		
	System.err.println("sorry no results");
	}
}
}
