package com.familytree.service;

import java.util.List;

public interface IFamilyTreeService {
	
	public String addFamily(String motherName, String childName, String gender);
	
	public void addFamily(String motherName, String male, String female, String gender);
		
	public List<String> findPaternalUncle(String name);
	
	public List<String> findMetarnalUncle(String name);
	
	public List<String> findParentalAunt(String name);
	
	public List<String> findMetarnalAunt(String name);
	
	public List<String> findBrotherInLaw(String name);
	
	public List<String> findSisterInLaw(String name);
	
	public List<String> findSon(String name);
	
	public List<String> findDaughter(String name);
	
	public List<String> findSiblings(String name);
	
	public void levelOrderTraversal();
}
