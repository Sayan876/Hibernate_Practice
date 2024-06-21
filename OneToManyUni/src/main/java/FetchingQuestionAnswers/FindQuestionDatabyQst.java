package FetchingQuestionAnswers;
import javax.persistence.*;
import java.util.*;
import com.manyuni.*;
public class FindQuestionDatabyQst {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the question to fetch the whole QuestionData");
	String qst = sc.nextLine();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select q from QuestionData q where q.question=?1");
	query.setParameter(1, qst);
	try {
		QuestionData qs = (QuestionData)query.getSingleResult();
		System.out.println(qs);
	}catch(NoResultException e) {
		System.err.println("No data");
	}
}
}
