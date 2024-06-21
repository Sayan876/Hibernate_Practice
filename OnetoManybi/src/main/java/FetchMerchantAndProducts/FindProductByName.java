package FetchMerchantAndProducts;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.manybi.Product;

public class FindProductByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the brand");
		String pnm = sc.nextLine();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select p from Product p where p.name=?1");
		query.setParameter(1, pnm);
		List<Product> per = query.getResultList();
		if(per.isEmpty()) {
			System.err.println("Error 404");
		}else {
			for(Product p:per) {
				System.out.println(p);
			}
		}
	}
}
