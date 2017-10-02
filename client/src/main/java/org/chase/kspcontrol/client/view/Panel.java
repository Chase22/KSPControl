package org.chase.kspcontrol.client.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Box.Filler;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import org.omg.PortableServer.ServantRetentionPolicyOperations;

public abstract class Panel extends JPanel {
	public static final int STANDARD_SIZE = 200;

	private GridBagConstraints constraint = new GridBagConstraints();

	public Panel() {
		constraint.fill = GridBagConstraints.BOTH;
		setBorder(new LineBorder(Color.GRAY));
		//this.addMouseMotionListener(new MouseListener());
	}

	public GridBagConstraints getConstraint() {
		return constraint;
	}

	public void setConstraint(GridBagConstraints constraint) {
		this.constraint = constraint;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(constraint.gridwidth * STANDARD_SIZE, constraint.gridheight * STANDARD_SIZE);
	}

	protected class MouseListener implements MouseMotionListener {

		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		public void mouseDragged(MouseEvent e) {
			setLocation(e.getPoint());

		}

		public void mouseMoved(MouseEvent e) {
			

		}
	}

}
