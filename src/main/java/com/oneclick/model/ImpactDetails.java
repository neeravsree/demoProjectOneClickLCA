package com.oneclick.model;

public class ImpactDetails {
private String resName;
private double So2e;
private double co2e;


public ImpactDetails(String resName, double so2e, double co2e) {
	super();
	this.resName = resName;
	So2e = so2e;
	this.co2e = co2e;
}


public String getResName() {
	return resName;
}


public void setResName(String resName) {
	this.resName = resName;
}


public double getSo2e() {
	return So2e;
}


public void setSo2e(double so2e) {
	So2e = so2e;
}


public double getCo2e() {
	return co2e;
}


public void setCo2e(double co2e) {
	this.co2e = co2e;
}


@Override
public String toString() {
	return "ImpactDetails [resName=" + resName + ", So2e=" + So2e + ", co2e=" + co2e + "]";
}


}
