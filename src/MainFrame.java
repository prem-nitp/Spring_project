import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame{
	
	private TextPanel Tp;
	private Toolbar toolbar;
	private FormPanel formpanel;
	
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
		formpanel = new FormPanel();
		
		toolbar.setTextListener(new StringListener() {

			@Override
			public void StringEmitted(String text) {
				Tp.addText(text);	
			}
			
		});
		
		formpanel.setFormListener(new FormListener() {

			@Override
			public void FormEventOccured(FormEvent ev) {
				Tp.addText(ev.getName()+" "+ev.getOccupation()+"\n");
			}		
		});
		
		add(toolbar,BorderLayout.NORTH);
		add(Tp,BorderLayout.CENTER);
		add(formpanel,BorderLayout.WEST);
				
	}

}
