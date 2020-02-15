import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	private JLabel nameLabel;
	private JLabel occupationLabel;
	private JTextField nameTextField;
	private JTextField occupationField;
	private JButton okBtn;
	
	public FormPanel()
	{
		Dimension dim = getPreferredSize();
		dim.width=250;
		setPreferredSize(dim);
		
		nameLabel = new JLabel("Name: ");
		occupationLabel = new JLabel("Occupation: ");
		nameTextField = new JTextField();
		occupationField = new JTextField();
		okBtn = new JButton("OK");
		add(nameLabel);
		add(occupationLabel);
		//add(name)
		Border innerBorder = BorderFactory.createTitledBorder("Add person");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}

}
