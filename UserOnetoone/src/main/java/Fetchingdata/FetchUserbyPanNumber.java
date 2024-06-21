package Fetchingdata;
import com.entitys.*;
import javax.persistence.*;
import java.util.*;
public class FetchUserbyPanNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Pan Card Number");
		String pnum = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select p.user from PanCard p where p.number=?1");
		query.setParameter(1, pnum);
		try {
			User user = (User)query.getSingleResult();
			System.err.println(user);
		}catch(NoResultException e) {
			System.err.println("No data");
		}
	}

}
