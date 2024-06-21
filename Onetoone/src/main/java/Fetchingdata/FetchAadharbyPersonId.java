package Fetchingdata;
import org.linking.*;
import javax.persistence.*;
import java.util.*; 
public class FetchAadharbyPersonId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the person's id");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
//		Query query = manager.createNativeQuery("select * from AadharCard where id = (select id from Person where id=?1)",AadharCard.class);
		Query query = manager.createQuery("select p.adharid from Person p where p.id=?1");
		query.setParameter(1, id);
		try {
			AadharCard card = (AadharCard) query.getSingleResult();
			System.out.println(card);
		}catch(NoResultException e) {
			System.err.println("Sorry dude");
		}
	}

}
