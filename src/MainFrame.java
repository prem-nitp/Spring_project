import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame{
	
	private TextPanel Tp;
	private JButton btn;
	private Toolbar toolbar;
	public MainFrame()
	{
		super("Hello world");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //call this method to close the app when you click on cross mark
		setVisible(true);
		//setlayout
		setLayout(new BorderLayout());
		
		toolbar = new Toolbar();
		Tp = new TextPanel();
		btn = new JButton("click me");
		
		toolbar.setTextPanel(Tp);
		add(toolbar,BorderLayout.NORTH);
		add(Tp,BorderLayout.CENTER);
		add(btn,BorderLayout.SOUTH);
		
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {  
				// Add hello world when button got clicked.
				Tp.addText("hello world\n");
				
			}
		});
				
	}

}
