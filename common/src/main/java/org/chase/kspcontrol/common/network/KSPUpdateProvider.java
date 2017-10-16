package org.chase.kspcontrol.client;

import org.chase.kspcontrol.common.NetworkObject;

public interface KSPUpdateProvider<T extends NetworkObject<T>> {
	public Class<T> getInstanceClass();
	public void send(T object);
	public void send(String json);
	public void register(KSPUpdateHandler<T> handler);
	public void unregister(KSPUpdateHandler<T> handler);
	
	
}
