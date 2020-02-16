import java.util.EventObject;

public class FormEvent extends EventObject {

	String name;
	String occupation;
	String empCategory;
	AgeCategory ageCat;
	String taxId;
	boolean Checked;
	
	
	public FormEvent(Object source) {
		 super(source);
	}
	public FormEvent(Object source,String name, String occupation,String empCategory,boolean Checked, String taxId,
			AgeCategory ageCat){
		super(source);
		this.name=name;
		this.occupation=occupation;
		this.empCategory=empCategory;
		this.ageCat= ageCat;
		this.Checked = Checked;
		this.taxId = taxId;
		
		
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
