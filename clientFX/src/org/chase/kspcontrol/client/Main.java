package org.chase.kspcontrol.client;
	
import java.util.ResourceBundle;

import org.chase.kspcontrol.client.view.RootPane;
import org.chase.kspcontrol.client.view.components.ToggleComponent;
import org.chase.kspcontrol.client.view.panels.AltiudePanel;
import org.chase.kspcontrol.client.view.panels.GeneralControlPanel;
import org.chase.kspcontrol.client.view.panels.MoveablePane;
import org.chase.kspcontrol.client.view.panels.OrbitPanel;
import org.chase.kspcontrol.client.view.subviews.PaneListPanel;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.data.GeneralControl;
import org.chase.kspcontrol.common.data.Orbit;
import org.chase.kspcontrol.common.network.KSPStandardUpdateProvider;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	public static Main instance;
	
	ResourceBundle bundle;
	
	@Override
	public void start(Stage primaryStage) {
		
		instance = this;
		
		bundle = ResourceBundle.getBundle("localisation");
		//System.out.println(bundle.getString("application.test"));
		try {
			RootPane root = new RootPane();

			root.getGridPane().setGridSize(100);
	
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Kerbal Mission Control");
			
			primaryStage.setOnCloseRequest(event -> {
				ClientContext.getInstance().close();
			});
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		KSPStandardUpdateProvider<Flight> Flighthandler = new KSPStandardUpdateProvider<Flight>(Flight.class);
		KSPStandardUpdateProvider<Orbit> OrbitHandler = new KSPStandardUpdateProvider<Orbit>(Orbit.class);
		KSPStandardUpdateProvider<GeneralControl> ControlHandler = new KSPStandardUpdateProvider<GeneralControl>(GeneralControl.class);
		
		ClientContext.getInstance().getMQClient().registerHandler(Flighthandler);
		ClientContext.getInstance().getMQClient().registerHandler(OrbitHandler);
		ClientContext.getInstance().getMQClient().registerHandler(ControlHandler);
		launch(args);
	}
}
