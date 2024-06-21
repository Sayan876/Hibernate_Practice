package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*;
public class FindMerchantbyIdandPass {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Merchant id");
	int id = sc.nextInt();
	System.out.println("Enter the Password");
	String pass = sc.next();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select m from Merchant m where m.id=?1 and m.password=?2");
	query.setParameter(1, id);
	query.setParameter(2,pass);
	try {
		Merchant mer = (Merchant) query.getSingleResult();
		System.out.println(mer);
	}catch(NoResultException e) {
		System.err.println("Error 404");
	}
}
}
