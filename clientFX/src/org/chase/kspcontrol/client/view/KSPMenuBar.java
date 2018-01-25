package org.chase.kspcontrol.client.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class KSPMenuBar extends MenuBar {
	public KSPMenuBar() {
		Menu file = new Menu("File");
		Menu misc = new Menu("Misc");
		
		MenuItem about = new MenuItem("About");
		
		about.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new AboutDialog().showDialog();
			}
		});
		
		misc.getItems().add(about);
		
		this.getMenus().addAll(file, misc);
	}
}
