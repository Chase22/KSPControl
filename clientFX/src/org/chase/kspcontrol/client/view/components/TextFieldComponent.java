package org.chase.kspcontrol.client.view.components;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TextFieldComponent extends HBox {
	TextField textfield = new TextField();
	Label label = new Label();

	public TextFieldComponent() {
		this.getChildren().addAll(label, textfield);
	}

	public TextFieldComponent(String label) {
		this();
		setLabel(label);
	}

	public TextFieldComponent(boolean editable) {
		this();
		setEditable(editable);
	}

	public TextFieldComponent(String label, boolean editable) {
		this(label);
		setEditable(editable);
	}

	public void setLabel(String text) {
		label.setText(text);
	}

	public String getLabel() {
		return label.getText();
	}

	public void setText(String text) {
		textfield.setText(text);
	}

	public String getText() {
		return textfield.getText();
	}

	public void setEditable(boolean editable) {
		textfield.setEditable(editable);
	}

	public boolean isEditable() {
		return !textfield.isEditable();
	}
}
