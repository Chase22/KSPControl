package org.chase.kspcontrol.client;

import org.chase.kspcontrol.common.NetworkObject;

public interface KSPUpdateHandler<T extends NetworkObject<T>> {
	public void handle(T object);
}
