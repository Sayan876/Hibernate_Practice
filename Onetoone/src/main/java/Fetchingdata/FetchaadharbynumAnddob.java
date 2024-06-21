package Fetchingdata;
import org.linking.*;
import javax.persistence.*;

import java.time.LocalDate;
import java.util.*;

public class FetchaadharbynumAnddob {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number");
	int num = sc.nextInt();
	System.out.println("Enter the dob");
	LocalDate dob = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select a from AadharCard a where a.number=?1 and a.dob=?2");
	query.setParameter(1, num);
	query.setParameter(2, dob);
	try {
		AadharCard card =(AadharCard) query.getSingleResult();
		System.out.println(card);
	}catch(NoResultException e) {
		System.err.println("Sorry buddy");
	}
}
}
