import java.util.EventObject;

public class FormEvent extends EventObject {

	String name;
	String occupation;
	AgeCategory ageCat;
	
	public FormEvent(Object source) {
		 super(source);
	}
	public FormEvent(Object source,String name, String occupation,AgeCategory ageCat){
		super(source);
		this.name=name;
		this.occupation=occupation;
		this.ageCat= ageCat;
		
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
