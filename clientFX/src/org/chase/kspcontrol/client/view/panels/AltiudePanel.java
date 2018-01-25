package org.chase.kspcontrol.client.view.panels;

import java.awt.Color;

import javax.swing.border.LineBorder;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.view.ComponentMover;
import org.chase.kspcontrol.client.view.Formats;
import org.chase.kspcontrol.client.view.components.TextFieldComponent;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class AltiudePanel extends GridPane implements KSPUpdateHandler<Flight>, KSPPane {
	
	Label AltitudeLabel = new Label("Altiude:");
	TextField AltitudeField = new TextField();
	Label SrfcAltitudeLabel = new Label("Surface Altitude:");
	TextField SrfcAltitudeField = new TextField();
	
	public AltiudePanel() {
		ClientContext.getInstance().getMQClient().getHandler(new Flight().getPrefix()).register(this);
		
		AltitudeField.setEditable(false);
		SrfcAltitudeField.setEditable(false);
		
		this.add(AltitudeLabel, 0, 0);
		this.add(AltitudeField, 1, 0);
		this.add(SrfcAltitudeLabel, 0, 1);
		this.add(SrfcAltitudeField, 1, 1);

	}

	public void handle(Flight object) {
		AltitudeField.setText(Formats.ufAltitude.format(object.getMeanAltitude()));
		SrfcAltitudeField.setText(Formats.ufAltitude.format(object.getSurfaceAltitude()));
	}

	@Override
	public int getPaneHeight() {
		return 1;
	}

	@Override
	public int getPaneWidth() {
		return 2;
	}
	
	
}
