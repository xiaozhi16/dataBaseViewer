package news.contentMenu;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
public class TreeTableContentMenu extends ContextMenu{
	/**
	 * @param
	 * 
	 **/
	public TreeTableContentMenu() {
		MenuItem newOne = new MenuItem("�½�");
		MenuItem newShell = new MenuItem("�½�shell");
		MenuItem structure = new MenuItem("�ṹ");
		MenuItem open = new MenuItem("���");
		this.getItems().addAll(newOne,newShell,structure,open);
		
	}
	
}
