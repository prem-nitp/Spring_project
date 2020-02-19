package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener{

	private JButton helloBtn;
	private JButton goodByeBtn;
	private StringListener textlistener;
	
	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		helloBtn = new JButton("Hello");
		goodByeBtn = new JButton("good bye");
		
		helloBtn.addActionListener(this);
		goodByeBtn.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(helloBtn);
		add(goodByeBtn);
	}
	public void setTextListener(StringListener listener) {
		this.textlistener = listener;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource();
		if(clicked==helloBtn) {
			textlistener.StringEmitted("hello\n");
		}
		else if(clicked==goodByeBtn) {
			textlistener.StringEmitted("goodBye\n");
		}		
	}
}
