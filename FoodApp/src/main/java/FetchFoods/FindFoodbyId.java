package FetchFoods;
import javax.persistence.*;
import java.util.*;
import com.order.*;
public class FindFoodbyId {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Order Id to fetch data");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select f from FoodOrder f where f.id=?1");
	query.setParameter(1, id);
	try {
		FoodOrder order = (FoodOrder) query.getSingleResult();
		System.out.println(order);
	}catch(NoResultException e) {
		System.err.println("Double check the id");
	}
}
}
