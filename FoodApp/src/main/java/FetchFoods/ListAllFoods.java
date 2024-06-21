package FetchFoods;
import com.order.*;
import javax.persistence.*;
import java.util.*;
public class ListAllFoods {
  public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select f from FoodOrder f");
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
