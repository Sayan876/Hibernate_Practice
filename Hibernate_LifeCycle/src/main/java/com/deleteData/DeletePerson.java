package com.deleteData;
import com.life.*;
import javax.persistence.*;
public class DeletePerson {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Person p = manager.find(Person.class, 1);
		if(p!=null) {
			manager.remove(p);
			transaction.begin();
			transaction.commit();
			System.out.println("record has been deleted");
		}else {
			System.err.println("There is nothing to be deleted");
		}
	}

}
