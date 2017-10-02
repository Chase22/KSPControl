package org.chase.kspcontrol.client.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PopupMenu;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.JPanel;

/**
 * This Class represents a GUI Panel with static cell and grid size where
 * components can be moved over the grid. Every Component on the Grid should be
 * a subclass of @see Panel
 * 
 * @author lukas
 *
 */
public class GridPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8826031749433149812L;
	ComponentMover cm;
	private int gridX;
	private int gridY;

	public GridPanel(int gridSize, int gridX, int gridY) {
		cm = new ComponentMover();
		cm.setSnapSize(new Dimension(gridSize, gridSize));
		this.gridX = gridX;
		this.gridY = gridY;
		this.setSize(getPreferredSize());

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				repaint();
			}
		});

		this.addContainerListener(new ContainerListener() {

			public void componentRemoved(ContainerEvent e) {
				cm.registerComponent(e.getComponent());
			}

			public void componentAdded(ContainerEvent e) {
				cm.deregisterComponent(e.getComponent());
			}
		});
	}

	public int getGridX() {
		return gridX;
	}

	public void setGridX(int gridX) {
		this.gridX = gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public void setGridY(int gridY) {
		this.gridY = gridY;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(gridX * getGridSize() + 50, gridY * getGridSize() + 50);
	}

	public int getGridSize() {
		return cm.getSnapSize().height;
	}

	/**
	 * Adds A component to the grid and registers it to the ComponentMover
	 * 
	 * @param comp
	 *            A Panel of type {@link Panel}
	 * @return the added Component
	 * @see Panel
	 */
	public Panel add(Panel comp) {
		super.add(comp);
		// cm.registerComponent(comp);
		return comp;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		/*
		 * g.setColor(Color.black); for (int i = 0; i < gridX; i++) { for (int j = 0; j
		 * < gridY; j++) { g.drawRect(i * getGridSize() + 20, j * getGridSize() + 20,
		 * getGridSize(), getGridSize()); } }
		 */
	}

}
