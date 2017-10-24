package org.chase.kspcontrol.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.chase.kspcontrol.common.data.GeneralControl;

import com.google.gson.Gson;

import krpc.client.Connection;
import krpc.client.Stream;
import krpc.client.services.KRPC;
import krpc.client.services.KRPC.GameScene;
import krpc.client.services.SpaceCenter;
import krpc.client.services.SpaceCenter.Control;
import krpc.client.services.SpaceCenter.Flight;
import krpc.client.services.SpaceCenter.Module;
import krpc.client.services.SpaceCenter.Orbit;
import krpc.client.services.SpaceCenter.Part;
import krpc.client.services.SpaceCenter.ReferenceFrame;
import krpc.client.services.SpaceCenter.Vessel;

public class ServerStarter {
	
	public static void main(String[] args) throws Exception {
		Connection connection = Connection.newInstance();
		KRPC krpc = KRPC.newInstance(connection);
		SpaceCenter spaceCenter = SpaceCenter.newInstance(connection);

		while (krpc.getCurrentGameScene() != GameScene.FLIGHT) {
		};
		Vessel vessel = spaceCenter.getActiveVessel();

		ReferenceFrame refframe = vessel.getOrbit().getBody().getReferenceFrame();
		Stream<Flight> flightStream = connection.addStream(vessel, "flight", refframe);
		KSPControlConsumer<org.chase.kspcontrol.common.data.Flight, Flight> flightConsumer = new KSPControlConsumer(org.chase.kspcontrol.common.data.Flight.class);

		Stream<Orbit> orbitStream = connection.addStream(vessel, "getOrbit");
		KSPControlConsumer<org.chase.kspcontrol.common.data.Orbit, Orbit> orbitConsumer = new KSPControlConsumer<>(org.chase.kspcontrol.common.data.Orbit.class);

		Stream<Control> controlStream = connection.addStream(vessel, "getControl");
		KSPControlConsumer<GeneralControl, Control> controlConsumer = new KSPControlConsumer<>(GeneralControl.class);
		ServerContext.getInstance().setControlObject(new GeneralControl());
		
		Stream<List<Part>> partStream = connection.addStream(vessel.getParts(), "getAll");
		
		//flightStream.addCallback(flightConsumer);
		
		//flightStream.start();

		while (true) {
			while (krpc.getCurrentGameScene() == GameScene.FLIGHT) {
				Flight flight = flightStream.get();
				Orbit orbit = orbitStream.get();
				Control control = controlStream.get();
				
				flightConsumer.accept(flight);
				orbitConsumer.accept(orbit);
				controlConsumer.accept(control);
				/*
				
				List<org.chase.kspcontrol.common.data.parts.Part> partData = new ArrayList<>();
				
				for (Part p : partStream.get()) {
					partData.add(org.chase.kspcontrol.common.data.parts.Part.createInstance(p));
				}*/
			}
		}
	}

}
