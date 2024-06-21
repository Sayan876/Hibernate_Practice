package com.Dao;

import javax.persistence.*;
import java.util.*;
import com.dto.*;

public class EmployeeDao {
	EntityManager manager = Persistence.createEntityManagerFactory("development").createEntityManager();

	public Employee saveEmployee(Employee emp, int dept_id) {
		Department dep = manager.find(Department.class, dept_id);
		if (dep != null) {
			EntityTransaction transaction = manager.getTransaction();
			dep.getEmployees().add(emp);
			emp.setEdept(dep);
			manager.persist(emp);
			transaction.begin();
			transaction.commit();
			return emp;
		} else {
			return null;
		}
	}

	public Employee updateEmployee(Employee emp) {
		EntityTransaction transaction = manager.getTransaction();
		Employee empl = manager.find(Employee.class, emp.getId());

		if (empl != null) {
			empl.setName(emp.getName());
			empl.setDesignation(emp.getDesignation());
			empl.setPassword(emp.getPassword());
			empl.setPhone(emp.getPhone());
			empl.setSalary(emp.getSalary());
			transaction.begin();
			transaction.commit();
			return emp;
		} else {
			return null;
		}

	}

	public Employee findbyId(int id) {
		Query query = manager.createQuery("select e from Employee e where e.id=?1");
		query.setParameter(1, id);
		try {
			return (Employee) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Employee> findbydeptname(String dname) {
		Query query = manager.createQuery("select d.employees from Department d where d.name=?1");
		query.setParameter(1, dname);

		return query.getResultList();
	}

	public List<Employee> findbyDesg(String desgn) {
		Query query = manager.createQuery("select e from Employee e where e.designation=?1");
		query.setParameter(1, desgn);
		return query.getResultList();
	}

	public List<Employee> findbySal(double sal) {
		Query query = manager.createQuery("select e from Employee e where e.salary=?1");
		query.setParameter(1, sal);
		return query.getResultList();
	}

	public List<Employee> findByName(String ename) {
		Query query = manager.createQuery("select e from Employee e where e.name=?1");
		query.setParameter(1, ename);
		return query.getResultList();
	}

	public List<Employee> salRange(Double esal) {
		Query query = manager.createQuery("select e from Employee e where e.salary<=?1");
		query.setParameter(1, esal);
		return query.getResultList();
	}

}
