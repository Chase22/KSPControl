package org.chase.kspcontrol.client.view;

import org.chase.kspcontrol.client.view.subviews.KSPMenuBar;
import org.chase.kspcontrol.client.view.subviews.PaneListPanel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;

public class RootPane extends BorderPane{
	KSPMenuBar bar = new KSPMenuBar();
	MainGridPane grid;
	PaneListPanel listpane;
	
	
	public RootPane() {
		grid = new MainGridPane();
		listpane = new PaneListPanel(this);
		
		setTop(bar);
		setCenter(grid);
		setRight(listpane);
	}
	
	public MainGridPane getGridPane() {
		return grid;
	}
	
	public KSPMenuBar getMenuBar() {
		return bar;
	}

}
