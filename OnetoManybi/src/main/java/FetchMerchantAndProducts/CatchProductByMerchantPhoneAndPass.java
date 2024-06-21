package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*; 
public class CatchProductByMerchantPhoneAndPass {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Merchant's phone");
		long phn = sc.nextLong();
		System.out.println("Enter the Merchant's Password");
		String pass = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select m.product from Merchant m where m.phone=?1 and m.password=?2");
		query.setParameter(1, phn);
		query.setParameter(2, pass);
		List<Product> pro = query.getResultList();
		if(pro.isEmpty()) {
			System.err.println("Cannot fetch the data you want");
		}else {
			for(Product p:pro) {
				System.out.println(p);
			}
		}
	}
}
