package com.oneclick.model;

import org.springframework.stereotype.Component;


public class ResourceList {

	
	private Integer id;
	private String name;
	
	public ResourceList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResourceList(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
