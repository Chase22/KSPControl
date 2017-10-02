package org.chase.kspcontrol.common;

public interface KSPSerializeable<T> {
	public T deserialize(String json);
	public String serialize();
}
