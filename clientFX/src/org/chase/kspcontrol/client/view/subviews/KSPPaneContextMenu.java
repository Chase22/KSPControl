package org.chase.kspcontrol.client.view.subviews;

import org.chase.kspcontrol.client.view.MainGridPane;
import org.chase.kspcontrol.client.view.panels.KSPPane;
import org.chase.kspcontrol.client.view.panels.MoveablePane;

import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class KSPPaneContextMenu extends ContextMenu implements EventHandler<ActionEvent>{
	private MainGridPane parent;
	private MoveablePane pane;
	
	private CheckMenuItem lockedItem;
	private MenuItem deleteItem;
	
	public KSPPaneContextMenu(MoveablePane pane) {
		this.pane = pane;
		
		lockedItem = new CheckMenuItem("locked");
		deleteItem = new MenuItem("remove");
		
		lockedItem.selectedProperty().bindBidirectional(pane.lockedProperty());
		
		deleteItem.setOnAction(this);
		
		this.getItems().addAll(lockedItem, deleteItem);
	}
	
	public BooleanProperty lockedProperty() {
		return lockedItem.selectedProperty();
	}

	@Override
	public void handle(ActionEvent event) {
		pane.removeSelf();
	}
}
