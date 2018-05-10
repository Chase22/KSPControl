package org.chase.kspcontrol.client.view.components;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

public class TextFieldGridComponent<T> {
	private Label Label = new Label();
	private Label Field = new Label();
	private ObjectProperty<StringConverter<T>> TextConverterProperty = new SimpleObjectProperty<>();
	private StringProperty FieldTextProperty = new SimpleStringProperty();
	private StringProperty LabelTextProperty = new SimpleStringProperty();
	
	public TextFieldGridComponent(GridPane parent, int rowIndex) {
		parent.addRow(rowIndex, Label, Field);
		
		Field.textProperty().bind(FieldTextProperty);
		Label.textProperty().bind(LabelTextProperty);
	}
	
	public TextFieldGridComponent(GridPane parent, int rowIndex, StringConverter<T> converter) {
		this(parent, rowIndex);
		
		setTextConverter(converter);
	}
	
	public TextFieldGridComponent(GridPane parent, int rowIndex, String label) {
		this(parent, rowIndex);
		setLabel(label);
	}
	
	public TextFieldGridComponent(GridPane parent, int rowIndex, String label, StringConverter<T> converter) {
		this(parent, rowIndex, converter);
		setLabel(label);
	}
	
	public void setLabel(String text) {
		LabelTextProperty.set(text);
	}

	public String getLabel() {
		return LabelTextProperty.get();
	}

	public void setText(T value) {
		if (getTextFormatter() == null) {
			FieldTextProperty.set(value.toString());
		} else {
			FieldTextProperty.set(getTextFormatter().toString(value));	
		}
	}
	
	public void setText(String value) {
		FieldTextProperty.set(value);	
	}

	public String getText() {
		return FieldTextProperty.get();
	}
	
	public StringProperty TextProperty() {
		return FieldTextProperty;
	}

	public void setTextConverter(StringConverter<T> formatter) {
		TextConverterProperty.set(formatter);
	}
	
	public StringConverter<T> getTextFormatter() {
		return TextConverterProperty.get();
	}
	
	public ObjectProperty<StringConverter<T>> TextConverterProperty() {
		return TextConverterProperty;
	}
	
	public void addTextFieldStyleClass(String...classes) {
		Field.getStyleClass().addAll(classes);
	}
	
	public void addLabelFieldStyleClass(String...classes) {
		Label.getStyleClass().addAll(classes);
	}

}
