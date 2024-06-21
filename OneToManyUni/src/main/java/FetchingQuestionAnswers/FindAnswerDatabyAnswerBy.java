package FetchingQuestionAnswers;
import javax.persistence.*;
import java.util.*;
import com.manyuni.*;
public class FindAnswerDatabyAnswerBy {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name who throw the answer");
		String ansrr = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select a from AnswerData a where a.answeredBy=?1");
		query.setParameter(1, ansrr);
		try {
			AnswerData ans = (AnswerData)query.getSingleResult();
			System.out.println(ans);
		}catch(NoResultException e) {
			System.err.println("No data found");
		}
	}
}
