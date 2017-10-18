package org.chase.kspcontrol.client.view.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.UIManager;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.MQClient;
import org.chase.kspcontrol.client.view.ColorIcon;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.data.GeneralControl;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;

public class MainControlPanel extends Panel implements KSPUpdateHandler<GeneralControl> {
	
	JToggleButton btnLight = new JToggleButton("Light");
	
	Color bgTrue = Color.GREEN;
	Color bgFalse = Color.RED;
	
	public MainControlPanel() {
		super();
		
		GridBagConstraints cons = getConstraint();
		cons.gridwidth = 1;
		cons.gridheight = 1;
		setConstraint(cons);
		
		ClientContext.getInstance().getMQClient().getHandler(new GeneralControl().getPrefix()).register(this);
		
		btnLight.setPreferredSize(new Dimension(100, 100));
		
		btnLight.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ClientContext.getInstance().getMQClient().send(new GeneralControl().getPrefix(), "lights", btnLight.isSelected());
			}
		});
		
		btnLight.setIcon(new ColorIcon(20, 20, bgFalse));
		btnLight.setSelectedIcon(new ColorIcon(20, 20, bgTrue));

		this.add(btnLight);
	}

	public void handle(GeneralControl object) {
		btnLight.setSelected(object.isLights());
	}

}
