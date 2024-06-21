package Fetchingdata;
import java.util.*;
import javax.persistence.*;
import com.entitys.*;
public class FetchUserByPancardId {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the PanCard id");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select p.user from PanCard p where p.id=?1");
	query.setParameter(1, id);
	try {
		User user = (User)query.getSingleResult();
		System.out.println(user);
	}catch(NoResultException e) {
		System.err.println("No results");
	}
}
}
