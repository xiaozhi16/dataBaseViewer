package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import models.Table;

public class OpenTableEvent implements EventHandler<MouseEvent>{
	private Connection connection;
	private TabPane docView;
	private TreeView<Label> explore;
	public OpenTableEvent(TabPane docView, Connection connection, TreeView<Label> explore) {
		// TODO Auto-generated constructor stub
		this.explore=explore;
		this.connection=connection;
		this.docView = docView;
	}
	@Override
	public void handle(MouseEvent event) {
		// 事件需要处理的内容
		if(event.getClickCount()==2)
		{
			TreeItem<Label> selected=explore.getSelectionModel().getSelectedItem();
			if(explore.getTreeItemLevel(selected)==2)
			{
				try {
					//遍历tabpane检测是否已经打开过了，打开了就不用再打开
					for (Tab tmpTab : this.docView.getTabs()) {
						if(tmpTab.getText()==selected.getValue().getText())
						{
							this.docView.getSelectionModel().select(tmpTab);
							return ;
						}
					} 
					ResultSet result = DataBase.database.OpenTable(this.connection,selected.getValue().getText(),selected.getParent().getValue().getText());
					Table table = new Table();
					for(int i=1;i<=result.getMetaData().getColumnCount();i++)
					{
						table.getColumnNames().add(result.getMetaData().getColumnName(i));
					}
					System.out.println(result.getMetaData().getColumnName(1));
					while(result.next())
					{
						ArrayList<String> tmpdata = new ArrayList<String>(); 
						for(int i=1;i<=result.getMetaData().getColumnCount();i++)
						{
							tmpdata.add(result.getString(i));
						}
						table.getData().add(tmpdata);	
					}
					new news.TableTab(selected.getValue().getText(),docView, table);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.toString());
				}
				
			}
			
		}
				
		
	}

}
