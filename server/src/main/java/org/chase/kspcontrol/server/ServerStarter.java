package org.chase.kspcontrol.server;

import java.io.IOException;
import java.net.ConnectException;

import org.chase.kspcontrol.common.NotInitialisedException;

import krpc.client.Connection;
import krpc.client.RPCException;
import krpc.client.StreamException;

public class ServerStarter {

	public static void main(String[] args) {
		while (true) {
			try {
				System.out.println("Connection to Game..");
				Connection connection = Connection.newInstance();

				System.out.println("Initialising Server...");
				Server server = new Server();
				
				server.initialise(connection);
				
				System.out.println("Starting Server...");
				server.run();
				System.out.println("Server is running");

				// @SuppressWarnings("unused")
				// org.chase.kspcontrol.common.data.parts.Part part = new
				// org.chase.kspcontrol.common.data.parts.Part(vessel.getParts().getAll().get(0));
				// @SuppressWarnings("unused")
				// SolarPanel panel = new SolarPanel(vessel.getParts().getSolarPanels().get(0));

				// flightStream.addCallback(flightConsumer);

				// flightStream.start();

			} catch (ConnectException e) {
				System.err.println("Connection Error. Did you start the Server ingame?");
				System.err.println("Please start the server and press a button to continue");
				try {
					System.in.read();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (InterruptedException | StreamException | RPCException | NotInitialisedException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
