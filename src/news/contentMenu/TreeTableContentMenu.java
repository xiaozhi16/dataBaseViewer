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
		MenuItem newOne = new MenuItem("�½�");
		MenuItem open = new MenuItem("���");
		MenuItem newShell = new MenuItem("SQL");
		MenuItem structure = new MenuItem("�ṹ");
		MenuItem setting = new MenuItem("����");
		MenuItem drop =new MenuItem("ɾ��");
		this.getItems().addAll(newOne,open,newShell,structure,setting,drop);		
	}
	
}
