package com.oneclick.dto;

public class CalculateDTO {

	public String resource;
	public double quantity;
	public double CO2e;
	public double SO2e;
	
	
	
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
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	@Override
	public String toString() {
		return "CalculateDTO [resource=" + resource + ", quantity=" + quantity + ", CO2e=" + CO2e + ", SO2e=" + SO2e
				+ "]";
	}
	
	
	
	
}
