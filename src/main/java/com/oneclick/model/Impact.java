package com.oneclick.model;

import org.springframework.stereotype.Component;

@Component
public class Impact {

	public String impactGWP100_kgCO2e;
    public String impactAP_kgSO2e;
	public String getImpactGWP100_kgCO2e() {
		return impactGWP100_kgCO2e;
	}
	public void setImpactGWP100_kgCO2e(String impactGWP100_kgCO2e) {
		this.impactGWP100_kgCO2e = impactGWP100_kgCO2e;
	}
	public String getImpactAP_kgSO2e() {
		return impactAP_kgSO2e;
	}
	public void setImpactAP_kgSO2e(String impactAP_kgSO2e) {
		this.impactAP_kgSO2e = impactAP_kgSO2e;
	}
	
	
    
    
}
