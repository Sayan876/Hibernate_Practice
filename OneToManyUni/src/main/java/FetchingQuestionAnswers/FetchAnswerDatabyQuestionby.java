package FetchingQuestionAnswers;
import javax.persistence.*;
import java.util.*;
import com.manyuni.*;
public class FetchAnswerDatabyQuestionby {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the person's name who throw the Question");
	String per = sc.next();
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Query query = manager.createQuery("select q.answers from QuestionData q where q.questionBy=?1");
	query.setParameter(1, per);
	List<AnswerData> ansd = query.getResultList();
	if(ansd.isEmpty()) {
		System.err.println("Don't know who the fuck is this");
	}else {
		for(AnswerData a:ansd) {
			System.out.println(a);
		}
	}
}
}
