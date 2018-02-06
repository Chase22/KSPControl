package org.chase.kspcontrol.client.view.panels;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.view.Formats;
import org.chase.kspcontrol.common.KSPResourceBundle;
import org.chase.kspcontrol.common.data.Orbit;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class OrbitPanel extends GridPane implements KSPUpdateHandler<Orbit>, KSPPane {
	
	private KSPResourceBundle bundle = KSPResourceBundle.getBundle("localisation", "client.orbit");
	
	private Label ApoapsisLabel = new Label(bundle.getString("apoapsis") + ": ");
	private TextField ApoapsisField = new TextField();
	private Label TTApoapsisLabel = new Label(String.format("%s %s: ", bundle.getString("timeTo"), bundle.getString("apoapsis")));
	private TextField TTApoapsisField = new TextField();
	
	public OrbitPanel() {
		ClientContext.getInstance().getMQClient().getHandler(new Orbit().getPrefix()).register(this);
		
		ApoapsisField.setEditable(false);
		ApoapsisField.setPrefColumnCount(10);
		ApoapsisField.getStyleClass().add("NumberField");
		
		TTApoapsisField.setEditable(false);
		TTApoapsisField.setPrefColumnCount(10);
		TTApoapsisField.getStyleClass().add("NumberField");
		
		this.add(ApoapsisLabel, 0, 0);
		this.add(ApoapsisField, 1, 0);
		this.add(TTApoapsisLabel, 0, 1);
		this.add(TTApoapsisField, 1, 1);
	}

	public void handle(Orbit object) {
		ApoapsisField.setText(Formats.ufAltitude.format(object.getApoapsisAltitude()));
		TTApoapsisLabel.setText(Formats.formatSec(object.getTimeToApoapsis()));
		
	}

	@Override
	public int getPaneHeight() {
		return 1;
	}

	@Override
	public int getPaneWidth() {
		return 3;
	}
	
	@Override
	public String getTitle() {
		return "Orbit Information";
	}
	
	@Override
	public KSPPane getInstance() {
		return new OrbitPanel();
	}

	@Override
	public void destroy() {
		ClientContext.getInstance().getMQClient().getHandler(new Flight().getPrefix()).unregister(this);
	}
	
}
