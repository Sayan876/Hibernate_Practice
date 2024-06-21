package Fetchingdata;
import org.linking.*;
import javax.persistence.*;
import java.util.*;
public class FetchByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the email id");
		String pname = sc.nextLine();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		String jpql = "select p from Person p where p.name=?1";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, pname);
		List<Person> per = query.getResultList();
		if(per.isEmpty()) {
			System.err.println("Sorry pal but you are running out of ideas");
		}else {
			for(Person p:per) {
				System.out.println(p);
			}
		}
	}

}
