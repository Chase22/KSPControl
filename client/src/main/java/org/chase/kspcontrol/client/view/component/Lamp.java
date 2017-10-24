package org.chase.kspcontrol.client.view.component;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.JPanel;

public class Lamp extends JPanel{
	static final Color COLOR_INVALID = Color.GRAY;
	
	private HashMap<String, Color> states = new HashMap<String, Color>();
	
	private String currentState;

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
		this.repaint();
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
	
	@Override
	public void paint(Graphics g) {
		Color fill = states.get(currentState);
		if (fill == null) fill = COLOR_INVALID;
		
		g.setColor(fill);
		g.fillOval(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.BLACK);
		g.drawOval(0, 0, this.getWidth(), this.getHeight());
	}
	
	
}
