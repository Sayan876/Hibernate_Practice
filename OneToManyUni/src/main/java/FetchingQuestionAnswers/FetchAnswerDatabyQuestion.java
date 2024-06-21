package FetchingQuestionAnswers;
import javax.persistence.*;
import java.util.*;
import com.manyuni.*;
public class FetchAnswerDatabyQuestion {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the question to fetch the whole Answer database");
	String qns = sc.nextLine();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select q.answers from QuestionData q where q.question=?1");
	query.setParameter(1, qns);
	List<AnswerData> and = query.getResultList();
	if(and.isEmpty()) {
		System.err.println("No data found");
	}else {
		for(AnswerData a:and) {
			System.out.println(a);
		}
	}
}
}
