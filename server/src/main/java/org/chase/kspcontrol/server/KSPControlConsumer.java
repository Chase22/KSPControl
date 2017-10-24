package org.chase.kspcontrol.server;

import java.io.IOException;
import java.util.ResourceBundle.Control;
import java.util.function.Consumer;

import org.chase.kspcontrol.common.data.ControlObject;
import org.chase.kspcontrol.common.data.NetworkObject;

import krpc.client.RPCException;
import krpc.client.services.SpaceCenter.Flight;

public class KSPControlConsumer<U extends NetworkObject, T> implements Consumer<T> {

	private Class<U> clazz;
	
	public KSPControlConsumer(Class<U> clazz) {
		this.clazz = clazz;
	}
	
	@Override
	public void accept(T t) {
		U object;
		try {
			object = clazz.newInstance();
			object = (U) object.createInstance(t);
			
			if (ControlObject.class.isInstance(object)) {
				ServerContext.getInstance().setControlObject((ControlObject) object);
			}
			
			ServerContext.getInstance().getMQServer().send(object.getPrefix(), object.serialize());
		} catch (InstantiationException | IllegalAccessException | RPCException | IOException e) {
			e.printStackTrace();
		}
	}

}
