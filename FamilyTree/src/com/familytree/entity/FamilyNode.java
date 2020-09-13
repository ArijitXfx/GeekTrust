package com.familytree.entity;

import java.util.List;

public class FamilyNode {
	
	private FamilyNode parent;
	private String male;
	private String female;
	private String gender;
	private List<FamilyNode> childreen;
	
	public FamilyNode(FamilyNode parent, String male, String female, String gender) {
		super();
		this.parent = parent;
		this.male = male;
		this.female = female;
		this.gender = gender;
	}

	public FamilyNode getParent() {
		return parent;
	}
	
	public void setParent(FamilyNode parent) {
		this.parent = parent;
	}
	
	public String getMale() {
		return male;
	}
	
	public void setMale(String male) {
		this.male = male;
	}
	
	public String getFemale() {
		return female;
	}
	
	public void setFemale(String female) {
		this.female = female;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<FamilyNode> getChildreen() {
		return childreen;
	}
	
	public void setChildreen(List<FamilyNode> childreen) {
		this.childreen = childreen;
	}
	
}
