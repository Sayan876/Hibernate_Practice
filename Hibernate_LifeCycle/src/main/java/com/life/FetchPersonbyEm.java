package com.life;
import javax.persistence.*;

public class FetchPersonbyEm {
   public static void main(String[] args) {
   EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
   EntityManager manager1 = factory.createEntityManager();
   EntityManager manager2 = factory.createEntityManager();
   System.out.println(manager1.find(Person.class, 1));
   System.out.println(manager1.find(Person.class, 1));
   System.out.println(manager2.find(Person.class, 1));
   System.out.println(manager2.find(Person.class, 1));
}
}
