package news.contentMenu;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class TreeDatabaseContextMenu extends ContextMenu{
	public TreeDatabaseContextMenu(String databaseName) {
		//explore中树形数据库节点的菜单
		MenuItem newTable = new MenuItem("新建数据库");
		MenuItem newShell = new MenuItem("新建SQL");
		MenuItem seeStruct = new MenuItem("浏览结构");
		MenuItem refresh = new MenuItem("刷新");
		MenuItem seeEvent = new MenuItem("查看事件");
		MenuItem setting = new MenuItem("设置"); 
		this.getItems().addAll(newTable,newShell,seeStruct,refresh,seeEvent,setting);
		
		newTable.setOnAction(null);
		newShell.setOnAction(null);
		seeStruct.setOnAction(null);
		seeEvent.setOnAction(null);
	}

}
