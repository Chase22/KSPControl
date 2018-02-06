package org.chase.kspcontrol.client.view.subviews;


import org.chase.kspcontrol.client.view.RootPane;
import org.chase.kspcontrol.client.view.panels.AltiudePanel;
import org.chase.kspcontrol.client.view.panels.GeneralControlPanel;
import org.chase.kspcontrol.client.view.panels.KSPPane;
import org.chase.kspcontrol.client.view.panels.OrbitPanel;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class PaneListPanel extends BorderPane {
	private ListView<KSPPane> list;
	private ObservableList<KSPPane> items;
	private Button addButton = new Button("add");
	private ToggleButton hideButton = new ToggleButton();
	
	private RootPane parent;
	
	public PaneListPanel(RootPane parent) {
		items = FXCollections.observableArrayList();
		
		items.add(new OrbitPanel());
		items.add(new GeneralControlPanel());
		items.add(new AltiudePanel());
		
		list = new ListView<>(items);
		list.setCellFactory(new CellFactoryCallback());
		list.getSelectionModel().select(0);
		
		AddButtonHandler addHandler = new AddButtonHandler();
		addButton.setOnAction(addHandler);
		list.setOnMouseClicked(new ListMouseHandler(addHandler));
		
		this.parent = parent;
		
		addButton.visibleProperty().bind(list.visibleProperty());
		addButton.managedProperty().bind(list.visibleProperty());
		list.managedProperty().bind(list.visibleProperty());
		
		hideButton.selectedProperty().bindBidirectional(list.visibleProperty());
		hideButton.selectedProperty().addListener(new HideButtonChangeListener());
		new HideButtonChangeListener().changed(list.visibleProperty(), false, true);

		hideButton.setPrefHeight(200);
		hideButton.setPadding(new Insets(2));
		
		VBox centerBox = new VBox(list, addButton);
		centerBox.prefHeightProperty().bind(this.heightProperty());
		setCenter(centerBox);
		
		list.prefHeightProperty().bind(centerBox.heightProperty());
		
		VBox box = new VBox(hideButton);
		box.setAlignment(Pos.CENTER);
		setLeft(box);
	}

	
	
	//handlers
	private class AddButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			parent.getGridPane().addPane(list.getSelectionModel().getSelectedItem().getInstance(), parent.getMenuBar().heightProperty());
		}
	}
	
	private class ListMouseHandler implements EventHandler<MouseEvent> {
		private AddButtonHandler addHandler;
		
		public ListMouseHandler(AddButtonHandler addHandler) {
			this.addHandler = addHandler;
		}
		
		@Override
		public void handle(MouseEvent event) {
			if (event.getClickCount() == 2) {
				addHandler.handle(new ActionEvent(event.getSource(), event.getTarget()));
			}
		}
	}
	
	private class CellFactoryCallback implements Callback<ListView<KSPPane>, ListCell<KSPPane>> {
		@Override
		public ListCell<KSPPane> call(ListView<KSPPane> param) {
			return new PaneCell();
		}
	}
	
	private class HideButtonChangeListener implements ChangeListener<Boolean> {
		@Override
		public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
			hideButton.setText(newValue ? "▶" : "◀");
		}

	}
}
