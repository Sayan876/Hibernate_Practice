package FetchMerchantAndProducts;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.manybi.Merchant;

public class FetchMerchantbyPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Merchant Phone");
		long mphone = sc.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select m from Merchant m where m.phone=?1");
		query.setParameter(1, mphone);
		try {
			Merchant mr =(Merchant) query.getSingleResult();
			System.out.println(mr);
		}catch(NoResultException e) {
			System.err.println("Error 404");
		}
}
}
