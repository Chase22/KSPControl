package org.chase.kspcontrol.server;

import java.util.HashMap;

import org.chase.kspcontrol.common.data.ControlObject;

public class ServerContext {
	private static ServerContext instance;
	
	private MQServer mq;
	private HashMap<String, ControlObject> controlObjects = new HashMap<>();
	
	public ServerContext() {
		mq = new MQServer();
		mq.initialize();
	}
	
	public static ServerContext getInstance() {
		if (instance == null) instance = new ServerContext();
		return instance;
	}
	
	public MQServer getMQServer() {
		return this.mq;
	}

	public ControlObject getControlObject(String prefix) {
		return controlObjects.get(prefix);
	}
	
	public ControlObject setControlObject(ControlObject object) {
		controlObjects.put(object.getPrefix(), object);
		return object;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		mq.close();
	}
}
