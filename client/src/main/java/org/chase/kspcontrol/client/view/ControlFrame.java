package org.chase.kspcontrol.client.view;

import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.ClientStarter;

public class ControlFrame extends JFrame {
	private GridPanel grid;

	public ControlFrame() {

		grid = new GridPanel(100, 16, 8);
		
		setLayout(new GridBagLayout());

		add(grid);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ClientContext.getInstance().close();
			}
		});

	}

	public void add(Panel panel) {
		this.grid.add(panel);
	}
}
