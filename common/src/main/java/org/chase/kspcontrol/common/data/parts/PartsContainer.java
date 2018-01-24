package org.chase.kspcontrol.common.data.parts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.chase.kspcontrol.common.data.NetworkObject;

import krpc.client.RPCException;
import krpc.client.services.SpaceCenter.Parts;
import krpc.client.services.SpaceCenter.Vessel;

public class PartsContainer extends NetworkObject<PartsContainer, Vessel> {
	
	private Map<Long, Part> parts = new HashMap<>();
	private Map<Long, Engine> engines= new HashMap<>();
	private Map<Long, SolarPanel> solarPanels = new HashMap<>();
	
	public PartsContainer() {};
	
	public PartsContainer(Vessel object) throws RPCException, IOException {
		super(object);
		
		Parts parts = object.getParts();
		
		for (krpc.client.services.SpaceCenter.Part p : parts.getAll()) {
			Part part = new Part(p);
			this.parts.put(part.getID(), part);
		}
		
		for (krpc.client.services.SpaceCenter.Engine e : parts.getEngines()) {
			Engine engine = new Engine(e);
			this.engines.put(engine.getID(), engine);
		}
		
		for (krpc.client.services.SpaceCenter.SolarPanel sp : parts.getSolarPanels()) {
			SolarPanel solar = new SolarPanel(sp);
			this.solarPanels.put(solar.getID(), solar);
		}
	}

	@Override
	public String getPrefix() {
		return "PARTS";
	}

	@Override
	public PartsContainer createInstance(Vessel object) throws RPCException, IOException {
		return new PartsContainer(object);
	}

}
