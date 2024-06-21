package Fetchingdata;
import java.util.*;
import javax.persistence.*;
import com.entitys.*;
public class FetcHPanUserIdAndName {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user id");
		int id = sc.nextInt();
		System.out.println("Enter the Username");
		String uname = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select p from PanCard p where p.id=(select u.id from User u where u.id=?1 and u.name=?2)");
		query.setParameter(1, id);
		query.setParameter(2, uname);
		try {
			PanCard car = (PanCard)query.getSingleResult();
			System.out.println(car);
		}catch(NoResultException e) {
			System.err.println("No Data");
		}
	}
}
