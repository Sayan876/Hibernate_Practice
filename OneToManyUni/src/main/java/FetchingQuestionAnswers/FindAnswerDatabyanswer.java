package FetchingQuestionAnswers;
import javax.persistence.*;
import java.util.*;
import com.manyuni.*;

public class FindAnswerDatabyanswer {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the answer to fetch the Asnwer database");
	String ans = sc.nextLine();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select a from AnswerData a where a.answer=?1");
	query.setParameter(1, ans);
	try {
		AnswerData an = (AnswerData)query.getSingleResult();
		System.out.println(an);
	}catch(NoResultException e) {
		System.err.println("No data found");
	}
}
}
