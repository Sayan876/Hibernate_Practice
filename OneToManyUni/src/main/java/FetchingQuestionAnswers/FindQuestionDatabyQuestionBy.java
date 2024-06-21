package FetchingQuestionAnswers;
import javax.persistence.*;
import java.util.*;
import com.manyuni.*;
public class FindQuestionDatabyQuestionBy {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name who asked the Question");
		String tc = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select q from QuestionData q where q.questionBy=?1");
		query.setParameter(1, tc);
		List<QuestionData> qs = query.getResultList();
		if(qs.isEmpty()) {
			System.err.println("Person not found");
		}else {
			for(QuestionData q:qs) {
				System.out.println(q);
			}
		}
	}
}
