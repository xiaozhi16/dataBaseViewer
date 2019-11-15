package news;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import models.Table;

public class TableTab extends Tab{
	public TableTab(String name,TabPane parent,Table tableModel) {
		super(name);
		parent.getTabs().add(this);
		parent.getSelectionModel().select(this);
		ObservableList<ArrayList<String>> data = FXCollections.observableArrayList();
		data.addAll(tableModel.getData());
		
		//开始表的构建
		TableView<ArrayList<String>> table = new TableView<ArrayList<String>>();
//		table.setEditable(true);
		for (String columnName  : tableModel.getColumnNames()) {
			TableColumn<ArrayList<String>,String> tmpColumns=new TableColumn<ArrayList<String>, String>(columnName);
			tmpColumns.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ArrayList<String>,String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<ArrayList<String>, String> arg0) {
					// TODO Auto-generated method stub
					return new SimpleStringProperty(arg0.getValue().get(tableModel.getColumnNames().indexOf(columnName)));
				}
			});
			table.getColumns().add(tmpColumns);
		}
		
		table.setItems(data);
		table.setEditable(true);
		this.setContent(table);
	}
}