package org.chase.kspcontrol.client.view.components;


import java.awt.Font;
import java.util.HashMap;

import javax.swing.JPanel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Lamp extends StackPane implements ChangeListener<String>{
	static final Color COLOR_INVALID = Color.GRAY;
	
	private HashMap<String, Color> states = new HashMap<String, Color>();
	
	private Label text = new Label();
	
	private StringProperty currentState = new SimpleStringProperty();
	
	public Lamp() {
		this.setPrefSize(50, 50);
	}
	
	public Lamp(String label) {
		text.setText(label.toUpperCase());
		text.setFont(new javafx.scene.text.Font(10));
		text.setStyle("-fx-font-weight: bold;");
		
		text.setText(label.toUpperCase());
		this.getChildren().add(text);
		this.setPrefSize(50, 50);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
		
		currentState.addListener(this);
	}

	public StringProperty currentStateProperty() {
		return currentState;
	}
	
	/**
	 * @return the currentState
	 */
	public String getCurrentState() {
		return currentState.get();
	}

	/**
	 * @param currentState the currentState to set
	 */
	public void setCurrentState(String currentState) {
		this.currentState.set(currentState);
	}
	
	public void addState(String key, Color color) {
		states.put(key, color);
	}
	
	public void deleteState(String key) {
		states.remove(key);
	}
	
	public Color getState(String key) {
		return states.get(key);
	}
	
	public Paint getTextColor(Color background) {
		if (background.getBrightness() > 0.6) {
			return Color.BLACK;
		} else {
			return Color.BLACK;
		}
	}

	@Override
	public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		Color fill = states.get(newValue);
		if (fill == null) fill = COLOR_INVALID;
		
		this.setBackground(new Background(new BackgroundFill(fill, new CornerRadii(0), Insets.EMPTY)));
		text.setTextFill(getTextColor(fill));
	}
	
}
