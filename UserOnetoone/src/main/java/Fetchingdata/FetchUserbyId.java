package Fetchingdata;
import com.entitys.*;
import javax.persistence.*;
import java.util.*;
public class FetchUserbyId {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the id");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select u from User u where u.id=?1");
	query.setParameter(1, id);
	try {
		User user = (User)query.getSingleResult();
		System.out.println(user);
	}catch(NoResultException e) {
		System.err.println("Sorry Dude!");
	}
}
}
