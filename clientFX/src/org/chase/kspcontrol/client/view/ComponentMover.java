package org.chase.kspcontrol.client.view;

import java.awt.Dimension;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ComponentMover implements EventHandler<MouseEvent> {
	Dimension bounds;
	Pane parent;
	FloatProperty snapX = new SimpleFloatProperty();
	FloatProperty snapY = new SimpleFloatProperty();
	
	public ComponentMover(Pane parent) {
		this.parent = parent;
		parent.setOnMouseDragged(this);
	}
	
	@Override
	public void handle(MouseEvent event) {
		this.parent.setManaged(false);
		parent.setTranslateX(Math.round(((event.getX() + parent.getTranslateX())/snapX.get()))*snapX.get());
		parent.setTranslateY(Math.round(((event.getY() + parent.getTranslateY())/snapY.get()))*snapY.get());
	    event.consume();
	}

	public FloatProperty snapXProterty() {
		return snapX;
	}

	public float getSnapX() {
		return snapX.get();
	}


	public void setSnapX(float snapX) {
		this.snapX.set(snapX);
	}

	public FloatProperty snapYProterty() {
		return snapY;
	}

	public float getSnapY() {
		return snapY.get();
	}

	public void setSnapY(float snapY) {
		this.snapY.set(snapY);
	}
	
	
	
}
