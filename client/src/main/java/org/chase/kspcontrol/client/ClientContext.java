package org.chase.kspcontrol.client;

public class ClientContext {
	private static ClientContext instance;
	
	private MQClient client;
	
	public static ClientContext getInstance() {
		if (instance == null) instance = new ClientContext();
		return instance;
	}
	
	public ClientContext() {
		client = new MQClient();
		client.initialise();
	}
	
	public MQClient getMQClient() {
		return client;
	}

	public void close() {
		client.close();
	}

}
