package news.contentMenu;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class TreeDatabaseContextMenu extends ContextMenu{
	public TreeDatabaseContextMenu(String databaseName) {
		//explore���������ݿ�ڵ�Ĳ˵�
		MenuItem newTable = new MenuItem("�½����ݿ�");
		MenuItem newShell = new MenuItem("�½�SQL");
		MenuItem seeStruct = new MenuItem("����ṹ");
		MenuItem refresh = new MenuItem("ˢ��");
		MenuItem seeEvent = new MenuItem("�鿴�¼�");
		MenuItem setting = new MenuItem("����"); 
		this.getItems().addAll(newTable,newShell,seeStruct,refresh,seeEvent,setting);
		
		newTable.setOnAction(null);
		newShell.setOnAction(null);
		seeStruct.setOnAction(null);
		seeEvent.setOnAction(null);
	}

}
