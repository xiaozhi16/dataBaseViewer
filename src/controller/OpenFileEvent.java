package controller;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TabPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import news.Console;

public class OpenFileEvent implements EventHandler<ActionEvent>{
	
	private TabPane console;
	private Stage stage;
	public OpenFileEvent(TabPane console,Stage stage) {
		// 传入主界面的控制台控件
		super();
		this.console = console;
		this.stage = stage;
	}
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		FileChooser filechoose = new FileChooser();
		FileChooser.ExtensionFilter extension = new FileChooser.ExtensionFilter("SQL FILE(*.sql)", "*.sql");
		filechoose.getExtensionFilters().add(extension);
		filechoose.setTitle("请选择需要打开的文件");
		File file = filechoose.showOpenDialog(stage);
		
		try {
			if(file == null)
			{
				return ;
			}
			else {
				new Console(this.console).addEditor(file);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
