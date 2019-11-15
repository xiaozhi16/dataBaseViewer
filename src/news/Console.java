package news;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

public class Console extends Tab{
	private static int count=1;
	//构造一个函数
	public Console(TabPane parent) {
		this.addEditor();
		this.setText("new "+Console.count);
		parent.getTabs().add(this);
		parent.getSelectionModel().select(this);
		Console.count++;
	}
	public void addEditor() {
		TextArea editor = new TextArea();
		editor.setId("editor");
		this.setContent(editor);
	}
	public void addEditor(File file) throws IOException {
		TextArea editor = new TextArea();
		editor.setId("editor");
		//首先设置tab标题
		this.setText(file.getName());
		InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
		BufferedReader bufferedreader = new BufferedReader(reader);
		//其次读出文件
		StringBuffer content = new StringBuffer();
		String line = bufferedreader.readLine();
		while(line!=null)
		{
			content.append(line);
			content.append("\n");
			line = bufferedreader.readLine();
		}
		bufferedreader.close();
		editor.setText(content.toString());
		this.setContent(editor);
	}
}
