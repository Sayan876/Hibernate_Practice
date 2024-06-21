package com.Dao;
import javax.persistence.*;
import java.util.*;
import com.dto.*;
public class DepartmentDao {
  EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();
  public Department saveDept(Department dment) {
	  EntityTransaction transaction = manager.getTransaction();
	  transaction.begin();
	  manager.persist(dment);
	  transaction.commit();
	  return dment;
  }
  
  public Department updateDept(Department dment) {
	  EntityTransaction transaction = manager.getTransaction();
	  Department dbdepartment = manager.find(Department.class, dment.getId());
	  
	  if(dbdepartment!=null) {
		  dbdepartment.setName(dment.getName());
		  dbdepartment.setLocation(dment.getLocation());
		  transaction.begin();
		  transaction.commit();
		  return dment;
		  
	  }else {
		  return null;
	  }
  }
}
