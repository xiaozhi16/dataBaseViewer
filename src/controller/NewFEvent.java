package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TabPane;
import news.Console;

public class NewFEvent implements EventHandler<ActionEvent>{
	private TabPane console;
	public NewFEvent(TabPane console) {
		// 
		super();
		this.setConsole(console);
		
	}
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		new Console(this.console);
	}
	public TabPane getConsole() {
		return console;
	}
	public void setConsole(TabPane console) {
		this.console = console;
	}

	
	

}
