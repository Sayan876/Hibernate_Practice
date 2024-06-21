package com.fetchmany;
import javax.persistence.*;
import java.util.*;
import com.toomany.*;
public class FetchStudentByBatchId {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the batch Id to get Student list");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select b.students from Batch b where b.id=?1");
		query.setParameter(1, id);
		List<Student> st = query.getResultList();
		if(st.isEmpty()) 
		{
			System.err.println("No data found");
		}else {
			for(Student s:st) {
				System.out.println(s);
			}
		}
	}
}
