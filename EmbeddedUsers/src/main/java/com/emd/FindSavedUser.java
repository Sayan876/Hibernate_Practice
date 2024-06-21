package com.emd;
import javax.persistence.*;
public class FindSavedUser {
   public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	UserId userId = new UserId();
	userId.setEmail("shanks@gmail.com");
	userId.setPhone(12345101);
	
	User user = manager.find(User.class, userId);
	if(user!=null) {
		System.out.println(user.getName());
		System.out.println(user.getUserId().getPhone());
		System.out.println(user.getUserId().getEmail());
	}else {
		System.err.println("No records found!");
	}
}
}
