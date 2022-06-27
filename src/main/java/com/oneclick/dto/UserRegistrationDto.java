package com.oneclick.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserRegistrationDto {


	private String username;
	
	private String password;
	
	private String email;
	
	//private Double impact;
	
	

	/*
	 * public Double getImpact() { return impact; }
	 * 
	 * public void setImpact(Double impact) { this.impact = impact; }
	 */

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
	
	
	
}
