package com.datainst.Dao;

import javax.persistence.*;
import java.util.*;
import com.merch.dto.*;

public class MerchantDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();

	// Method for inserting details of the merchant
	public Merchant saveMerchant(Merchant merchant) {
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(merchant);
		transaction.commit();
		return merchant;
	}

	public Merchant updateMerchant(Merchant merchant) {
		EntityTransaction transaction = manager.getTransaction();
		Merchant dbMerchant = manager.find(Merchant.class, merchant.getId());
		if (dbMerchant != null) {
			dbMerchant.setName(merchant.getName());
			dbMerchant.setEmail(merchant.getEmail());
			dbMerchant.setPhone(merchant.getPhone());
			dbMerchant.setPassword(merchant.getPassword());
			transaction.begin();
			transaction.commit();
			return merchant;
		} else {
			return null;
		}
	}

	public Merchant verifybyId(int id) {
		return manager.find(Merchant.class, id);
	}

	public Merchant verifybyPhoneAndPassword(long phone, String password) {
		Query query = manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
		query.setParameter(1, phone);
		query.setParameter(2, password);
		try {
			return (Merchant) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Merchant verifyByEmailAndPassword(String email, String password) {
		Query query = manager.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			return (Merchant) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Merchant deleteMerchant(int id) {
		EntityTransaction transaction = manager.getTransaction();
		Merchant mer = manager.find(Merchant.class, id);
		if (mer != null) {
			manager.remove(mer);
			transaction.begin();
			transaction.commit();
			return mer;
		} else {
			return null;
		}
	}
}
