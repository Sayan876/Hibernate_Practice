package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*;
public class CatchProductByMerchantPhone {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Merchant's phone to Fetch their products");
	long phn = sc.nextLong();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select m.product from Merchant m where m.phone=?1");
	query.setParameter(1, phn);
	List<Product> pro = query.getResultList();
	if(pro.isEmpty()) {
		System.err.println("Error 404");
	}else {
		for(Product p:pro) {
			System.out.println(p);
		}
	}
}
}
