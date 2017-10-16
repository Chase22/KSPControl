package org.chase.kspcontrol.client.view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.math.RoundingMode;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.ClientStarter;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;
import org.javatuples.Pair;

import com.amjjd.unitformat.UnitFormat;

public class AltitudePanel extends Panel implements KSPUpdateHandler<Flight> {
	JTextField AltitudeField = new JTextField();
	JTextField SrfcAltitudeField = new JTextField();
	
	public AltitudePanel() {
		super();
		this.setLayout(new FlowLayout());
		
		GridBagConstraints cons = getConstraint();
		cons.gridwidth = 3;
		cons.gridheight = 1;
		setConstraint(cons);
		
		ClientContext.getInstance().getMQClient().getHandler(new Flight().getPrefix()).register(this);
		
		addTextField("Altitude: ", AltitudeField);
		addTextField("Surface Altitude: ", SrfcAltitudeField);
	}

	public void handle(Flight object) {
		AltitudeField.setText(Formats.ufAltitude.format(object.getMeanAltitude()));
		SrfcAltitudeField.setText(Formats.ufAltitude.format(object.getSurfaceAltitude()));
	}
	
	private void addTextField (String label, JTextField field) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		field.setColumns(8);
		field.setEditable(false);
		field.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(new JLabel(label));
		panel.add(field);
		
		this.add(panel);
	}
}
