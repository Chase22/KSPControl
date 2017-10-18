package org.chase.kspcontrol.client;

import java.util.HashMap;

import org.chase.kspcontrol.common.data.Flight;
import org.chase.kspcontrol.common.data.NetworkObject;
import org.chase.kspcontrol.common.network.CommandMessage;
import org.chase.kspcontrol.common.network.KSPUpdateProvider;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;

public class MQClient implements Runnable {
	public static Context context = ZMQ.context(1);
	private ZMQ.Socket subscriber;
	private ZMQ.Socket commander;
	
	private Thread worker;
	
	private HashMap<String, KSPUpdateProvider> handlers = new HashMap<String, KSPUpdateProvider>();
	
	public void initialise() {
		subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5556");
        
        commander = context.socket(ZMQ.REQ);
        commander.connect("tcp://localhost:5557");
        
        worker = new Thread(this);
        worker.start();
	}
	
	public void close() {
		subscriber.close();
		commander.close();
		context.close();
		worker.interrupt();
	}

	public void run() {
		while (Thread.interrupted() == false) {
			try {
			String prefix = subscriber.recvStr(0);
			String string = subscriber.recvStr(0).trim();
			handlers.get(prefix).send(string);
			} catch (Exception e) {}
		}
	}
	
	public void send(String prefix, String method, Object... params) {
		commander.send(new CommandMessage(prefix, method, params).serialize().getBytes());
		System.out.println(commander.recvStr(0));
	}
	
	public <T extends NetworkObject<T>> void registerHandler(KSPUpdateProvider<T> provider) throws InstantiationException, IllegalAccessException {
		String prefix = provider.getInstanceClass().newInstance().getPrefix();
		if (handlers.containsKey(prefix)) {
			return;
		} else {
			handlers.put(prefix, provider);
			subscriber.subscribe(prefix.getBytes());
		}
	}
	
	public void unregisterHandler(String prefix) {
		handlers.remove(prefix);
		subscriber.unsubscribe(prefix.getBytes());
	}
	
	public KSPUpdateProvider getHandler(String prefix) {
		return handlers.get(prefix);
	}
	
}
