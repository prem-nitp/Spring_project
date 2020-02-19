package gui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameTextField;
	private JTextField occupationField;
	private JList ageList;
	private FormListener listener;
	private JButton okBtn;
	private JComboBox empCat;
	private JCheckBox citizenCheck;
	private JTextField taxField;
	private JLabel taxLabel;
	
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup genderGroup;
	
	
	public FormPanel()
	{
		Dimension dim = getPreferredSize();
		dim.width=250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameTextField = new JTextField(10);
		occupationField = new JTextField(10);
		ageList = new JList();
		empCat = new JComboBox();
		citizenCheck = new JCheckBox();
		taxField = new JTextField(10);
		taxLabel = new JLabel("Tax ID:");
		//disable the texField and TaxLabel by default enable when citizen checkbox is checked
		taxField.setVisible(false);
		taxLabel.setVisible(false);
		
		//Gender related
		maleRadio = new JRadioButton("Male");
		femaleRadio = new JRadioButton("Female");
		//To extract the text from the radio button when it would be selected
		maleRadio.setActionCommand("Male");
		femaleRadio.setActionCommand("Female");
		maleRadio.setSelected(true);
		genderGroup = new ButtonGroup();
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);
		
		okBtn = new JButton("OK");
		
		//set Jlist
		DefaultListModel listmodel = new DefaultListModel();
		listmodel.addElement(new AgeCategory(0,"0  to 18"));
		listmodel.addElement(new AgeCategory(1,"19 to 40"));
		listmodel.addElement(new AgeCategory(2,"41  to 65"));
		listmodel.addElement(new AgeCategory(3,"Above  65"));
		ageList.setModel(listmodel);
		
		//set JComboBox
		DefaultComboBoxModel empModel = new DefaultComboBoxModel();
		empModel.addElement("Employed");
		empModel.addElement("self-Employed");
		empModel.addElement("Unemployed");
		empModel.addElement("other");
		empCat.setModel(empModel);
		
		
		ageList.setPreferredSize(new Dimension(110,80));
		ageList.setBorder(BorderFactory.createEtchedBorder());
		
		Border innerBorder = BorderFactory.createTitledBorder("Add person");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		//citizen checkbox listener
		citizenCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean isChecked = citizenCheck.isSelected();
				// set visible of taxfield and taxLabel depending on the citizenCheck
				taxField.setVisible(isChecked);
				taxLabel.setVisible(isChecked);
				
			}
			
		});
		//ok button Listener
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameTextField.getText();
				String occupation = occupationField.getText();
				AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
				String emp = (String) empCat.getSelectedItem();
				String taxId = taxField.getText();
				boolean checked = citizenCheck.isSelected();
				String gender = (String) genderGroup.getSelection().getActionCommand();
				
				FormEvent ev = new FormEvent(this,name,occupation,emp,checked,taxId,gender,ageCat);
				
				if (listener!=null)
				listener.FormEventOccured(ev);
			}
			
		});
		//calling setcomponents function to set the all other components in Formpnel
		setComponents();
	}
	public void setFormListener(FormListener listener) {
		
		this.listener = listener;
}
public void setComponents() {
	setLayout(new GridBagLayout());
	GridBagConstraints gc = new GridBagConstraints();

	/////    First row    ///////
	gc.gridy=0;
	
	gc.weightx=1;
	gc.weighty=0.1;
	
	gc.gridx=0;
	gc.fill=GridBagConstraints.NONE;
	gc.anchor=GridBagConstraints.LINE_END;
	gc.insets = new Insets(0,0,0,5);
	add(nameLabel,gc);
	
	gc.gridx=1;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.LINE_START;
	add(nameTextField,gc);
	
	/////    second row    ///////
	gc.gridy++;
	
	gc.weightx=1;
	gc.weighty=0.1;
	
	gc.gridx=0;
	gc.insets = new Insets(0,0,0,5);
	gc.anchor=GridBagConstraints.LINE_END;
	add(occupationLabel,gc);
	
	gc.gridx=1;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.LINE_START;
	add(occupationField,gc);
	
	/////    Third row    ///////
	gc.gridy++;
	gc.weighty=0.2;
	
	gc.gridx=0;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,5);
	gc.anchor=GridBagConstraints.FIRST_LINE_END;
	add(new JLabel("Age:"),gc);
	
	gc.gridx=1;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.FIRST_LINE_START;
	add(ageList,gc);
	
	/////    Fourth row    ///////
	gc.gridy++;
	gc.weighty=0.2;
	
	gc.gridx=0;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,5);
	gc.anchor=GridBagConstraints.FIRST_LINE_END;
	add(new JLabel("Employed:"),gc);
	
	gc.gridx=1;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.FIRST_LINE_START;
	add(empCat,gc);
	
/////    Fifth row    ///////
	gc.gridy++;
	gc.weighty=0.2;
	
	gc.gridx=0;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,5);
	gc.anchor=GridBagConstraints.FIRST_LINE_END;
	add(new JLabel("Indian Citizen:"),gc);
	
	gc.gridx=1;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.FIRST_LINE_START;
	add(citizenCheck,gc);
	
/////    sixth row    ///////
	gc.gridy++;
	gc.weighty=0.2;
	
	gc.gridx=0;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,5);
	gc.anchor=GridBagConstraints.FIRST_LINE_END;
	add(taxLabel,gc);
	
	gc.gridx=1;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.FIRST_LINE_START;
	add(taxField,gc);
	
/////    seventh row    ///////
	gc.gridy++;
	gc.weighty=0.05;
	
	gc.gridx=0;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,5);
	gc.anchor=GridBagConstraints.FIRST_LINE_END;
	add(new JLabel("Gender:"),gc);
	
	gc.gridx=1;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.FIRST_LINE_START;
	add(maleRadio,gc);
	
/////    Eighth row    ///////
	gc.gridy++;
	gc.weighty=0.2;
	
	gc.gridx=1;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.FIRST_LINE_START;
	add(femaleRadio,gc);
	
	/////    Ninth row   ///////
	gc.gridy++;
	gc.weighty=2;
	
	gc.gridx=1;
	gc.weightx=1;
	gc.insets = new Insets(0,0,0,0);
	gc.anchor=GridBagConstraints.FIRST_LINE_START;
	add(okBtn,gc);
	

}
}

class AgeCategory{
	int id;
	String text;
	public AgeCategory(int id , String text) {
		this.id=id;
		this.text=text;
	}
	public String toString() {
		return text;
	}
}