package org.chase.kspcontrol.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.chase.kspcontrol.client.view.AltitudePanel;
import org.chase.kspcontrol.client.view.ControlFrame;
import org.chase.kspcontrol.common.data.Flight;


public class ClientStarter extends WindowAdapter {
	

	public static void main(String[] args) throws Exception {
		KSPStandardUpdateProvider<Flight> Flighthandler = new KSPStandardUpdateProvider<Flight>(Flight.class);
		
		ClientContext.getInstance().getMQClient().registerHandler(Flighthandler);
		
		ControlFrame Frame = new ControlFrame();
		
		Frame.add(new AltitudePanel());
		Frame.setVisible(true);
	}

}
