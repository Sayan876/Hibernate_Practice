package Fetchingdata;
import javax.persistence.*;
import java.util.*;
import com.entitys.*;
public class FetchPanCardbyNumber {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Pan Number");
	String pnum = sc.next();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select p from PanCard p where p.number=?1");
	query.setParameter(1, pnum);
	try {
		PanCard p =(PanCard) query.getSingleResult();
		System.out.println(p);
	}catch(NoResultException e) {
		System.err.println("No data");
	}
			
}
}
