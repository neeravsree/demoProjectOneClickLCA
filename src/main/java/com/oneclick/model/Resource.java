package com.oneclick.model;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class Resource {
	
    public String resourceId;
    public String name;
    public ArrayList<Impact> impacts;
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Impact> getImpacts() {
		return impacts;
	}
	public void setImpacts(ArrayList<Impact> impacts) {
		this.impacts = impacts;
	}
    
    

}
