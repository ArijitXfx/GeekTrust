package com.familytree.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.familytree.entity.FamilyNode;

public class FamilyTreeServiceImpl implements IFamilyTreeService{
	private FamilyNode root;

	public FamilyTreeServiceImpl() {
		root = new FamilyNode(null,"King Shan","Queen Anga","Male");
	}

	public FamilyNode findFamilyNode(String motherName) {
		if(motherName==null) 
			return null;
		
		Queue<FamilyNode> queue = new LinkedList<FamilyNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			FamilyNode family = queue.poll();

			if(motherName.equalsIgnoreCase(family.getFemale()) || motherName.equalsIgnoreCase(family.getMale()))
				return family;

			if(family.getChildreen()!=null) {
				for(FamilyNode child:family.getChildreen()) {
					if(child!=null) {
						queue.add(child);
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public String addFamily(String motherName, String childName, String gender) {
		FamilyNode familyNode = findFamilyNode(motherName);
		if(familyNode==null)
			return "PERSON_NOT_FOUND";
		if(motherName.equals(familyNode.getMale()))
			return "CHILD_ADDITION_FAILED";
		
		if(familyNode.getChildreen()==null) {
			familyNode.setChildreen(new LinkedList<FamilyNode>());
		}
		
		if(gender.equalsIgnoreCase("male"))
			familyNode.getChildreen().add(new FamilyNode(familyNode, childName, null, gender));
		else
			familyNode.getChildreen().add(new FamilyNode(familyNode, null, childName, gender));
		return "CHILD_ADDITION_SUCCEEDED";
	}
	
	@Override
	public void addFamily(String motherName, String male, String female, String gender) {
		FamilyNode familyNode = findFamilyNode(motherName);
		if(familyNode.getChildreen()==null) {
			familyNode.setChildreen(new LinkedList<FamilyNode>());
		}
		familyNode.getChildreen().add(new FamilyNode(familyNode, male, female, gender));
	}
	
	public List<String> findUncleOrAunt(String name, String parentGender, String uncleOrAunt){
		FamilyNode familyNode = findFamilyNode(name).getParent();
		if(familyNode==null)
			return null;
		FamilyNode grandFamilyNode = familyNode.getParent();
		List<String> result = new LinkedList<String>();
		
		if(grandFamilyNode==null || !familyNode.getGender().equalsIgnoreCase(parentGender)) {
			return result;
		}
		
		if(grandFamilyNode.getChildreen()!=null) {
			for(FamilyNode child:grandFamilyNode.getChildreen()) {
				if(child!=null) {
					if(uncleOrAunt.equalsIgnoreCase("Male")) {
						if(child.getMale()!=null && !child.getMale().equals(familyNode.getMale()) && !child.getMale().equalsIgnoreCase(familyNode.getMale()) && uncleOrAunt.equalsIgnoreCase(child.getGender())) {
							result.add(child.getMale());
						}
					}else {
						if(child.getFemale()!=null && !child.getFemale().equals(familyNode.getMale()) && !child.getFemale().equalsIgnoreCase(familyNode.getFemale()) && uncleOrAunt.equalsIgnoreCase(child.getGender())) {
							result.add(child.getFemale());
						}
					}
				}
			}
		}
		
		return result;
	}
	
	public List<String> findInLaw(String name, String gender){
		FamilyNode familyNode = findFamilyNode(name);
		if(familyNode==null)
			return null;
		List<String> result = new LinkedList<String>();
		if(!gender.equalsIgnoreCase(familyNode.getGender())) {
			if(gender.equals("Male")) {
				result.addAll(findSon(familyNode.getParent().getFemale()));
			}else {
				result.addAll(findDaughter(familyNode.getParent().getFemale()));
			}
		}else if(familyNode.getParent().getChildreen()!=null) {
			for(FamilyNode child:familyNode.getParent().getChildreen()) {
				if(child!=null && !gender.equalsIgnoreCase(child.getGender()) && !name.equals(child.getMale()) && !name.equals(child.getFemale())) {
					if(gender.equalsIgnoreCase("Male")) {
						if(child.getMale()!=null) {
							result.add(child.getMale());
						}
					}else {
						if(child.getFemale()!=null) {
							result.add(child.getFemale());
						}
					}
				}
			}
		}
		return result;
	}
	
	public List<String> findChild(String name, String gender){
		FamilyNode familyNode = findFamilyNode(name);
		if(familyNode==null) return null;
		List<String> result = new LinkedList<String>();
		if(familyNode.getChildreen()!=null) {
			for(FamilyNode child:familyNode.getChildreen()) {
				if(child.getGender().equalsIgnoreCase(gender)) {
					result.add(gender.equalsIgnoreCase("Male")?child.getMale():child.getFemale());
				}
			}
		}
		return result;
	}
	
	@Override
	public List<String> findPaternalUncle(String name){
		return findUncleOrAunt(name, "Male", "Male");
	}
	
	@Override
	public List<String> findMetarnalUncle(String name){
		return findUncleOrAunt(name, "Female", "Male");
	}
	
	@Override
	public List<String> findParentalAunt(String name){
		return findUncleOrAunt(name, "Male", "Female");
				
	}
	
	@Override
	public List<String> findMetarnalAunt(String name){
		return findUncleOrAunt(name, "Female", "Female");
	}
	
	@Override
	public List<String> findBrotherInLaw(String name){
		return findInLaw(name, "Male");
	}
	
	@Override
	public List<String> findSisterInLaw(String name){
		return findInLaw(name, "Female");
	}
	
	@Override
	public List<String> findSon(String name){
		return findChild(name, "Male");
	}
	
	@Override
	public List<String> findDaughter(String name){
		return findChild(name, "Female");
	}
	
	@Override
	public List<String> findSiblings(String name){
		FamilyNode familyNode = findFamilyNode(name).getParent();
		if(familyNode==null)
			return null;
		List<String> result = new LinkedList<String>();
		if(familyNode.getChildreen()!=null) {
			for(FamilyNode child:familyNode.getChildreen()) {
				if(child!=null) {
					if(!name.equals(child.getMale()) && !name.equals(child.getFemale())) {
						if(child.getGender().equalsIgnoreCase("Male"))
							result.add(child.getMale());
						else
							result.add(child.getFemale());
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public void levelOrderTraversal() {
		Queue<FamilyNode> q = new LinkedList<FamilyNode>();
		q.add(root);
		q.add(null);
		while(q.size()>1) {
			FamilyNode curr = q.poll();
			if(curr==null) {
				q.add(null);
				continue;
			}else {
				System.out.print(curr.getParent()==null?null:(curr.getParent().getMale()+" "+curr.getParent().getFemale()));
				System.out.print("==>");
				System.out.println(curr.getMale()+" "+curr.getFemale()+" "+curr.getGender());
				
				if(curr.getChildreen()!=null) {
					for(FamilyNode fam:curr.getChildreen()) {
						if(fam!=null) {
							q.add(fam);
						}
					}
				}
			}
		}
	}
}
