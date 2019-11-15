package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ShowTableEvent implements EventHandler<MouseEvent> {
	private String tableName;


	public ShowTableEvent(String tableName) {
		super();
		this.tableName=tableName;
	}


	@Override
	public void handle(MouseEvent mouseEvent) {
		System.out.println("hello");
		// TODO Auto-generated method stub
		if(mouseEvent.getClickCount() == 2)
		{
			System.out.println(this.tableName);
		}
	}

}
