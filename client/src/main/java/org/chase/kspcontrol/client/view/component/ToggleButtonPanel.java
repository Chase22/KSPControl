package org.chase.kspcontrol.client.view.component;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import org.chase.kspcontrol.client.ClientContext;

public class ToggleButtonPanel extends Box {
	private ToggleLamp lamp;
	private JToggleButton buttonTrue = new JToggleButton("On");
	private JToggleButton buttonFalse = new JToggleButton("Off");
	
	private String boundMethod;
	private String boundPrefix;
	
	private JLabel label = new JLabel();
	
	public ToggleButtonPanel(String label, String boundPrefix, String boundMethod) {
		super(BoxLayout.Y_AXIS);
		
		this.boundMethod = boundMethod;
		this.boundPrefix = boundPrefix;
		
		JPanel LampPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		buttonTrue.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ClientContext.getInstance().getMQClient().send(getBoundPrefix(), getBoundMethod(), true);
				buttonTrue.setEnabled(false);
				buttonFalse.setEnabled(true);
			}
		});
		
		buttonFalse.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ClientContext.getInstance().getMQClient().send(getBoundPrefix(), getBoundMethod(), false);
				buttonTrue.setEnabled(true);
				buttonFalse.setEnabled(false);
			}
		});
		
		this.label.setText(label);
		
		lamp = new ToggleLamp();
		LampPanel.add(lamp);
		ButtonPanel.add(buttonTrue);
		ButtonPanel.add(buttonFalse);
		
		this.add(this.label);
		this.add(LampPanel);
		this.add(ButtonPanel);
	}
	/**
	 * @return the state
	 */
	public boolean isState() {
		System.out.println(String.valueOf(lamp.getState()));
		return lamp.getState();
	}

	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		lamp.setState(state);
		buttonTrue.setSelected(state);
		buttonFalse.setSelected(!state);
		buttonTrue.setEnabled(!state);
		buttonFalse.setEnabled(state);
	}
	/**
	 * @return the boundMethod
	 */
	public String getBoundMethod() {
		return boundMethod;
	}
	/**
	 * @param boundMethod the boundMethod to set
	 */
	public void setBoundMethod(String boundMethod) {
		this.boundMethod = boundMethod;
	}
	/**
	 * @return the boundPrefix
	 */
	public String getBoundPrefix() {
		return boundPrefix;
	}
	/**
	 * @param boundPrefix the boundPrefix to set
	 */
	public void setBoundPrefix(String boundPrefix) {
		this.boundPrefix = boundPrefix;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label.getText();
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label.setText(label);
	}
	
	
}
