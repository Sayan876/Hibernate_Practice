package Fetchingdata;
import org.linking.*;
import javax.persistence.*;
import java.util.*;
public class FindAadharbyId {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select a from AadharCard a where a.id=?1 ");
		query.setParameter(1, id);
     	try {
     		AadharCard card = (AadharCard)query.getSingleResult();
     		System.out.println(card);
     	}catch(NoResultException e) {
     		System.err.println("Sorry dude!");
     	}
	}

}
