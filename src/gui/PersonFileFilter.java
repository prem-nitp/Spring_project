package gui;
import java.io.File;
import javax.swing.filechooser.FileFilter;

public class PersonFileFilter extends FileFilter {

	@Override
	public boolean accept(File file) {
		
		String filename = file.getName();
		//FileFilter is a custom class which takes filename as arguments and returns the extension
		String fileExtension = FileFilterUtil.getExtension(filename);
		
		if(file.isDirectory())
			return true; 
		
		if(fileExtension.contentEquals("per"))
			return true;
		
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Person Database file (.per)";
	}

}
