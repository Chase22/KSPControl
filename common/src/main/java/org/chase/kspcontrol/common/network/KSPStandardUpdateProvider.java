package org.chase.kspcontrol.common.network;

import java.util.ArrayList;
import java.util.List;

import org.chase.kspcontrol.common.data.NetworkObject;

import com.google.gson.Gson;

public class KSPStandardUpdateProvider<T extends NetworkObject> implements KSPUpdateProvider<T> {
	
	private List<KSPUpdateHandler<T>> handlers = new ArrayList<KSPUpdateHandler<T>>();
	private Class<T> instanceClass;
	
	public KSPStandardUpdateProvider(Class<T> instanceClass) {
		this.instanceClass = instanceClass;
	}
	
	public Class<T> getInstanceClass() {
		return instanceClass;
	}

	public void send(T object) {
		for(KSPUpdateHandler<T> handler : handlers) {
			handler.handle(object);
		}
	}

	public void register(KSPUpdateHandler<T> handler) {
		handlers.add(handler);
	}

	public void unregister(KSPUpdateHandler<T> handler) {
		handlers.remove(handler);
	}

	public void send(String json) {
		T object = new Gson().fromJson(json, instanceClass);
		this.send(object);
	}

}
