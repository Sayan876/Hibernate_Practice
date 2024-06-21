package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*;
public class CatchProductsByMerchantId {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Merchant id to Fetch the Products");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select m.product from Merchant m where m.id=?1");
	query.setParameter(1, id);
	List<Product> pro = query.getResultList();
	if(pro.isEmpty()) {
		System.err.println("Empty");
	}else {
		for(Product p:pro) {
			System.out.println(p);
		}
	}
}
}
