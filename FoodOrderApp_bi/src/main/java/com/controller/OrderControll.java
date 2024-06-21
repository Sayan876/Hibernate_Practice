package com.controller;

import javax.persistence.*;
import java.util.*;
import com.dao.*;
import com.dto.*;

public class OrderControll {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OrderDao odao = new OrderDao();
		System.out.println("Enter an Option below");
		System.out.println("1.Place an Order" + "\n2.Update Order" + "\n3.Find Order by id"
				+ "\n4.Find Order by customer id" + "\n5.Find Order by Customer phone and password");

		int op = sc.nextInt();

		switch (op) {
		case 1: {

			System.out.println("Enter the details of the product but dont' forget to give the customer id!");
			FoodOrder ord = new FoodOrder();
			int id = sc.nextInt();

			ord.setFood_item(sc.next());
			ord.setAddress(sc.next());
			ord.setCost(sc.nextDouble());

			ord = odao.saveOrder(ord, id);

			if (ord != null) {
				System.out.println("Order placed");
			} else {
				System.out.println("Try again!");
			}
		}
			break;

		case 2: {
			System.out.println("Enter the id to start modifying order");
			FoodOrder order = new FoodOrder();
			order.setId(sc.nextInt());
			System.out.println("Place the address");
			order.setAddress(sc.next());
			System.out.println("Enter the food name");
			order.setFood_item(sc.next());
			System.out.println("Enter the cost");
			order.setCost(sc.nextDouble());

			order = odao.modifyOrder(order);

			if (order != null) {
				System.out.println("Updated");
			} else {
				System.out.println("Something is wrong");
			}

		}
			break;

		case 3: {
			System.out.println("Enter the id");
			FoodOrder order = odao.findbyid(sc.nextInt());
			if (order != null) {
				System.out.println(order);
			} else {
				System.out.println("Beyond the sky");
			}
		}
			break;

		case 4: {
			System.out.println("Enter the customer id to look at orders");
			List<FoodOrder> order = odao.findbyCustomerid(sc.nextInt());
			if (order.isEmpty()) {
				System.out.println("Sorry can't fetch anything bud");
			} else {
				System.out.println(order);
			}
		}
			break;

		case 5: {
			System.out.println("Enter the phone");
			long phone = sc.nextLong();
			System.out.println("Enter the Password");
			String pass = sc.next();
			List<FoodOrder> ord = odao.findbyPhoneandPass(phone, pass);

			if (ord.isEmpty()) {
				System.out.println("Sorry can't fetch anything bud");
			} else {
				System.out.println(ord);
			}

		}
			break;
		default: {
			System.out.println("Invalid option");
		}
		}
	}
}
