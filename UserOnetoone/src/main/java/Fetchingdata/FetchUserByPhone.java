package Fetchingdata;
import com.entitys.*;
import javax.persistence.*;
import java.util.*;
public class FetchUserByPhone {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the phone number");
		long phone = sc.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select u from User u where u.phone=?1");
		query.setParameter(1, phone);
		try {
			User user =(User) query.getSingleResult();
			System.out.println(user);
		}catch(NoResultException e) {
			System.err.println("Go back");
		}
	}

}
