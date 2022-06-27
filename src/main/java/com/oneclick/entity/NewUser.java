package com.oneclick.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NewUser {

	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	@Id
	@Column(name="email")
	private String email;
	
	
	
	public NewUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NewUser(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		//this.totalimpact = totalimpact;
	}

	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*
	 * public Double getTotalimpact() { return totalimpact; } public void
	 * setTotalimpact(Double totalimpact) { this.totalimpact = totalimpact; }
	 */
	
	
}
