package com.dto;

import javax.persistence.*;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name, designation, password;
	@Column(nullable = false, unique = true)
	private long phone;
	@Column(nullable = false)
	private double salary;
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department edept;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getEdept() {
		return edept;
	}
	public void setEdept(Department edept) {
		this.edept = edept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", password=" + password
				+ ", phone=" + phone + ", salary=" + salary + ", edept=" + edept + "]";
	}
	

}
