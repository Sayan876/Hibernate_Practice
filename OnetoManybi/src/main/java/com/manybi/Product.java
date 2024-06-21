package com.manybi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String brand, catagory, description,name;
	@Column(nullable = false)
	private int cost;
	@ManyToOne
	@JoinColumn(name = "merchant_id")
	private Merchant m;

	public int getId() {
		return id;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Merchant getM() {
		return m;
	}

	public void setM(Merchant m) {
		this.m = m;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", catagory=" + catagory + ", description=" + description
				+ ", name=" + name + ", cost=" + cost + ", m=" + m + "]";
	}
	

}
