package FetchMerchantAndProducts;
import javax.persistence.*;
import com.manybi.*;
import java.util.*;
public class FetchMerchantById {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the id");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select m from Merchant m where m.id=?1");
	query.setParameter(1, id);
	try {
		Merchant mr =(Merchant) query.getSingleResult();
		System.out.println(mr);
	}catch(NoResultException e) {
		System.err.println("Error 404");
	}
}
}
