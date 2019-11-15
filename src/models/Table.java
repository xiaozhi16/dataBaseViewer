package models;

import java.util.ArrayList;

public class Table {
	private ArrayList<String> columnNames;
	private ArrayList<ArrayList<String>> data;
	public Table() {
		// TODO Auto-generated constructor stub
		this.columnNames= new ArrayList<String>();
		this.data = new ArrayList<ArrayList<String>>();
	}
	public ArrayList<String> getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(ArrayList<String> columnNames) {
		this.columnNames = columnNames;
	}
	public ArrayList<ArrayList<String>> getData() {
		return data;
	}
	public void setData(ArrayList<ArrayList<String>> data) {
		this.data = data;
	}
}
