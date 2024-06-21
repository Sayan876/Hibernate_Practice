package com.emd;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class User {
	@EmbeddedId
   private UserId userId;
	@Column(nullable = false)
   private String name;
	@Column(nullable = false)
   private String password;
	public UserId getUserId() {
		return userId;
	}
	public void setUserId(UserId userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
