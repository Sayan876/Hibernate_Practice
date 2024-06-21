package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*;
public class CatchProductByMerchantIdAndPass {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the id of Merchant");
	int id = sc.nextInt();
	System.out.println("Enter the password of the Merchant");
	String pass = sc.next();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select m.product from Merchant m where m.id=?1 and m.password=?2");
	query.setParameter(1, id);
	query.setParameter(2, pass);
	List<Product> pro = query.getResultList();
	if(pro.isEmpty()) {
		System.err.println("Sorry No data!");
	}else {
		for(Product p:pro) {
			System.out.println(p);
		}
	}
}
}
