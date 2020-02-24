package gui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;

public class MainFrame extends JFrame{
	
	//variable declaration
	private TextPanel Tp;
	private Toolbar toolbar;
	private FormPanel formpanel;
	private TablePanel tablePanel;
	private JFileChooser fileChooser;
	private SetPrefsDialog prefsDialog;
	
	private Controller controller;
	
	public MainFrame()
	{
		super("Hello world");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //call this method to close the app when you click on cross mark
		setVisible(true);
		
		//setLayout
		setLayout(new BorderLayout());
		
		//variable initialization
		toolbar = new Toolbar();
		Tp = new TextPanel();
		formpanel = new FormPanel();
		setJMenuBar(createMenuBar());
		
		controller = new Controller();
		
		tablePanel = new TablePanel();
		tablePanel.setData(controller.getPerson());
		
		prefsDialog = new  SetPrefsDialog(this);
		
		//ToolBar related activity
		toolbar.setTextListener(new StringListener() {

			@Override
			public void StringEmitted(String text) {
				Tp.addText(text);	
			}
			
		});
		//FormPanel related activity
		formpanel.setFormListener(new FormListener() {

			@Override
			public void FormEventOccured(FormEvent ev) {
				//Tp.addText(ev.getName()+" "+ev.getOccupation()+" "+ev.getAgeCat()+ev.getEmpCategory()+""+"\n");
				tablePanel.refresh();
				controller.addPerson(ev);
			}		
		});
		tablePanel.setDeleteRow(new DeleteRowListener() {
			
			@Override
			public void deleteRow(int row) {
				controller.removePerson(row);
				System.out.println(row);
			}
		});
		
		//Add different component to MainFrame which extends JFrame
		add(toolbar,BorderLayout.NORTH);
		//add(Tp,BorderLayout.CENTER);
		add(formpanel,BorderLayout.WEST);
		add(tablePanel,BorderLayout.CENTER);
				
	}
	private JMenuBar createMenuBar() {
		
		JMenuBar menuBar= new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu windowMenu = new JMenu("Window");
		JMenuItem exportDataItem = new JMenuItem("Export Data..");
		JMenuItem importDataItem = new JMenuItem("Import Data..");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		JMenuItem prefsItem = new JMenuItem("Preferences...");
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		
		fileMenu.add(importDataItem);
		fileMenu.add(exportDataItem);
		fileMenu.add(exitItem);
		
		JMenu showMenu = new JMenu("Show");
		JCheckBoxMenuItem showFormItem =  new JCheckBoxMenuItem("PersonForm");
		showFormItem.setSelected(true);
		
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		windowMenu.add(prefsItem);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		exitItem.setMnemonic(KeyEvent.VK_X);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		
		//Added accelerator for importDataItem
		importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
		
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you Really want to exit","Confirm Exit",
						JOptionPane.OK_CANCEL_OPTION);
				if(action==JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
			
		});
		importDataItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				if(fileChooser.showOpenDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION) {
					
					try{
						File file = fileChooser.getSelectedFile();
						tablePanel.refresh();
						controller.LoadFromFile(file);
						
					}catch (Exception e) {
						
						JOptionPane.showMessageDialog(MainFrame.this, "Couldn't load data from file","Error"
								,JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
		});
		exportDataItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				if(fileChooser.showSaveDialog(MainFrame.this)==JFileChooser.APPROVE_OPTION) {
					
					try{
						File file = fileChooser.getSelectedFile();
						controller.saveToFile(file);
						
					}catch (Exception e) {
						
						JOptionPane.showMessageDialog(MainFrame.this, "Couldn't save data to file");
					}
				}
				
			}
		});
		
		showFormItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
				formpanel.setVisible(menuItem.isSelected());
			}
			
		});
		
		prefsItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				prefsDialog.setVisible(true);
				
			}
		});
		
		return menuBar;
	}

}
