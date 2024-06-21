package FetchMerchantAndProducts;
import javax.persistence.*;
import java.util.*;
import com.manybi.*;
public class FindMerchantbyPhoneAndPassword {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the phone");
	long ph = sc.nextLong();
	System.out.println("Enter the Password");
	String pass = sc.next();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
	query.setParameter(1, ph);
	query.setParameter(2, pass);
	try {
		Merchant mr = (Merchant) query.getSingleResult();
		System.out.println(mr);
	}catch(NoResultException e) {
		System.err.println("Cannot fetch the data you want");
	}
}
}
