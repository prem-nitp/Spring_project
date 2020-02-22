package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.server.LoaderHandler;
import java.util.List;

import gui.FormEvent;
import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;

public class Controller {
	
	Database database = new Database();
	
	public List<Person> getPerson() {
		return database.getPerson();
	}
	public void addPerson(FormEvent ev) {
		
		String name = ev.getName();
		String occupation = ev.getOccupation();
		int ageCatId = ev.getAgeCat();
		String empCategorystString = ev.getEmpCategory();
		String genderString = ev.getGender();
		String taxId = ev.getTaxId();
		boolean indianCitizen = ev.isChecked();
		
		AgeCategory ageCategory;
		switch(ageCatId) {
		case 0:
			ageCategory = AgeCategory.CHILD;
			break;
		case 1:
			ageCategory = AgeCategory.ADULT;
			break;
		case 2:
			ageCategory = AgeCategory.SENIOR;
			break;
		default:
			ageCategory = AgeCategory.OLD;
			break;
		}
		
		
		Gender gender;
		if(genderString.equals("Male")) {
			gender = Gender.MALE;
		}
		else {
			gender = Gender.FEMALE;
		}
		
		
		EmploymentCategory employmentCategory;
		if(empCategorystString.equals("Employed")) {
			
			employmentCategory = EmploymentCategory.EMPLOYED;
		}
		else if(empCategorystString.equals("Self-Employed")) {
			
			employmentCategory = EmploymentCategory.SELF_EMPLOYED;
		}
		else if(empCategorystString.equals("Unemployed")) {
			
			employmentCategory = EmploymentCategory.UNEMPLOYED;
		}
		else {
			employmentCategory = EmploymentCategory.OTHER;
		}
			
		
		Person person = new Person(name, occupation, employmentCategory, ageCategory, taxId, indianCitizen, gender);
		database.addPerson(person);
	}
	public void saveToFile(File file) {
		
		database.saveTofile(file);
	}
	
	public void LoadFromFile(File file) throws IOException {
		
		database.loadFromFile(file);
	}

}
