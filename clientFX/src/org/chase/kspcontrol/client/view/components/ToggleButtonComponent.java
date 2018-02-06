package org.chase.kspcontrol.client.view.components;

import java.util.List;

import javax.swing.ButtonGroup;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class ToggleButtonComponent extends HBox {
	private List<String> states;
	private ToggleGroup group = new ToggleGroup();
	private StringProperty currentState = new SimpleStringProperty();
	
	public ToggleButtonComponent(String initial, String...states) {
		for (String state : states) {
			ToggleButton button = new ToggleButton(state);
			button.setUserData(state);
			group.getToggles().add(button);
			this.getChildren().add(button);
			if (state.equals(initial)) group.selectToggle(button);
		}
		group.selectedToggleProperty().addListener(new ToggleListener());
	}
	
	private class ToggleListener implements ChangeListener<Toggle> {
		@Override
		public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
			currentState.set((String) newValue.getUserData());
		}
	}

	public StringProperty currentStateProperty() {
		return currentState;
	}
	
	public String getCurrentState() {
		return currentState.get();
	}

	public void setCurrentState(String currentState) {
		this.currentState.set(currentState);
	}
	
	
}
