package org.chase.kspcontrol.client.view.panels;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.view.components.TextFieldGridComponent;
import org.chase.kspcontrol.client.view.formats.HeightTextConverter;
import org.chase.kspcontrol.client.view.formats.SpeedTextConverter;
import org.chase.kspcontrol.client.view.formats.TimeTextConverter;
import org.chase.kspcontrol.common.KSPResourceBundle;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.data.Orbit;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;

import javafx.application.Platform;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class OrbitPanel extends GridPane implements KSPUpdateHandler<Orbit>, KSPPane {
	
	private KSPResourceBundle bundle = KSPResourceBundle.getBundle("localisation", "client.orbit");
	
	private TextFieldGridComponent<String> BodyNameComponent;
	
	private TextFieldGridComponent<Double> ApoapsisComponent;
	private TextFieldGridComponent<Double> TTApoapsisComponent;
	
	private TextFieldGridComponent<Double> PeriapsisComponent;
	private TextFieldGridComponent<Double> TTPeriapsisComponent;
	
	private TextFieldGridComponent<Double> SemiMajorAxisComponent;
	private TextFieldGridComponent<Double> SemiMinorAxisComponent;
	
	private TextFieldGridComponent<Double> SpeedComponent;
	private TextFieldGridComponent<Double> PerdiodComponent;
	
	private TextFieldGridComponent<Double> EccentricityComponent;
	private TextFieldGridComponent<Double> InclinationComponent;
	

	public OrbitPanel() {
		ClientContext.getInstance().getMQClient().getHandler(new Orbit().getPrefix()).register(this);
		
		BodyNameComponent = new TextFieldGridComponent<>(this, 0, bundle.getString("client.planet", "name"));
		BodyNameComponent.addTextFieldStyleClass("TextField");
		
		ApoapsisComponent = new TextFieldGridComponent<>(this, 1, bundle.getString("apoapsis") + ": ", new HeightTextConverter());
		ApoapsisComponent.addTextFieldStyleClass("TextField");
		ApoapsisComponent.addTextFieldStyleClass("NumberField");
		
		TTApoapsisComponent = new TextFieldGridComponent<>(this, 2, String.format("%s %s: ", bundle.getString("timeTo"), bundle.getString("apoapsis")), new TimeTextConverter());
		TTApoapsisComponent.addTextFieldStyleClass("TextField");
		TTApoapsisComponent.addTextFieldStyleClass("NumberField");
		
		PeriapsisComponent = new TextFieldGridComponent<>(this, 3, bundle.getString("periapsis") + ": ", new HeightTextConverter());
		PeriapsisComponent.addTextFieldStyleClass("TextField");
		PeriapsisComponent.addTextFieldStyleClass("NumberField");
		
		TTPeriapsisComponent = new TextFieldGridComponent<>(this, 4, String.format("%s %s: ", bundle.getString("timeTo"), bundle.getString("periapsis")), new TimeTextConverter());
		TTPeriapsisComponent.addTextFieldStyleClass("TextField");
		TTPeriapsisComponent.addTextFieldStyleClass("NumberField");
		
		SemiMajorAxisComponent = new TextFieldGridComponent<>(this, 5, bundle.getString("semiMajorAxis"), new HeightTextConverter());
		SemiMajorAxisComponent.addTextFieldStyleClass("TextField");
		SemiMajorAxisComponent.addTextFieldStyleClass("NumberField");
		
		SemiMinorAxisComponent = new TextFieldGridComponent<>(this, 6, bundle.getString("semiMinorAxis"), new HeightTextConverter());
		SemiMinorAxisComponent.addTextFieldStyleClass("TextField");
		SemiMinorAxisComponent.addTextFieldStyleClass("NumberField");
		
		SpeedComponent = new TextFieldGridComponent<>(this, 7, bundle.getString("speed"), new SpeedTextConverter());
		SpeedComponent.addTextFieldStyleClass("TextField");
		SpeedComponent.addTextFieldStyleClass("NumberField");
		
		PerdiodComponent = new TextFieldGridComponent<>(this, 8, bundle.getString("period"), new TimeTextConverter());
		PerdiodComponent.addTextFieldStyleClass("TextField");
		PerdiodComponent.addTextFieldStyleClass("NumberField");
		
		EccentricityComponent = new TextFieldGridComponent<>(this, 9, bundle.getString("eccentricity"));
		EccentricityComponent.addTextFieldStyleClass("TextField");
		EccentricityComponent.addTextFieldStyleClass("NumberField");
		
		InclinationComponent = new TextFieldGridComponent<>(this, 10, bundle.getString("inclination"));
		InclinationComponent.addTextFieldStyleClass("TextField");
		InclinationComponent.addTextFieldStyleClass("NumberField");
		
		this.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, null)));
	}

	public void handle(Orbit object) {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				//BodyNameComponent.setText(object.getBody);
				ApoapsisComponent.setText(object.getApoapsisAltitude());
				TTApoapsisComponent.setText(object.getTimeToApoapsis());
				PeriapsisComponent.setText(object.getPeriapsisAltitude());
				TTPeriapsisComponent.setText(object.getTimeToPeriapsis());
				SemiMajorAxisComponent.setText(object.getSemiMajorAxis());
				SemiMinorAxisComponent.setText(object.getSemiMinorAxis());
				SpeedComponent.setText(object.getSpeed());
				PerdiodComponent.setText(object.getPeriod());
				EccentricityComponent.setText(object.getEccentricity());
				InclinationComponent.setText(object.getInclination());
			}
		});
		
	}

	@Override
	public int getPaneHeight() {
		return 2;
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
