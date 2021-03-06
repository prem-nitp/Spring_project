package gui;

import java.awt.BorderLayout;
import java.awt.PopupMenu;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Popup;

import model.Person;

public class TablePanel extends JPanel {
	
	private JTable table;
	private TableModel tableModel;
	private JPopupMenu popup;
	private DeleteRowListener deleteRowListener;
	
	public TablePanel() {
		
		tableModel = new TableModel();
		table = new JTable(tableModel);
		popup = new JPopupMenu();
		
		JMenuItem removeItem = new JMenuItem("Delete row");
		popup.add(removeItem);
		//Add mouseListener to jtable
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				if(e.getButton()==MouseEvent.BUTTON3) {
					int row = table.rowAtPoint(e.getPoint());
					
					table.getSelectionModel().setSelectionInterval(row, row);
					
					popup.show(table, e.getX(), e.getY());
				}
			}
			
		});
		removeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				//System.out.println(row);
				deleteRowListener.deleteRow(row);	
				tableModel.fireTableRowsDeleted(row, row);
			}
		});
		setLayout(new BorderLayout());
		add(new JScrollPane(table),BorderLayout.CENTER);
		
	}

	public void setData(List<Person> db) {
		tableModel.setData(db);
		
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
		
	}

	public void setDeleteRow(DeleteRowListener deleteRowListener) {
		this.deleteRowListener=deleteRowListener;
		
	}

}
