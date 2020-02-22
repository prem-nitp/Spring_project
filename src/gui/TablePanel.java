package gui;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Person;

public class TablePanel extends JPanel {
	
	private JTable jtable;
	TableModel tableModel;
	
	public TablePanel() {
		
		tableModel = new TableModel();
		jtable = new JTable(tableModel);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(jtable),BorderLayout.CENTER);
	}

	public void setData(List<Person> db) {
		tableModel.setData(db);
		
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
		
	}

}
