package com.entitys;
import javax.persistence.*;

public class SaveUserPan {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		System.out.println(manager);
	}
	
	
	

}
