package org.chase.kspcontrol.server;

import org.chase.kspcontrol.common.data.GeneralControl;

import krpc.client.Connection;
import krpc.client.Stream;
import krpc.client.services.KRPC;
import krpc.client.services.KRPC.GameScene;
import krpc.client.services.SpaceCenter;
import krpc.client.services.SpaceCenter.Control;
import krpc.client.services.SpaceCenter.Flight;
import krpc.client.services.SpaceCenter.Orbit;
import krpc.client.services.SpaceCenter.ReferenceFrame;
import krpc.client.services.SpaceCenter.Vessel;

public class ServerStarter {

	public static MQServer mq;

	public static void main(String[] args) throws Exception {
		Connection connection = Connection.newInstance();
		KRPC krpc = KRPC.newInstance(connection);
		SpaceCenter spaceCenter = SpaceCenter.newInstance(connection);

		mq = new MQServer();
		mq.initialize();

		while (krpc.getCurrentGameScene() != GameScene.FLIGHT) {
		}
		;
		Vessel vessel = spaceCenter.getActiveVessel();

		ReferenceFrame refframe = vessel.getOrbit().getBody().getReferenceFrame();
		Stream<Flight> flightStream = connection.addStream(vessel, "flight", refframe);

		Stream<Orbit> orbitStream = connection.addStream(vessel, "getOrbit");
		
		Stream<Control> controlStream = connection.addStream(vessel, "getControl");

		while (true) {
			while (krpc.getCurrentGameScene() == GameScene.FLIGHT) {
				Flight flight = flightStream.get();
				Orbit orbit = orbitStream.get();
				Control control = controlStream.get();
				
				org.chase.kspcontrol.common.data.Flight FlightData = org.chase.kspcontrol.common.data.Flight.createInstance(flight);
				org.chase.kspcontrol.common.data.Orbit OrbitData = org.chase.kspcontrol.common.data.Orbit.createInstance(orbit);
				GeneralControl controlData = GeneralControl.createInstance(control);

				mq.send(FlightData.getPrefix(), FlightData.serialize());
				mq.send(OrbitData.getPrefix(), OrbitData.serialize());
				mq.send(controlData.getPrefix(), controlData.serialize());
			}
		}
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		mq.close();
	}

}
