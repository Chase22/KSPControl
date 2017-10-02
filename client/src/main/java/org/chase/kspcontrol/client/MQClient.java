package org.chase.kspcontrol.client;

import java.util.HashMap;

import org.chase.kspcontrol.common.NetworkObject;
import org.chase.kspcontrol.common.data.Flight;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;

public class MQClient implements Runnable {
	public static Context context = ZMQ.context(1);
	private ZMQ.Socket subscriber;
	
	private Thread worker;
	
	private HashMap<String, KSPUpdateProvider> handlers = new HashMap<String, KSPUpdateProvider>();
	
	public void initialise() {
		subscriber = context.socket(ZMQ.SUB);
        subscriber.connect("tcp://localhost:5556");
        
        worker = new Thread(this);
        worker.start();
	}
	
	public void close() {
		subscriber.close();
		context.close();
		worker.interrupt();
	}

	public void run() {
		while (Thread.interrupted() == false) {
			try {
			String string = subscriber.recvStr(0).trim();
			String[] parts = string.split("%", 2);
			handlers.get(parts[0]).send(parts[1]);
			} catch (Exception e) {}
		}
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
	}
	
	public KSPUpdateProvider getHandler(String prefix) {
		return handlers.get(prefix);
	}
	
}
