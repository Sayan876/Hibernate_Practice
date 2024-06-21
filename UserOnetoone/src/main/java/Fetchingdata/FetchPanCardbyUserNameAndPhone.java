package Fetchingdata;
import java.util.*;
import javax.persistence.*;
import com.entitys.*;
public class FetchPanCardbyUserNameAndPhone {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Username");
	String uname = sc.next();
	System.out.println("Enter the phone number");
	long unum = sc.nextLong();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select p from PanCard p where p.id=(select u.id from User u where u.name=?1 and u.phone=?2)");
	query.setParameter(1, uname);
	query.setParameter(2, unum);
	try {
		PanCard car = (PanCard)query.getSingleResult();
		System.out.println(car);
	}catch(NoResultException e) {
		System.err.println("No data");
	}
}
}
