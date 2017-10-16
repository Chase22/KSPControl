package org.chase.kspcontrol.server;

import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

public class MQServer {
	public static Context mqContxt = ZMQ.context(1);
	
	private Socket publisher;
	private Socket request;
	
	public void initialize() {
		publisher = mqContxt.socket(ZMQ.PUB);
		publisher.bind("tcp://*:5556");
		publisher.bind("ipc://ksp");

	}
	
	public void close() {
		publisher.close();
		mqContxt.term();
	}
	
	public void send(String prefix, String message) {
		publisher.sendMore(prefix);
		publisher.send(message);
	}

}
