package news.contentMenu;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
public class TreeTableContentMenu extends ContextMenu{
	/**
	 * @param
	 * 
	 **/
	public TreeTableContentMenu() {
		MenuItem newOne = new MenuItem("新建");
		MenuItem newShell = new MenuItem("新建shell");
		MenuItem structure = new MenuItem("结构");
		MenuItem open = new MenuItem("浏览");
		this.getItems().addAll(newOne,newShell,structure,open);
		
	}
	
}
