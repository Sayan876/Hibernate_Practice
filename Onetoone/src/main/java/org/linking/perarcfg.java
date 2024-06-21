package org.linking;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class perarcfg {
  public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	System.out.println(manager);
}
}
