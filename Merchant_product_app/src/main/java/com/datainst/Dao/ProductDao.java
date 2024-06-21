package com.datainst.Dao;

import java.util.List;

import javax.persistence.*;
import com.merch.dto.*;

public class ProductDao {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();

	public Product saveProduct(Product pro, int merchant_id) {
		Merchant merchant = manager.find(Merchant.class, merchant_id);
		if (merchant != null) {
			EntityTransaction transaction = manager.getTransaction();
			merchant.getProducts().add(pro);// Adding product to merchant
			pro.setM(merchant);
			manager.persist(pro);// Assigning Merchant to Product
			transaction.begin();
			transaction.commit();
			return pro;
		} else {
			return null;
		}

	}

	public Product updateProduct(Product pro) {
		EntityTransaction transaction = manager.getTransaction();
		Product product = manager.find(Product.class, pro.getId());
		if (product != null) {
			product.setName(pro.getName());
			product.setCategory(pro.getCategory());
			product.setBrand(pro.getBrand());
			product.setDescription(pro.getDescription());
			product.setImg_url(pro.getImg_url());
			product.setCost(pro.getCost());
			transaction.begin();
			transaction.commit();
			return pro;

		} else {
			return null;
		}

	}

	public List<Product> fetchproByBrand(String brand) {
		Query query = manager.createQuery("select p from Product p where p.brand=?1");
		query.setParameter(1, brand);
		return query.getResultList();
	}

	public List<Product> fetchproByCate(String cate) {
		Query query = manager.createQuery("select p from Product p where p.category=?1");
		query.setParameter(1, cate);
		return query.getResultList();
	}

	public List<Product> fetchproByName(String pname) {
		Query query = manager.createQuery("select p from Product p where p.name=?1");
		query.setParameter(1, pname);
		return query.getResultList();
	}

	public Product fetchproById(int pid) {
		Query query = manager.createQuery("select p from Product p where p.id=?1");
		query.setParameter(1, pid);
		try {
			return (Product) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Product> fetchByMerchantId(int mid) {
		Query query = manager
				.createQuery("select p from Product p where p.m=(select m.id from Merchant m where m.id=?1)");
		query.setParameter(1, mid);
		return query.getResultList();
	}

	public List<Product> fetchEverything() {
		Query query = manager.createQuery("select p from Product p");
		return query.getResultList();
	}
}
