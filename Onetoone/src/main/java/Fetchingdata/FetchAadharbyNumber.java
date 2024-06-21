package Fetchingdata;
import java.util.*;
import javax.persistence.*;
import org.linking.*; 
public class FetchAadharbyNumber {
     public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Aadhar number to fetch");
		int num = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select a from AadharCard a where a.number=?1");
		query.setParameter(1, num);
		try {
			AadharCard card =(AadharCard) query.getSingleResult();
			System.out.println(card);
		}catch(NoResultException e) {
			System.err.println("Sorry");
		}
	}
}
