package org.chase.kspcontrol.client.view.panels;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.view.components.TextFieldGridComponent;
import org.chase.kspcontrol.client.view.formats.Formats;
import org.chase.kspcontrol.client.view.formats.HeightTextConverter;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AltiudePanel extends GridPane implements KSPUpdateHandler<Flight>, KSPPane {

	TextFieldGridComponent<Double> AltiudeComponent;
	TextFieldGridComponent<Double> SrfcAltitudeComponent;
	
	public AltiudePanel() {
		ClientContext.getInstance().getMQClient().getHandler(new Flight().getPrefix()).register(this);
		
		AltiudeComponent = new TextFieldGridComponent<>(this, 0, "Altiude: ", new HeightTextConverter());
		SrfcAltitudeComponent = new TextFieldGridComponent<>(this, 1, "Surface Altitude: ", new HeightTextConverter());
	}

	public void handle(Flight object) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				AltiudeComponent.setText(object.getMeanAltitude());
				SrfcAltitudeComponent.setText(object.getSurfaceAltitude());
			}
		});
		
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
		return "Altiude Information";
	}

	@Override
	public KSPPane getInstance() {
		return new AltiudePanel();
	}

	@Override
	public void destroy() {
		ClientContext.getInstance().getMQClient().getHandler(new Flight().getPrefix()).unregister(this);
	}
	
	
}
