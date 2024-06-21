package FetchingQuestionAnswers;
import javax.persistence.*;
import java.util.*;
import com.manyuni.*;
public class FindQuestionDataById {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Question id to fetch the Question data");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select q from QuestionData q where q.id=?1");
		query.setParameter(1, id);
		try {
			QuestionData qst = (QuestionData) query.getSingleResult();
			System.out.println(qst);
		}catch(NoResultException e) {
			System.err.println("No data");
		}
	}

}
