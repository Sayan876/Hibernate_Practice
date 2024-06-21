package Fetchingdata;
import org.linking.*;
import javax.persistence.*;
import java.util.*;
public class FetchbyId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		String jpql = "select p from Person p where p.id=?1";
		Query query = manager.createQuery(jpql);
		query.setParameter(1, id);
		List<Person> per = query.getResultList();
		if(per.isEmpty()) {
			System.err.println("Can't find what you are looking for");
		}else {
			for(Person p:per) {
				System.out.println(p);
			}
		}
	}

}
