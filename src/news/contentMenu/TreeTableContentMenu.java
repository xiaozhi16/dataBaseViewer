package news.contentMenu;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
public class TreeTableContentMenu extends ContextMenu{
	/**
	 * @param tableName 
	 * @param
	 * 
	 **/
	public TreeTableContentMenu(String tableName) {
		MenuItem newOne = new MenuItem("新建");
		MenuItem open = new MenuItem("浏览");
		MenuItem newShell = new MenuItem("SQL");
		MenuItem structure = new MenuItem("结构");
		MenuItem setting = new MenuItem("设置");
		MenuItem drop =new MenuItem("删除");
		this.getItems().addAll(newOne,open,newShell,structure,setting,drop);		
	}
	
}
