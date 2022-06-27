package com.oneclick.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImpactEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rowIdentifier;
    private Double totalUserimpact;
	
	private String email;
	
	private String resource;
	private double quantity;
	private double CO2e;
	private double SO2e;
	
	
	
	public int getRowIdentifier() {
		return rowIdentifier;
	}



	public void setRowIdentifier(int rowIdentifier) {
		this.rowIdentifier = rowIdentifier;
	}



	public Double getTotalUserimpact() {
		return totalUserimpact;
	}



	public void setTotalUserimpact(Double totalUserimpact) {
		this.totalUserimpact = totalUserimpact;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getResource() {
		return resource;
	}



	public void setResource(String resource) {
		this.resource = resource;
	}



	public double getQuantity() {
		return quantity;
	}



	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}



	public double getCO2e() {
		return CO2e;
	}



	public void setCO2e(double cO2e) {
		CO2e = cO2e;
	}



	public double getSO2e() {
		return SO2e;
	}



	public void setSO2e(double sO2e) {
		SO2e = sO2e;
	}



	public ImpactEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ImpactEntity(Double totalUserimpact, String email) {
		super();
		this.totalUserimpact = totalUserimpact;
		this.email = email;
		
	}






	
}
