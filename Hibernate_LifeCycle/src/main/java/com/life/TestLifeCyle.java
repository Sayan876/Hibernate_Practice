package com.life;
import javax.persistence.*;
public class TestLifeCyle {
  public static void main(String[] args) {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	Person p = new Person();//Transient State
	
	p.setName("Sayan");
	p.setPassword("Sayan20");
	p.setPhone(12342345238L);
	transaction.begin();
	manager.persist(p);
	transaction.commit();
	
	p.setName("Rayan");
	p.setPhone(76543218901L);
	
	transaction.begin();
	transaction.commit();
	
	manager.detach(p);//detached State
	p.setName("Raynolds");
	p.setPhone(77778889);
	
	transaction.begin();
	transaction.commit();
}
}
