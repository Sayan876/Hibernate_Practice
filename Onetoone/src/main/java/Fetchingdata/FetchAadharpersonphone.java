package Fetchingdata;
import org.linking.*;
import javax.persistence.*;
import java.util.*;
public class FetchAadharpersonphone {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the id number");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createNativeQuery("select * from AadharCard where id = (select id from Person where phone =?1)",AadharCard.class);
	query.setParameter(1, id);
	try {
		AadharCard card = (AadharCard) query.getSingleResult();
		System.out.println(card);
	}catch(NoResultException e) {
		System.err.println("Sorry");
	}
}
}
