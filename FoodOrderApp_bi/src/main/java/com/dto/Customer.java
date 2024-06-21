package com.dto;

import javax.persistence.*;
import java.util.*;

@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private long phone;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String password,name;
	@OneToMany(mappedBy = "cst")
	private List<FoodOrder> orders;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getPhone() {
		return phone;
	}


	public void setPhone(long phone) {
		this.phone = phone;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<FoodOrder> getOrders() {
		return orders;
	}


	public void setOrders(List<FoodOrder> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", phone=" + phone + ", age=" + age + ", email=" + email + ", gender=" + gender
				+ ", password=" + password + ", name=" + name + ", orders=" + orders + "]";
	}


	
	
}
