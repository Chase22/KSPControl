package org.chase.kspcontrol.client.view.components;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ToggleComponent extends HBox {
	private String boundMethod;
	private String boundPrefix;
	
	private ToggleLamp lamp;
	private Label label;
	
	public ToggleComponent(String boundPrefix, String boundMethod, String label) {
		super(7);
		this.label = new Label(label);
		this.boundMethod = boundMethod;
		this.boundPrefix = boundPrefix;
		
		lamp = new ToggleLamp();
		lamp.setCurrentState(true);
		
		this.getChildren().add(this.label);
		this.getChildren().add(lamp);
	}
	
}
