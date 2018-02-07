package org.chase.kspcontrol.client;

import java.util.ResourceBundle;

import org.chase.kspcontrol.client.view.RootPane;
import org.chase.kspcontrol.client.view.components.ToggleButtonComponent;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.data.GeneralControl;
import org.chase.kspcontrol.common.data.Orbit;
import org.chase.kspcontrol.common.network.KSPStandardUpdateProvider;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ToggleButtonTest extends Application {
	public static ToggleButtonTest instance;
	
	ResourceBundle bundle;
	
	@Override
	public void start(Stage primaryStage) {
		
		instance = this;
		
		bundle = ResourceBundle.getBundle("localisation");
		//System.out.println(bundle.getString("application.test"));
		try {
			Pane root = new Pane();
			ToggleButtonComponent tbc = new ToggleButtonComponent("test", "test", "test1", "test2");
			root.getChildren().add(tbc);
			
			tbc.currentStateProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					System.out.println(oldValue + " " + newValue);
				}
			});
	
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		launch(args);
	}
}
