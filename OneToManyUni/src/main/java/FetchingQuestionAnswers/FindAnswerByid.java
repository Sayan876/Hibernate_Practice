package FetchingQuestionAnswers;
import javax.persistence.*;
import java.util.*;
import com.manyuni.*;
public class FindAnswerByid {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Answer Id to fetch the whole Answer Id");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
		Query query = manager.createQuery("select a from AnswerData a where a.id=?1");
		query.setParameter(1, id);
		try {
			AnswerData ans = (AnswerData)query.getSingleResult();
			System.out.println(ans);
		}catch(NoResultException e) {
			System.err.println("Invalid id");
		}
	}

}
