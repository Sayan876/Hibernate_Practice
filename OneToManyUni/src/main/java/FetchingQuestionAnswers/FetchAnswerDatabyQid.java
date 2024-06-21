package FetchingQuestionAnswers;
import javax.persistence.*;
import java.util.*;
import com.manyuni.*;
public class FetchAnswerDatabyQid {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Question id to find the answers");
	int id = sc.nextInt();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select q.answers from QuestionData q where q.id=?1");
	query.setParameter(1, id);
	List<AnswerData> anser = query.getResultList();
	if(anser.isEmpty()) {
		System.err.println("This is an Empty Shell");
	}else {
		for(AnswerData a:anser) 
		{
			System.out.println(a);
		}
	}
}
}
