package org.chase.kspcontrol.client.view.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.MQClient;
import org.chase.kspcontrol.client.view.ColorIcon;
import org.chase.kspcontrol.client.view.component.ToggleButtonPanel;
import org.chase.kspcontrol.client.view.component.ToggleLamp;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.data.GeneralControl;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;

public class MainControlPanel extends Panel implements KSPUpdateHandler<GeneralControl> {
	
	//JToggleButton btnLight = new JToggleButton("Light");
	//ToggleLamp lamp = new ToggleLamp();
	
	ToggleButtonPanel light = new ToggleButtonPanel("Lights", new GeneralControl().getPrefix(), "lights");
	ToggleButtonPanel gear = new ToggleButtonPanel("Gear", new GeneralControl().getPrefix(), "gear");
	ToggleButtonPanel legs = new ToggleButtonPanel("Legs", new GeneralControl().getPrefix(), "legs");
	ToggleButtonPanel solar = new ToggleButtonPanel("Solarpanels", new GeneralControl().getPrefix(), "solarPanels");
	ToggleButtonPanel radiators = new ToggleButtonPanel("Radiators", new GeneralControl().getPrefix(), "radiators");
	ToggleButtonPanel cargoBays = new ToggleButtonPanel("Cargobays", new GeneralControl().getPrefix(), "cargoBays");
	ToggleButtonPanel antennas = new ToggleButtonPanel("Antennas", new GeneralControl().getPrefix(), "antennas");
	
	public MainControlPanel() {
		super();
		
		GridBagConstraints cons = getConstraint();
		cons.gridwidth = 4;
		cons.gridheight = 4;
		setConstraint(cons);
		
		ClientContext.getInstance().getMQClient().getHandler(new GeneralControl().getPrefix()).register(this);
		
		this.setLayout(new GridLayout(4, 2));

		this.add(light);
		this.add(gear);
		//this.add(legs);
		this.add(solar);
		this.add(radiators);
		this.add(cargoBays);
		this.add(antennas);
		
	}

	public void handle(GeneralControl object) {
		light.setState(object.isLights());
		gear.setState(object.isGear());
		legs.setState(object.isLegs());
		solar.setState(object.isSolarpanels());
		radiators.setState(object.isRadiators());
		cargoBays.setState(object.isCargobays());
		antennas.setState(object.isAntennas());
	}

}
