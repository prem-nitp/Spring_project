import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame{
	
	//variable declaration
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
		
		//variable initialization
		toolbar = new Toolbar();
		Tp = new TextPanel();
		formpanel = new FormPanel();
		setJMenuBar(createMenuBar());
		
		//Toolbar releted activity
		toolbar.setTextListener(new StringListener() {

			@Override
			public void StringEmitted(String text) {
				Tp.addText(text);	
			}
			
		});
		//Formpanel releted activity
		formpanel.setFormListener(new FormListener() {

			@Override
			public void FormEventOccured(FormEvent ev) {
				Tp.addText(ev.getName()+" "+ev.getOccupation()+" "+ev.getAgeCat()+ev.getEmpCategory()+""+"\n");
			}		
		});
		
		add(toolbar,BorderLayout.NORTH);
		add(Tp,BorderLayout.CENTER);
		add(formpanel,BorderLayout.WEST);
				
	}
	private JMenuBar createMenuBar() {
		
		JMenuBar menuBar= new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu windowMenu = new JMenu("Window");
		JMenuItem exportDataItem = new JMenuItem("Export Data..");
		JMenuItem importDataItem = new JMenuItem("Import Data..");
		JMenuItem exitItem = new JMenuItem("Exit");
		fileMenu.add(importDataItem);
		fileMenu.add(exportDataItem);
		fileMenu.add(exitItem);
		
		JMenu showMenu = new JMenu("Show");
		JMenuItem personDataItem = new JMenuItem("PersonForm");
		showMenu.add(personDataItem);
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		return menuBar;
	}

}
