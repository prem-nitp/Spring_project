/*This class is just for Text area in centre */

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	
	private JTextArea TA;
	
	public TextPanel() {
		TA = new JTextArea();
		setLayout(new BorderLayout());
		add(new JScrollPane(TA),BorderLayout.CENTER);
	}
	public void addText(String text) {
		TA.append(text);
	}

}
