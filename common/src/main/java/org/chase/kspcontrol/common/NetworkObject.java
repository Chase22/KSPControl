package org.chase.kspcontrol.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.chase.kspcontrol.common.data.Flight;

import com.google.gson.Gson;

public abstract class NetworkObject<T> implements KSPSerializeable<T> {

	private transient Class<T> T = (Class<T>) this.getClass();
	
	public abstract String getPrefix();
	
	public NetworkObject(){};

	public T deserialize(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, T);
	}

	public String serialize() {
		return new Gson().toJson(this);
	}
	
	public T deserializeFromMessage(String json) {
		String[] parts = json.split("%", 2);
		Gson gson = new Gson();
		return gson.fromJson(parts[1], T);
	}

	public String serializeToMessage() {
		Flight flight = (Flight) this;
		return getPrefix() + "%" + new Gson().toJson(this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Method[] Methods = this.getClass().getMethods();

		for (Method m : Methods) {
			if (m.getName().startsWith("get")) {
				try {
					Object value = m.invoke(this);
					sb.append(String.format("%s : %s%n", m.getName().substring(3), value.toString()));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
