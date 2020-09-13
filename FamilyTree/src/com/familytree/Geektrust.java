package com.familytree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.familytree.controller.FamileyTreeController;

public class Geektrust {

	private FamileyTreeController controller;
	
	public void init() {
		controller = new FamileyTreeController();
		String[][] treeArr = {
				{"Queen Anga", "Chit", "Amba", "Male"},	
				{"Queen Anga", "Ish", null, "Male"},	
				{"Queen Anga", "Vich", "Lika", "Male"},	
				{"Queen Anga", "Aras", "Chitra", "Male"},	
				{"Queen Anga", "Vyan", "Satya", "Female"},	
				{"Amba", "Jaya", "Dritha", "Female"},	
				{"Amba", null, "Tritha", "Female"},
				{"Amba", "Vritha", null, "Male"},
				{"Lika", null, "Vila", "Female"},
				{"Lika", null, "Chika", "Female"},
				{"Chitra", "Arit", "Jnki", "Female"},
				{"Chitra", "Ahit", null, "Male"},
				{"Satya", "Asva", "Satvy", "Male"},
				{"Satya", "Vyas", "Krpi", "Male"},
				{"Satya", null, "Atya", "Female"},
				{"Dritha", null, "Yodhan", "Male"},
				{"Jnki", "Laki", null, "Male"},
				{"Jnki", null, "Lavnya", "Female"},
				{"Satvy", null, "Vasa", "Female"},
				{"Krpi", "Kriya", null, "Male"},
				{"Krpi", null, "Krithi", "Female"},
				
		};
		
		for(String[] fam:treeArr) {
			controller.addFamily(fam[0], fam[1], fam[2], fam[3]);
		}
	}
	
	public void printList(List<String> person) {
		if(person==null) {
			System.out.println("PERSON_NOT_FOUND");
		}else {
			if(person.size()==0) {
				System.out.println("NONE");
			}else {
				for(String str:person) {
					System.out.print(str);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
	
	public void driverMethod(String filePath) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filePath));
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(line, " ");
			String command = st.nextToken();
			if(command.equalsIgnoreCase("ADD_CHILD")) {
				String motherName = st.nextToken();
				String childName = st.nextToken();
				String gender = st.nextToken();
				System.out.println(controller.addFamily(motherName, childName, gender));
			}else {
				String name = st.nextToken();
				String relation = st.nextToken();
				switch(relation) {
				case "Paternal-Uncle":
					List<String> paternalUncle = controller.findPaternalUncle(name);
					printList(paternalUncle);
					break;
				case "Maternal-Uncle":
					List<String> maternallUncle = controller.findMetarnalUncle(name);
					printList(maternallUncle);
					break;
				case "Paternal-Aunt":
					List<String> paternalAunt = controller.findParentalAunt(name);
					printList(paternalAunt);
					break;
				case "Maternal-Aunt":
					List<String> maternalAunt = controller.findMetarnalAunt(name);
					printList(maternalAunt);
					break;
				case "Sister-In-Law":
					List<String> sisterInLaw = controller.findSisterInLaw(name);
					printList(sisterInLaw);
					break;
				case "Brother-In-Law":
					List<String> brotherInLaw = controller.findBrotherInLaw(name);
					printList(brotherInLaw);
					break;
				case "Son":
					List<String> sons = controller.findSon(name);
					printList(sons);
					break;
				case "Daughter":
					List<String> daughters = controller.findDaughter(name);
					printList(daughters);
					break;
				case "Siblings":
					List<String> siblings = controller.findSiblings(name);
					printList(siblings);
				}
			}
		}
		scanner.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Geektrust obj = new Geektrust();
		obj.init();
		obj.driverMethod(args[0]);
	}
}
