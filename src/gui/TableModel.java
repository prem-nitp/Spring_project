package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;

public class TableModel extends AbstractTableModel {
	
	private List<Person> db;
	private String ColumnName[] = {"Id","Name","Occupation","AgeCategory","EmploymentCategory","Gender","TaxId","IsIndianCitizen"};

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public String getColumnName(int column) {
		return ColumnName[column];
	}

	@Override
	public int getRowCount() {
		
		return db.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		//System.out.println(row+" "+col);
		Person person = db.get(row);
		switch(col) {
		case 0:
			return person.getId();
		case 1:
			return person.getName();
		case 2:
			return person.getOccupation();
		case 3:
			return person.getAgeCategory();
		case 4:
			return person.getEmploymentCategory();
		case 5:
			return person.getGender();
		case 6:
			return person.getTaxId();
		case 7:
			return person.isIndianCitizen();
			
		}
		return null;
	}

	public void setData(List<Person> db) {
		this.db = db;
	}

}
