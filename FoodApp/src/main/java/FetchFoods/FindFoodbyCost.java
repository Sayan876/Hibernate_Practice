package FetchFoods;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.order.FoodOrder;

public class FindFoodbyCost {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the cost");
		double cost = sc.nextDouble();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select f from FoodOrder f where f.cost=?1");
		query.setParameter(1, cost);
		
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
