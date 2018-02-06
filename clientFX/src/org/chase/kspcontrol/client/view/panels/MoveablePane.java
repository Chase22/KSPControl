package org.chase.kspcontrol.client.view.panels;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MoveablePane extends VBox implements EventHandler<MouseEvent>, KSPPane {

	private FloatProperty gridSize = new SimpleFloatProperty();
	
	private IntegerProperty heightProperty = new SimpleIntegerProperty() {
		@Override
		public void set(int newValue) {
			super.set(newValue);
			setMaxHeight(newValue * gridSize.get());
			setMinHeight(newValue * gridSize.get());
			setPrefHeight(newValue * gridSize.get());
		};
	};
	private IntegerProperty widthProperty = new SimpleIntegerProperty() {
		@Override
		public void set(int newValue) {
			super.set(newValue);
			setMaxWidth(newValue * gridSize.get());
			setMinWidth(newValue * gridSize.get());
			setPrefWidth(newValue * gridSize.get());
		};
	};

	public MoveablePane(Pane child) {
		getStyleClass().add("MoveablePane");
		child.getStyleClass().add(child.getClass().getSimpleName());
		this.getChildren().add(child);
		this.setOnMouseDragged(this);
	}

	@Override
	public void handle(MouseEvent event) {
		double translateX = Math.round(((event.getX() + getTranslateX()) / gridSize.get())) * gridSize.get();
		double translateY = Math.round(((event.getY() + getTranslateY()) / gridSize.get())) * gridSize.get();

		this.setManaged(false);
		
		System.out.println(getParent().getLayoutBounds().getMinX() + " " + this.getLayoutX() + translateX);

		if (this.getLayoutX() + translateX + getPrefWidth() < getParent().getLayoutBounds().getMaxX()
				&& this.getLayoutX() + translateX > getParent().getLayoutBounds().getMinX()) {

			this.setTranslateX(translateX);
		}

		if (this.getLayoutY() + translateY + getPrefHeight() < getParent().getLayoutBounds().getMaxY() && this.getLayoutY() + translateY > getParent().getLayoutBounds().getMinY()) {
			this.setTranslateY(translateY);
		}

		event.consume();
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

	public IntegerProperty paneHeightProperty() {
		return this.heightProperty;
	}

	public int getPaneHeight() {
		return heightProperty.get();
	}

	public void setPaneHeight(int height) {
		heightProperty.set(height);
	}

	public IntegerProperty paneWidthProperty() {
		return this.widthProperty;
	}

	public int getPaneWidth() {
		return widthProperty.get();
	}

	public void setPaneWidth(int width) {
		widthProperty.set(width);
	}

}
