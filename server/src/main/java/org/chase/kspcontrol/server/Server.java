package org.chase.kspcontrol.server;

import java.io.IOException;
import java.util.List;

import org.chase.kspcontrol.common.NotInitialisedException;
import org.chase.kspcontrol.common.data.GeneralControl;
import org.chase.kspcontrol.common.data.parts.PartsContainer;

import javafx.scene.shape.CircleBuilder;
import krpc.client.Connection;
import krpc.client.RPCException;
import krpc.client.Stream;
import krpc.client.StreamException;
import krpc.client.services.KRPC;
import krpc.client.services.SpaceCenter;
import krpc.client.services.KRPC.GameScene;
import krpc.client.services.SpaceCenter.Control;
import krpc.client.services.SpaceCenter.ControlInputMode;
import krpc.client.services.SpaceCenter.Flight;
import krpc.client.services.SpaceCenter.Orbit;
import krpc.client.services.SpaceCenter.Part;
import krpc.client.services.SpaceCenter.ReferenceFrame;
import krpc.client.services.SpaceCenter.Vessel;

public class Server {

	private Connection connection;
	private KRPC krpc;
	private SpaceCenter spaceCenter;
	private Vessel vessel;
	
	private Stream<Flight> flightStream;
	private KSPControlConsumer<org.chase.kspcontrol.common.data.Flight, Flight> flightConsumer;
	
	private Stream<Orbit> orbitStream;
	private KSPControlConsumer<org.chase.kspcontrol.common.data.Orbit, Orbit> orbitConsumer;
	
	private Stream<Control> controlStream;
	private KSPControlConsumer<GeneralControl, Control> controlConsumer;
	
	private Stream<List<Part>> partStream;
	private KSPControlConsumer<PartsContainer, Vessel> partsConsumer;
	
	private boolean initalised = false;
	
	public void initialise(Connection connection) throws RPCException, IOException, StreamException, InterruptedException {
		this.connection = connection;
		krpc = KRPC.newInstance(connection);
		spaceCenter = SpaceCenter.newInstance(connection);
		
		while (krpc.getCurrentGameScene() != GameScene.FLIGHT) Thread.sleep(100);
		
		vessel = spaceCenter.getActiveVessel();

		ReferenceFrame refframe = vessel.getOrbit().getBody().getReferenceFrame();
		
		flightStream = connection.addStream(vessel, "flight", refframe);
		flightConsumer = new KSPControlConsumer(org.chase.kspcontrol.common.data.Flight.class);

		orbitStream = connection.addStream(vessel, "getOrbit");
		orbitConsumer = new KSPControlConsumer<>(org.chase.kspcontrol.common.data.Orbit.class);

		controlStream = connection.addStream(vessel, "getControl");
		controlConsumer = new KSPControlConsumer<>(GeneralControl.class);

		partStream = connection.addStream(vessel.getParts(), "getAll");
		partsConsumer = new KSPControlConsumer<>(PartsContainer.class);
		
		ServerContext.getInstance().setControlObject(new GeneralControl());
		
		initalised = true;

	}

	public void run() throws NotInitialisedException, RPCException, IOException, StreamException, InterruptedException {
		if (!initalised) throw new NotInitialisedException();
		while (krpc.getCurrentGameScene() != GameScene.FLIGHT) Thread.sleep(100);
		while (true) {
			if (vessel != spaceCenter.getActiveVessel()) initialise(connection);
			
			while (krpc.getCurrentGameScene() == GameScene.FLIGHT) {
				Flight flight = flightStream.get();
				Orbit orbit = orbitStream.get();
				Control control = controlStream.get();
				
				flightConsumer.accept(flight);
				orbitConsumer.accept(orbit);
				controlConsumer.accept(control);
				partsConsumer.accept(vessel);

			}
		}
	}

}
