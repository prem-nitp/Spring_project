import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {

	private JButton helloBtn;
	private JButton goodByeBtn;
	
	public Toolbar() {
		helloBtn = new JButton("Hello");
		goodByeBtn = new JButton("good bye");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(helloBtn);
		add(goodByeBtn);
	}
}
