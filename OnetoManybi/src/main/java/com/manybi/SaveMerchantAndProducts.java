package com.manybi;
import java.util.Arrays;

import javax.persistence.*;
public class SaveMerchantAndProducts {
   public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	Merchant mer = new Merchant();
	mer.setName("Black Smith");
	mer.setPhone(123412341234L);
	mer.setGst_number("asdf1234");
	mer.setPassword("asdfasdf");
	
	Product p1 = new Product();
	p1.setName("laptop");
	p1.setBrand("Lenovo");
	p1.setCatagory("electronics");
	p1.setDescription("Flexible");
	p1.setCost(25000);
	p1.setM(mer);
	
	Product p2 = new Product();
	p2.setName("Mobile");
	p2.setBrand("Realme");
	p2.setCatagory("electronics");
	p2.setDescription("8GB ram");
	p2.setCost(15000);
	p2.setM(mer);
	
	Product p3 = new Product();
	p3.setName("Handgun");
	p3.setBrand("Mike Weaponary");
	p3.setCatagory("Weapon");
	p3.setDescription("7 bullets");
	p3.setCost(55000);
	p3.setM(mer);
	
	mer.setProduct(Arrays.asList(p1,p2,p3));
	manager.persist(mer);
	transaction.begin();
	transaction.commit();
}
}
