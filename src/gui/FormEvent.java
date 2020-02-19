package gui;
import java.util.EventObject;

public class FormEvent extends EventObject {

	private static int count=0;
	
	private int id;
	private String name;
	private String occupation;
	private String empCategory;
	private AgeCategory ageCat;
	private String taxId;
	private boolean Checked;
	private String gender;
	
	
	public FormEvent(Object source) {
		 super(source);
	}
	public FormEvent(Object source,String name, String occupation,String empCategory,boolean Checked, String taxId,
			String gender,AgeCategory ageCat){
		super(source);
		this.name=name;
		this.occupation=occupation;
		this.empCategory=empCategory;
		this.ageCat= ageCat;
		this.Checked = Checked;
		this.taxId = taxId;
		this.gender=gender;
		count++;
		this.id=count;
		
	}
	public String getGender() {
		return gender;
	}
	public String getTaxId() {
		return taxId;
	}
	public boolean isChecked() {
		return Checked;
	}
	public String getEmpCategory() {
		return this.empCategory;
	}
	public int getAgeCat() {
		return ageCat.id;
	}
	public void setAgeCat(AgeCategory ageCat) {
		this.ageCat = ageCat;
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
	


}
