package com.org.control;

import java.util.*;
import com.datainst.Dao.*;
import com.merch.dto.*;

public class RunProduct {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ProductDao pdao = new ProductDao();
		System.out.println("1. Insert Product details");
		System.out.println("2. Update product details");
		System.out.println("3. Find products by Brand");
		System.out.println("4. Find products by category");
		System.out.println("5. Find products by Name");
		System.out.println("6. Find products by id");
		System.out.println("7. Find products by Merchant_id");
		System.out.println("8. Find all Products");
		System.out.println("Enter the Option");
		switch (sc.nextInt()) {
		case 1: {

			System.out.println("Enter the merchant id to add product");
			int merchant_id = sc.nextInt();
			Product pro = new Product();
			System.out.println("Enter the product details");
			System.out.println("Enter the name");
			pro.setName(sc.next());
			System.out.println("Enter the Brand");
			pro.setBrand(sc.next());
			System.out.println("What's the category");
			pro.setCategory(sc.next());
			System.out.println("what is it exactly?");
			pro.setDescription(sc.next());
			System.out.println("Great! Put the image link below");
			pro.setImg_url(sc.next());

			pro.setCost(sc.nextDouble());
			pro = pdao.saveProduct(pro, merchant_id);

			if (pro != null) {
				System.out.println("Product saved");
			} else {
				System.out.println("Cannot insert product");
			}

		}
			break;

		case 2: {
			System.out.println("Enter the details to update the product");
			Product prod = new Product();
			System.out.println("Enter the product id");
			prod.setId(sc.nextInt());
			System.out.println("Enter the name");
			prod.setName(sc.next());
			System.out.println("Enter the brand");
			prod.setBrand(sc.next());
			System.out.println("Set the category");
			prod.setCategory(sc.next());
			System.out.println("now Category");
			prod.setDescription(sc.next());
			System.out.println("ImageUrl please");
			prod.setImg_url(sc.next());
			prod.setCost(sc.nextDouble());

			prod = pdao.updateProduct(prod);

			if (prod != null) {
				System.out.println("Product has been updated successfully");

			} else {
				System.out.println("Something's wrong");
			}
		}
			break;

		case 3: {
			System.out.println("Enter the brand name to fetch products");
			String brand = sc.next();
			List<Product> prod = pdao.fetchproByBrand(brand);

			if (prod != null) {
				System.out.println(prod);
			} else {
				System.out.println("Bang! Something's wrong...");
			}

		}
			break;

		case 4: {
			System.out.println("Enter the category to fetch the product");
			String cat = sc.next();
			List<Product> prod = pdao.fetchproByCate(cat);
			if (prod.isEmpty()) {
				System.out.println("Cannot find what you are looking for");
			} else {
				System.out.println(prod);
			}
		}
			break;

		case 5: {
			System.out.println("Enter the name to Find products");
			String pname = sc.next();
			List<Product> prod = pdao.fetchproByName(pname);
			if (prod.isEmpty()) {
				System.out.println("Cannot find what you are looking for");
			} else {
				System.out.println(prod);
			}
		}
			break;

		case 6: {
			System.out.println("Enter the id to Find products");
			int pid = sc.nextInt();
			Product prod = pdao.fetchproById(pid);
			if (prod != null) {
				System.out.println(prod);
			} else {
				System.err.println("No idea boss");
			}
		}
			break;

		case 7: {
			System.out.println("Enter the Merchant id to fetch Products");
			int mid = sc.nextInt();
			List<Product> prod = pdao.fetchByMerchantId(mid);
			if (prod.isEmpty()) {
				System.out.println("Cannot find what you are looking for");
			} else {
				System.out.println(prod);
			}
		}
			break;

		case 8: {
			System.out.println("Here's what we have");
			List<Product> prod = pdao.fetchEverything();
			if (prod.isEmpty()) {
				System.out.println("Sorry nothing's here");
			} else {
				System.out.println(prod);
			}

		}
			break;
		default:
			System.out.println("Invalid option");
			System.exit(0);
		}

	}
}
