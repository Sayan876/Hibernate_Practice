package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*;
public class FindProductByBrand {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the brand");
	String brd = sc.nextLine();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select p from Product p where p.brand=?1");
	query.setParameter(1, brd);
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
