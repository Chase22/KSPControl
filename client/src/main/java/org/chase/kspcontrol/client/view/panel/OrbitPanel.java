package org.chase.kspcontrol.client.view.panel;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.Normalizer.Form;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.ClientStarter;
import org.chase.kspcontrol.client.view.Formats;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.data.Orbit;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;
import org.javatuples.Pair;

import com.amjjd.unitformat.UnitFormat;

public class OrbitPanel extends Panel implements KSPUpdateHandler<Orbit> {
	JTextField ApoapsisField = new JTextField();
	JTextField ApoapsisTimeField = new JTextField();
	JTextField PeriapsisField = new JTextField();
	JTextField PeriapsisTimeField = new JTextField();
	JTextField EccentricityField = new JTextField();

	public OrbitPanel() {
		super();
		this.setLayout(new FlowLayout());
		
		GridBagConstraints cons = getConstraint();
		cons.gridwidth = 4;
		cons.gridheight = 2;
		setConstraint(cons);
		
		ClientContext.getInstance().getMQClient().getHandler(new Orbit().getPrefix()).register(this);
		
		addTextField("Apoapsis", ApoapsisField);
		addTextField("Time to Apoapsis", ApoapsisTimeField);
		addTextField("Periapsis", PeriapsisField);
		addTextField("Time to Periapsis", PeriapsisTimeField);
		
		addTextField("Eccentricity", EccentricityField);

	}

	public void handle(Orbit object) {
		ApoapsisField.setText(Formats.ufAltitude.format(object.getApoapsisAltitude()));
		ApoapsisTimeField.setText(Formats.formatSec(object.getTimeToApoapsis()));
		PeriapsisField.setText(Formats.ufAltitude.format(object.getPeriapsisAltitude()));
		PeriapsisTimeField.setText(Formats.formatSec(object.getTimeToPeriapsis()));
		EccentricityField.setText(String.format("%.4f", object.getEccentricity()));
	}
	
	private void addTextField (String label, JTextField field) {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		field.setColumns(10);
		field.setEditable(false);
		field.setHorizontalAlignment(JTextField.RIGHT);
		panel.add(new JLabel(label + ": "));
		panel.add(field);
		
		this.add(panel);
	}
}
