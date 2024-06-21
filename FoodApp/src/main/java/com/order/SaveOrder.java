package com.order;
import javax.persistence.*;
import java.util.*;
public class SaveOrder {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	FoodOrder order = new FoodOrder();
	System.out.println("Enter Food name");
	String x = sc.nextLine();
	order.setFood_item(x);
	System.out.println("Enter the cost");
    double c = sc.nextDouble();
	order.setCost(c);
	transaction.begin();
	manager.persist(order);
	transaction.commit();
}
}
