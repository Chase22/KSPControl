package org.chase.kspcontrol.common.network;

import org.chase.kspcontrol.common.KSPSerializeable;

import com.google.gson.Gson;

public class CommandMessage implements KSPSerializeable<CommandMessage> {
	private String prefix;
	private String method;
	private Object[] params;
	
	public CommandMessage(String prefix, String method, Object... params) {
		this.prefix = prefix;
		this.method = method;
		this.params = params;
	}

	public CommandMessage deserialize(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, CommandMessage.class);
	}

	public String serialize() {
		return new Gson().toJson(this);
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the params
	 */
	public Object[] getParams() {
		return params;
	}

	/**
	 * @param params the params to set
	 */
	public void setParams(Object[] params) {
		this.params = params;
	}
	
	
}
