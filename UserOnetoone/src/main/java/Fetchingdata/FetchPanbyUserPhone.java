package Fetchingdata;
import java.util.*;
import javax.persistence.*;
import com.entitys.*;
public class FetchPanbyUserPhone {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the User's phone");
	long uphone = sc.nextLong();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select p from PanCard p where p.id=(select u.id from User u where u.phone=?1)");
	query.setParameter(1, uphone);
	try {
		PanCard car = (PanCard)query.getSingleResult();
		System.out.println(car);
	}catch(NoResultException e) {
		System.err.println("No Data");
	}
}
}
