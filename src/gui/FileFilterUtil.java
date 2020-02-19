package gui;

public class FileFilterUtil {
	public static String getExtension(String name) {
		
		int idx = name.lastIndexOf(".");
		if(idx==-1)  //if '.' is not present
			return null;
		
		if(idx==name.length()-1) //if . is the last character of name
			return null;
		
		return name.substring(idx+1,name.length());

	}

}
