package FetchFoods;
import javax.persistence.*;
import java.util.*;
import com.order.*;
public class FoodFilter {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the maximum range");
	double ran = sc.nextDouble();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select f from FoodOrder f where f.cost<=?1");
	query.setParameter(1, ran);
	
	List<FoodOrder> ord = query.getResultList();
	if(ord.isEmpty()) {
		System.out.println("Sorry you are broke");
	}else {
		for(FoodOrder o:ord) {
			System.out.println(o);
		}
	}
}
}
