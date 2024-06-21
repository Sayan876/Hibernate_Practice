package SimpleFetch;
import com.manybi.*;
import javax.persistence.*;

public class FetchEager {
  public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	Merchant m = manager.find(Merchant.class, 1);
	System.out.println(m.getProduct());
}
}
