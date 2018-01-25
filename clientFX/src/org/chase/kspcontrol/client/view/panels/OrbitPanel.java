package org.chase.kspcontrol.client.view.panels;

import java.util.ResourceBundle;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.view.Formats;
import org.chase.kspcontrol.common.KSPResourceBundle;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.data.Orbit;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class OrbitPanel extends GridPane implements KSPUpdateHandler<Orbit>, KSPPane {
	
	KSPResourceBundle bundle = KSPResourceBundle.getBundle("localisation", "client.orbit");
	
	Label ApoapsisLabel = new Label(bundle.getString("apoapsis"));
	TextField ApoapsisField = new TextField();
	
	public OrbitPanel() {
		ClientContext.getInstance().getMQClient().getHandler(new Flight().getPrefix()).register(this);
		
		ApoapsisField.setEditable(false);
		
		this.add(ApoapsisLabel, 0, 0);
		this.add(ApoapsisField, 1, 0);
	}

	public void handle(Orbit object) {
		ApoapsisField.setText(Formats.ufAltitude.format(object.getApoapsis()));
	}

	@Override
	public int getPaneHeight() {
		return 1;
	}

	@Override
	public int getPaneWidth() {
		return 3;
	}
	
	
}
