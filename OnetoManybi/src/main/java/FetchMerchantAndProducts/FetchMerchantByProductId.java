package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*;
public class FetchMerchantByProductId {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Product Id to Fetch Merchant");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
//	Query query = manager.createQuery("select m from Merchant m where m.id = (select p.m from Product p where p.id=?1)");
	Query query = manager.createQuery("select p.m from Product p where p.id=?1");
	query.setParameter(1, id);
	try {
		Merchant mr = (Merchant) query.getSingleResult();
		System.out.println(mr);
	}catch(NoResultException e) {
		System.err.println("Error 404");
	}
}
}
