package org.chase.kspcontrol.client.view.components;


import java.util.HashMap;

import javax.swing.JPanel;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Lamp extends Pane{
	static final Paint COLOR_INVALID = Color.GRAY;
	
	private HashMap<String, Color> states = new HashMap<String, Color>();
	
	private String currentState;
	
	public Lamp() {
		this.setPrefSize(50, 50);
	}

	/**
	 * @return the currentState
	 */
	public String getCurrentState() {
		return currentState;
	}

	/**
	 * @param currentState the currentState to set
	 */
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
		Paint fill = states.get(currentState);
		if (fill == null) fill = COLOR_INVALID;
		
		this.setBackground(new Background(new BackgroundFill(fill, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void addState(String key, Color color) {
		states.put(key, color);
	}
	
	public void deleteState(String key) {
		states.remove(key);
	}
	
	public Color getState(String key) {
		return states.get(key);
	}
	
}
