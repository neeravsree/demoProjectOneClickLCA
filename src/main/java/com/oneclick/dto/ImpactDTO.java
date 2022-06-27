package com.oneclick.dto;

import java.util.List;

public class ImpactDTO {

	private Double impact;
	
	private String email;
	
	private List<CalculateDTO> calculateDto;
	 
	public ImpactDTO(Double impact, String email) {
		super();
		this.impact = impact;
		this.email = email;
	}

	public Double getImpact() {
		return impact;
	}

	public void setImpact(Double impact) {
		this.impact = impact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	

	public List<CalculateDTO> getCalculateDto() { return calculateDto; }
	  
	  public void setCalculateDto(List<CalculateDTO> calculateDto) {
	  this.calculateDto = calculateDto; }
	 
	  @Override
		public String toString() {
			return "ImpactDTO [impact=" + impact + ", email=" + email + ", calculateDto=" + calculateDto + "]";
		}
}
