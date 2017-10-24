package org.chase.kspcontrol.client.view.component;

import java.awt.Color;

public class ToggleLamp extends Lamp {
	
	public ToggleLamp() {
		this.addState("true", Color.GREEN);
		this.addState("false", Color.RED);
	}
	
	public void setState(boolean state) {
		this.setCurrentState(String.valueOf(state));
	}
	
	public boolean getState() {
		return Boolean.getBoolean(getCurrentState());
	}
}
