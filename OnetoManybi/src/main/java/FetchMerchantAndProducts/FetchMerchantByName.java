package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*;
public class FetchMerchantByName {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Merchant name");
	String mname = sc.nextLine();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select m from Merchant m where m.name=?1");
	query.setParameter(1, mname);
	List<Merchant> mr = query.getResultList();
	if(mr.isEmpty()) {
		System.err.println("this is an Empty shell");
	}else {
		for(Merchant m:mr) {
			System.out.println(m);
		}
	}
}
}
