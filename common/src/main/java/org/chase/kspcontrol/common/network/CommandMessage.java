package org.chase.kspcontrol.common.network;

import org.chase.kspcontrol.common.KSPSerializeable;

import com.google.gson.Gson;

public class CommandMessage implements KSPSerializeable<CommandMessage> {
	String prefix;
	String method;
	Object[] params;
	
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
}
