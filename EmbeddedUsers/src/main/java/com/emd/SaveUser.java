package com.emd;
import javax.persistence.*;
import java.util.*;
public class SaveUser {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	User user = new User();
	System.out.println("Enter the name");
    String name = sc.nextLine();
	user.setName(name);
	System.out.println("Set your new Password");
	String pass = sc.next();
	user.setPassword(pass);
	
	UserId userId = new UserId();
	System.out.println("Enter a unique email");
	String email = sc.next();
	userId.setEmail(email);
	System.out.println("Enter a nice phone number");
	long num = sc.nextLong();
	userId.setPhone(num);
	
	user.setUserId(userId);
	
	manager.persist(user);
	transaction.begin();
	transaction.commit();
}
}
