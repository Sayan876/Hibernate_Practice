package Fetchingdata;
import com.entitys.*;
import javax.persistence.*;
import java.util.*;
public class FetchUserByName {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the username");
		String name = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select u from User u where u.name=?1");
		query.setParameter(1, name);
		try {
			User user = (User)query.getSingleResult(); 
			System.out.println(user);
		}catch(NoResultException e) {
			System.err.println("Invalid");
		}
	}

}
