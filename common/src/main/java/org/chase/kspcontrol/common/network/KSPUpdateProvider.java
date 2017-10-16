package org.chase.kspcontrol.common.network;

import org.chase.kspcontrol.common.data.NetworkObject;

public interface KSPUpdateProvider<T extends NetworkObject<T>> {
	public Class<T> getInstanceClass();
	public void send(T object);
	public void send(String json);
	public void register(KSPUpdateHandler<T> handler);
	public void unregister(KSPUpdateHandler<T> handler);
	
	
}
