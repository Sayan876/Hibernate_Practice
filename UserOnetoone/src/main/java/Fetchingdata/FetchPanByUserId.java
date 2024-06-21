package Fetchingdata;
import java.util.*;
import javax.persistence.*;
import com.entitys.*;
public class FetchPanByUserId {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the User id");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select p from PanCard p where p.id=(select u.id from User u where u.id=?1)");
	query.setParameter(1, id);
	try {
		PanCard car = (PanCard)query.getSingleResult();
		System.out.println(car);
	}catch(NoResultException e) {
		System.err.println("No data");
	}
}
}
