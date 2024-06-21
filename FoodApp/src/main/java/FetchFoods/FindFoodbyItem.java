package FetchFoods;
import javax.persistence.*;
import java.util.*;
import com.order.*;
public class FindFoodbyItem {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the food name");
	String item = sc.nextLine();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select f from FoodOrder f where f.food_item=?1");
	query.setParameter(1, item);
	
	List<FoodOrder> ft = query.getResultList();
	if(ft.isEmpty()) {
		System.out.println("no records found");
	}else {
		for(FoodOrder f:ft) {
			System.out.println(f);
		}
	}
}
}
