package org.chase.kspcontrol.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import org.chase.kspcontrol.client.view.ControlFrame;
import org.chase.kspcontrol.client.view.panel.AltitudePanel;
import org.chase.kspcontrol.client.view.panel.MainControlPanel;
import org.chase.kspcontrol.client.view.panel.OrbitPanel;
import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.data.GeneralControl;
import org.chase.kspcontrol.common.data.Orbit;
import org.chase.kspcontrol.common.network.KSPStandardUpdateProvider;


public class ClientStarter extends WindowAdapter {
	

	public static void main(String[] args) throws Exception {
		KSPStandardUpdateProvider<Flight> Flighthandler = new KSPStandardUpdateProvider<Flight>(Flight.class);
		KSPStandardUpdateProvider<Orbit> OrbitHandler = new KSPStandardUpdateProvider<Orbit>(Orbit.class);
		KSPStandardUpdateProvider<GeneralControl> ControlHandler = new KSPStandardUpdateProvider<GeneralControl>(GeneralControl.class);
		
		ClientContext.getInstance().getMQClient().registerHandler(Flighthandler);
		ClientContext.getInstance().getMQClient().registerHandler(OrbitHandler);
		ClientContext.getInstance().getMQClient().registerHandler(ControlHandler);
		
		
		ControlFrame Frame = new ControlFrame();
		
		Frame.add(new AltitudePanel());
		Frame.add(new OrbitPanel());
		Frame.add(new MainControlPanel());
		Frame.setVisible(true);
	}

}
