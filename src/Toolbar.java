import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{

	private JButton helloBtn;
	private JButton goodByeBtn;
	private TextPanel textpanel;
	
	public Toolbar() {
		helloBtn = new JButton("Hello");
		goodByeBtn = new JButton("good bye");
		
		helloBtn.addActionListener(this);
		goodByeBtn.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(helloBtn);
		add(goodByeBtn);
	}
	public void setTextPanel(TextPanel textpanel) {
		this.textpanel = textpanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		if(clicked==helloBtn) {
			textpanel.addText("hello\n");
		}
		else if(clicked==goodByeBtn) {
			textpanel.addText("goodBye\n");
		}
			
			
	}
}
