package Fetchingdata;
import org.linking.*;
import javax.persistence.*;
import java.util.*;
public class FindByPhone {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the phone number to fetch the details");
	int pphone = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createNamedQuery("findbyphone");
	query.setParameter(1, pphone);
	List<Person> per = query.getResultList();
	if(per.isEmpty()) {
		System.err.println("Couldn't find what you are looking for");
	}else {
		for(Person p:per) {
			System.out.println(p);
		}
	}
}
}
