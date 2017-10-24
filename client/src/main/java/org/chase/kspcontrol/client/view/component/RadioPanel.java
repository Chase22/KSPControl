package org.chase.kspcontrol.client.view.component;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.chase.kspcontrol.client.ClientContext;

public class RadioPanel extends JPanel implements ActionListener{
	private List<String> states = new ArrayList<String>();
	
	ButtonGroup group;
	
	private String boundMethod;
	private String boundPrefix;
	
	private String current;
	
	public RadioPanel(String boundPrefix, String boundMethod) {
		this.setLayout(new FlowLayout());
		this.boundMethod = boundMethod;
		this.boundPrefix = boundPrefix;
	}
	
	public void addState(String state) {
		states.add(state);
		JRadioButton button = new JRadioButton(state);
		button.setActionCommand(state);
		group.add(button);
		this.add(button);
	}
	
	public void removeState(String state) {
		states.remove(state);
	}
	
	private void update() {
	}

	public void actionPerformed(ActionEvent e) {
		ClientContext.getInstance().getMQClient().send(getBoundPrefix(), getBoundMethod(), e.getActionCommand());
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
	
	
}
