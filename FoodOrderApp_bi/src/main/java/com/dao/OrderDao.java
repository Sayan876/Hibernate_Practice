package com.dao;

import javax.persistence.*;
import java.util.*;
import com.dto.*;

public class OrderDao {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();

	public FoodOrder saveOrder(FoodOrder ord, int cust_id) {
		Customer customer = manager.find(Customer.class, cust_id);
		if (customer != null) {
			EntityTransaction transaction = manager.getTransaction();
			customer.getOrders().add(ord);
			ord.setCst(customer);
			manager.persist(ord);
			transaction.begin();
			transaction.commit();
			return ord;
		} else {
			return null;
		}
	}

	public FoodOrder modifyOrder(FoodOrder ord) {
		EntityTransaction transaction = manager.getTransaction();
		FoodOrder order = manager.find(FoodOrder.class, ord.getId());

		if (order != null) {
			order.setFood_item(ord.getFood_item());
			order.setAddress(ord.getAddress());
			order.setCost(ord.getCost());
			transaction.begin();
			transaction.commit();
			return ord;
		} else {
			return null;
		}
	}

	public FoodOrder findbyid(int id) {
		return manager.find(FoodOrder.class, id);
	}

	public List<FoodOrder> findbyPhoneandPass(long phone, String pass) {
		Query query = manager.createQuery("select c.orders from Customer c where c.phone=?1 and c.password=?2");
		query.setParameter(1, phone);
		query.setParameter(2, pass);

		return query.getResultList();
	}
	
	public List<FoodOrder> findbyCustomerid(int id) {
		Query query = manager.createQuery("select c.orders from Customer c where c.id=?1");
		query.setParameter(1, id);
		return query.getResultList();
	}
}
