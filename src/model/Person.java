package model;

public class Person {
	
	
	int id;
	String name;
	String occupation;
	EmploymentCategory employmentCategory;
	AgeCategory ageCategory;
	String taxId;
	boolean indianCitizen;
	Gender gender;
	
	public Person(String name, String occupation, EmploymentCategory employmentCategory, AgeCategory ageCategory,
			String taxId, boolean indianCitizen, Gender gender) {
		
		this.name = name;
		this.occupation=occupation;
		this.employmentCategory=employmentCategory;
		this.ageCategory=ageCategory;
		this.taxId=taxId;
		this.indianCitizen=indianCitizen;
		this.gender=gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public EmploymentCategory getEmploymentCategory() {
		return employmentCategory;
	}

	public void setEmploymentCategory(EmploymentCategory employmentCategory) {
		this.employmentCategory = employmentCategory;
	}

	public AgeCategory getAgeCategory() {
		return ageCategory;
	}

	public void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public boolean isIndianCitizen() {
		return indianCitizen;
	}

	public void setIndianCitizen(boolean indianCitizen) {
		this.indianCitizen = indianCitizen;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
