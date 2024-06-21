package Fetchingdata;
import com.entitys.*;
import javax.persistence.*;
import java.util.*;
public class FetchPanCardbyId {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the pan id");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select p from PanCard p where p.id=?1");
	query.setParameter(1, id);
	try {
		PanCard p =(PanCard) query.getSingleResult();
		System.out.println(p);
	}catch(NoResultException e) {
		System.err.println("Invalid");
	}
}
}
