package org.chase.kspcontrol.client.view.components;

import javafx.scene.paint.Color;

public class ToggleLamp extends Lamp {

	public ToggleLamp() {
		super();
		defaultStates();
	}
	
	public ToggleLamp(String label) {
		super(label);
		defaultStates();
	}
	
	private void defaultStates() {
		this.addState("true", Color.GREEN);
		this.addState("false", Color.RED);
	}

	public void setCurrentState(boolean state) {
		super.setCurrentState(String.valueOf(state));
	}
	
	public boolean getState() {
		return Boolean.getBoolean(getCurrentState());
	}
}
