import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame{
	
	private JTextArea textarea;
	private JButton btn;
	public MainFrame()
	{
		super("Hello world");
		//setlayout
		setLayout(new BorderLayout());
		textarea = new JTextArea();
		add(textarea,BorderLayout.CENTER);
		btn = new JButton("click me");
		add(btn,BorderLayout.SOUTH);
		//to make apps more robust use a seprate thread to run the app 
				SwingUtilities.invokeLater(new Runnable () {
					public void run() {
						setSize(600, 500);
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						setVisible(true);
					}
				});
				
	}

}
