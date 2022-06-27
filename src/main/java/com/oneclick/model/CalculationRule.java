package com.oneclick.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class CalculationRule {

	public String calculationRuleId;
    public String name;
    public ArrayList<String> multiplyFormula;
	public String getCalculationRuleId() {
		return calculationRuleId;
	}
	public void setCalculationRuleId(String calculationRuleId) {
		this.calculationRuleId = calculationRuleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getMultiplyFormula() {
		return multiplyFormula;
	}
	public void setMultiplyFormula(ArrayList<String> multiplyFormula) {
		this.multiplyFormula = multiplyFormula;
	}
    
    
}
