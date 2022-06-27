package com.oneclick.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class ConfigMeta{
    public ArrayList<Resource> resources;
    public ArrayList<CalculationRule> calculationRules;
	public ArrayList<Resource> getResources() {
		return resources;
	}
	public void setResources(ArrayList<Resource> resources) {
		this.resources = resources;
	}
	public ArrayList<CalculationRule> getCalculationRules() {
		return calculationRules;
	}
	public void setCalculationRules(ArrayList<CalculationRule> calculationRules) {
		this.calculationRules = calculationRules;
	}
    
    
}