package org.chase.kspcontrol.common.network;

import org.chase.kspcontrol.common.data.NetworkObject;

public interface KSPUpdateHandler<T extends NetworkObject> {
	public void handle(T object);
}
