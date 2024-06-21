package FetchingQuestionAnswers;
import com.manyuni.*;
import javax.persistence.*;
import java.util.*;
public class FetchAnswerByQstId {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Question id to get the ahold of the answer");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select q.answers from QuestionData q where q.id=?1");
		query.setParameter(1, id);
		
		List<AnswerData> answers = query.getResultList();
		if(answers.isEmpty()) {
			System.err.println("No answers found");
		}else {
			for(AnswerData a:answers) {
				System.out.println(a);
			}
		}
		
		
	}

}
