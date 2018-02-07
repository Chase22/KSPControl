package org.chase.kspcontrol.client.view.components;

import org.chase.kspcontrol.client.ClientContext;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ToggleComponent extends VBox implements ChangeListener<String> {
	private String boundMethod;
	private String boundPrefix;
	
	private ToggleLamp lamp;
	private ToggleButtonComponent tbc;
	private Label label;
	
	public ToggleComponent(String label, String boundPrefix, String boundMethod, boolean initial) {
		super();
		this.boundMethod = boundMethod;
		this.boundPrefix = boundPrefix;
		
		lamp = new ToggleLamp(label);
		lamp.setCurrentState(initial);
		
		tbc = new ToggleButtonComponent(String.valueOf(initial), "true", "false");
		tbc.currentStateProperty().addListener(this);
		
		lamp.currentStateProperty().bind(tbc.currentStateProperty());
		
		this.getChildren().add(lamp);
		this.getChildren().add(tbc);
	}

	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		ClientContext.getInstance().getMQClient().send(boundPrefix, boundMethod, Boolean.parseBoolean(newValue));
	}
	
	public boolean getCurrentState() {
		return Boolean.parseBoolean(tbc.getCurrentState());
	}
	
	public void setCurrentState(boolean state) {
		tbc.setCurrentState(String.valueOf(state));
	}
	
}
