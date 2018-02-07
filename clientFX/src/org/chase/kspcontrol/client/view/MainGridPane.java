package org.chase.kspcontrol.client.view;

import org.chase.kspcontrol.client.view.panels.KSPPane;
import org.chase.kspcontrol.client.view.panels.MoveablePane;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.Pane;

@StyleAnotation( {"MoveablePane", "KSPPane"} )
public class MainGridPane extends Pane {
	private FloatProperty gridSize = new SimpleFloatProperty();

	public MainGridPane() {
		StyleProcessor.addStyleClasses(this);
	}

	public void addPane(KSPPane pane, ReadOnlyDoubleProperty menuBarHeight) {
		MoveablePane wrapper = createWrapper(pane, menuBarHeight);

		getChildren().add(wrapper);
	}
	
	public MoveablePane createWrapper(KSPPane pane, ReadOnlyDoubleProperty menuBarHeight) {
		MoveablePane wrapper = new MoveablePane((Pane) pane);
		wrapper.setPadding(new Insets(10, 10, 10, 10));
		wrapper.gridSizeProperty().bind(gridSize);
		wrapper.setPaneHeight(pane.getPaneHeight());
		wrapper.setPaneWidth(pane.getPaneWidth());
		wrapper.layoutYProperty().bind(menuBarHeight);
		
		return wrapper;
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
