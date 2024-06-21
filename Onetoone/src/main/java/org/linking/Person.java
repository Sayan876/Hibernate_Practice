package org.linking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Person")
@NamedQueries(value= {@NamedQuery(name="findbyphone", query="select p from Person p where p.phone=?1") })
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false,unique=true)
	private int phone;
	@OneToOne
	
	private AadharCard adharid;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public AadharCard getAdharid() {
		return adharid;
	}
	public void setAdharid(AadharCard adharid) {
		this.adharid = adharid;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", adharid=" + adharid + "]";
	}
	

}
