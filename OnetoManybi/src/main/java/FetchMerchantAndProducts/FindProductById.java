package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*;
public class FindProductById {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the product id to fetch Product");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select p from Product p where p.id=?1");
	query.setParameter(1, id);
	try {
		Product per = (Product) query.getSingleResult();
		System.out.println(per);
	}catch(NoResultException e) {
		System.err.println("Error 404");
	}
}
}
