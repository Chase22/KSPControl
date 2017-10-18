package org.chase.kspcontrol.server;

import java.io.IOException;
import java.util.HashMap;

import org.chase.kspcontrol.common.data.ControlObject;
import org.chase.kspcontrol.common.data.GeneralControl;
import org.chase.kspcontrol.common.network.CommandMessage;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

import krpc.client.RPCException;

public class MQServer implements Runnable {
	public static Context mqContxt = ZMQ.context(1);

	private Socket publisher;
	private Socket request;

	private Thread worker;

	public void initialize() {
		publisher = mqContxt.socket(ZMQ.PUB);
		publisher.bind("tcp://*:5556");
		publisher.bind("ipc://ksp");

		request = mqContxt.socket(ZMQ.REP);
		request.bind("tcp://*:5557");

		worker = new Thread(this);
		worker.start();

	}

	public void close() {
		publisher.close();
		mqContxt.term();
	}

	public void send(String prefix, String message) {
		publisher.sendMore(prefix);
		publisher.send(message);
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			String string = request.recvStr(0).trim();

			CommandMessage message = new CommandMessage("", "", "").deserialize(string);

			System.out.printf("recieved Message. Prefix: %s Method %s Parameter %s%n", message.getPrefix(),
					message.getMethod(), message.getParams()[0]);

			try {
				String reply = ServerContext.getInstance().getControlObject(message.getPrefix())
						.parse(message.getMethod(), message.getParams());
				System.out.printf("Sending reply %s%n", reply);
				request.send(reply.getBytes());
				System.out.println("Reply send");
			} catch (RPCException | IOException e) {
				e.printStackTrace();
			}
		}
	}

}
