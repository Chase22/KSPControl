package org.chase.kspcontrol.server;

import krpc.client.Connection;
import krpc.client.Stream;
import krpc.client.services.KRPC;
import krpc.client.services.KRPC.GameScene;
import krpc.client.services.SpaceCenter;
import krpc.client.services.SpaceCenter.Flight;
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

		while (krpc.getCurrentGameScene() != GameScene.FLIGHT) {};
		Vessel vessel = spaceCenter.getActiveVessel();
		
		ReferenceFrame refframe = vessel.getOrbit().getBody().getReferenceFrame();
		Stream<Flight> flightStream = connection.addStream(vessel, "flight", refframe);

		while (true) {
			Flight flight = flightStream.get();

			mq.send(org.chase.kspcontrol.common.data.Flight.createInstance(flight).serializeToMessage());
			
		}
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		mq.close();
	}

}
