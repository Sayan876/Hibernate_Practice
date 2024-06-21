package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*;
public class FetchMerchantByGst_number {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the gst number");
	String gst = sc.next();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select m from Merchant m where m.gst_number=?1");
	query.setParameter(1, gst);
	try {
		Merchant mer = (Merchant) query.getSingleResult();
		System.out.println(mer);
	}catch(NoResultException e) {
		System.err.println("Error 404");
	}
}
}
