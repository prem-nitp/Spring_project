package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
	public void saveTofile(File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			Person[] persons = people.toArray(new Person[people.size()]);
			oos.writeObject(persons);
			
			oos.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void loadFromFile(File file) throws IOException {
	
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
			Person[] persons;
			try {
				persons = (Person[])ois.readObject();
				
				people.clear();
				people.addAll(Arrays.asList(persons));
				
				ois.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}

}
