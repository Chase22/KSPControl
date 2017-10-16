package org.chase.kspcontrol.common.network;

import org.chase.kspcontrol.common.data.NetworkObject;

public interface KSPUpdateHandler<T extends NetworkObject<T>> {
	public void handle(T object);
}
