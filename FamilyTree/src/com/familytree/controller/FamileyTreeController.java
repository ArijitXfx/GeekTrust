package com.familytree.controller;

import java.util.List;

import com.familytree.service.FamilyTreeServiceImpl;
import com.familytree.service.IFamilyTreeService;

public class FamileyTreeController {
	
	private IFamilyTreeService familyTreeService;
	
	public FamileyTreeController() {
		familyTreeService = new FamilyTreeServiceImpl();
	}
	
	public String addFamily(String motherName, String childName, String gender) {
		return familyTreeService.addFamily(motherName, childName, gender);
	}
	
	public void addFamily(String motherName, String male, String female, String gender) {
		familyTreeService.addFamily(motherName, male, female, gender);
	}
	
	public List<String> findPaternalUncle(String name){
		return familyTreeService.findPaternalUncle(name);
	}
	
	public List<String> findMetarnalUncle(String name){
		return familyTreeService.findMetarnalUncle(name);
	}
	
	public List<String> findParentalAunt(String name){
		return familyTreeService.findParentalAunt(name);
	}
	
	public List<String> findMetarnalAunt(String name){
		return familyTreeService.findMetarnalAunt(name);
	}
	
	public List<String> findBrotherInLaw(String name){
		return familyTreeService.findBrotherInLaw(name);
	}
	
	public List<String> findSisterInLaw(String name){
		return familyTreeService.findSisterInLaw(name);
	}
	
	public List<String> findSon(String name){
		return familyTreeService.findSon(name);
	}
	
	public List<String> findDaughter(String name){
		return familyTreeService.findDaughter(name);
	}
	
	public List<String> findSiblings(String name) {
		return familyTreeService.findSiblings(name);
	}
	
	public void levelOrderTraversal() {
		familyTreeService.levelOrderTraversal();
	}
}
