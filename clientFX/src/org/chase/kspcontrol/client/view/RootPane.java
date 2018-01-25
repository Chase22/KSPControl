package org.chase.kspcontrol.client.view;

import org.chase.kspcontrol.client.view.panels.KSPPane;
import org.chase.kspcontrol.client.view.panels.MoveablePane;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;

public class RootPane extends Pane {
	KSPMenuBar bar = new KSPMenuBar();
	
	FloatProperty gridSize = new SimpleFloatProperty();
	
	public RootPane() {
		getChildren().add(bar);
		bar.prefWidthProperty().bind(widthProperty());
		getStyleClass().add("MoveablePane");
	}
	
	public void addPane(KSPPane pane) {
		MoveablePane wrapper = new MoveablePane((Pane) pane);
		wrapper.setPadding(new Insets(10, 10, 10, 10));
		wrapper.setGridSize(getGridSize());
		wrapper.setPaneHeight(pane.getPaneHeight());
		wrapper.setPaneWidth(pane.getPaneWidth());
		wrapper.layoutYProperty().bind(bar.heightProperty());
		
		getChildren().add(wrapper);
	}
	
	public FloatProperty gridSizeProperty() {
		return gridSize;
	}
	
	public void setGridSize(float gridSize) {
		this.gridSize.set(gridSize);
	}
	
	public float getGridSize() {
		return this.gridSize.get();
	}
}
