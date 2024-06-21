package com.order;
import javax.persistence.*;
public class UpdateFoodCost {
   public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	transaction.begin();
	FoodOrder order = manager.find(FoodOrder.class,1);
	order.setCost(169.79);
	
	
	transaction.commit();
	System.out.println("Updated!");
}
}
