package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
	public ArrayList<Person> people;
	
	public Database() {
		people = new ArrayList<Person>();
	}
	
	public void addPerson(Person person) {
		people.add(person);
		//System.out.println(person);
	}
	public List<Person> getPerson() {
		return people;
	}

}
