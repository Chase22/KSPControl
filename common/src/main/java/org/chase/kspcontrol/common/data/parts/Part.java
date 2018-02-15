package org.chase.kspcontrol.common.data.parts;

import java.io.IOException;
import java.util.function.Predicate;

import org.chase.kspcontrol.common.data.ControlObject;

import krpc.client.RPCException;
import krpc.client.services.SpaceCenter.Module;

public class Part extends ControlObject<Part, krpc.client.services.SpaceCenter.Part> {
	private transient krpc.client.services.SpaceCenter.Part controlObject;
	
	private long id;
	private boolean axiallyattached;
	private double cost;
	private boolean crossfeed;
	private int decouplestage;
	private double drymass;
	private float dynamicpressure;
	private boolean highlighted;
	private double impacttolerance;
	private boolean isfuelline;
	private double mass;
	private boolean massless;
	private double maxskintemperature;
	private double maxtemperature;
	// private List modules;
	private String name;
	private boolean radiallyattached;
	private boolean shielded;
	private double skintemperature;
	private int stage;
	private String tag;
	private double temperature;
	private float thermalconductionflux;
	private float thermalconvectionflux;
	private float thermalinternalflux;
	private float thermalmass;
	private float thermalradiationflux;
	private float thermalresourcemass;
	private float thermalskinmass;
	private float thermalskintointernalflux;
	private String title;
	
	@Override
	public Part createInstance(krpc.client.services.SpaceCenter.Part object) throws RPCException, IOException {
		return new Part(object);
	}

	public Part(krpc.client.services.SpaceCenter.Part part) throws RPCException, IOException {
		super(part);
		
		controlObject = part;
		Module idModule = part.getModules().stream().filter(new Predicate<Module>() {
			@Override
			public boolean test(Module t) {
				try {
					return t.getName().equals("PartIdModule");
				} catch (RPCException | IOException e) {
					return false;
				}
			}
		}).findFirst().get();
		id = Long.parseLong(idModule.getField("PartID"));
			
//		for(Module m : part.getModules()) {
//			if (m.getName().equals("PartIdModule")) {
//				id = Long.parseLong(m.getFields().get("PartID"));
//				break;
//			}
//		}
		
		axiallyattached = part.getAxiallyAttached();
		cost = part.getCost();
		crossfeed = part.getCrossfeed();
		decouplestage = part.getDecoupleStage();
		drymass = part.getDryMass();
		dynamicpressure = part.getDynamicPressure();
		highlighted = part.getHighlighted();
		impacttolerance = part.getImpactTolerance();
		isfuelline = part.getIsFuelLine();
		mass = part.getMass();
		massless = part.getMassless();
		maxskintemperature = part.getMaxSkinTemperature();
		maxtemperature = part.getMaxTemperature();
		// modules = part.getModules();
		name = part.getName();
		radiallyattached = part.getRadiallyAttached();
		shielded = part.getShielded();
		skintemperature = part.getSkinTemperature();
		stage = part.getStage();
		try {tag = part.getTag();} catch (RPCException e) {};
		temperature = part.getTemperature();
		thermalconductionflux = part.getThermalConductionFlux();
		thermalconvectionflux = part.getThermalConvectionFlux();
		thermalinternalflux = part.getThermalInternalFlux();
		thermalmass = part.getThermalMass();
		thermalradiationflux = part.getThermalRadiationFlux();
		thermalresourcemass = part.getThermalResourceMass();
		thermalskinmass = part.getThermalSkinMass();
		thermalskintointernalflux = part.getThermalSkinToInternalFlux();
		title = part.getTitle();
	}

	public String parse(String method, Object... params) throws RPCException, IOException {
		switch (method) {
		case "highlighted":
			controlObject.setHighlighted((boolean) params[0]);
			break;
		case "tag":
			controlObject.setTag((String) params[0]);
			break;
		}
		return "worked";
	}

	@Override
	public String getPrefix() {
		return "PART";
	}
	
	public long getID() {
		return id;
	}


	/**
	 * @return the axiallyattached
	 */
	public boolean isAxiallyattached() {
		return axiallyattached;
	}

	/**
	 * @param axiallyattached the axiallyattached to set
	 */
	public void setAxiallyattached(boolean axiallyattached) {
		this.axiallyattached = axiallyattached;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * @return the crossfeed
	 */
	public boolean isCrossfeed() {
		return crossfeed;
	}

	/**
	 * @param crossfeed the crossfeed to set
	 */
	public void setCrossfeed(boolean crossfeed) {
		this.crossfeed = crossfeed;
	}

	/**
	 * @return the decouplestage
	 */
	public int getDecouplestage() {
		return decouplestage;
	}

	/**
	 * @param decouplestage the decouplestage to set
	 */
	public void setDecouplestage(int decouplestage) {
		this.decouplestage = decouplestage;
	}

	/**
	 * @return the drymass
	 */
	public double getDrymass() {
		return drymass;
	}

	/**
	 * @param drymass the drymass to set
	 */
	public void setDrymass(double drymass) {
		this.drymass = drymass;
	}

	/**
	 * @return the dynamicpressure
	 */
	public float getDynamicpressure() {
		return dynamicpressure;
	}

	/**
	 * @param dynamicpressure the dynamicpressure to set
	 */
	public void setDynamicpressure(float dynamicpressure) {
		this.dynamicpressure = dynamicpressure;
	}

	/**
	 * @return the highlighted
	 */
	public boolean isHighlighted() {
		return highlighted;
	}

	/**
	 * @param highlighted the highlighted to set
	 */
	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	/**
	 * @return the impacttolerance
	 */
	public double getImpacttolerance() {
		return impacttolerance;
	}

	/**
	 * @param impacttolerance the impacttolerance to set
	 */
	public void setImpacttolerance(double impacttolerance) {
		this.impacttolerance = impacttolerance;
	}

	/**
	 * @return the isfuelline
	 */
	public boolean isIsfuelline() {
		return isfuelline;
	}

	/**
	 * @param isfuelline the isfuelline to set
	 */
	public void setIsfuelline(boolean isfuelline) {
		this.isfuelline = isfuelline;
	}

	/**
	 * @return the mass
	 */
	public double getMass() {
		return mass;
	}

	/**
	 * @param mass the mass to set
	 */
	public void setMass(double mass) {
		this.mass = mass;
	}

	/**
	 * @return the massless
	 */
	public boolean isMassless() {
		return massless;
	}

	/**
	 * @param massless the massless to set
	 */
	public void setMassless(boolean massless) {
		this.massless = massless;
	}

	/**
	 * @return the maxskintemperature
	 */
	public double getMaxskintemperature() {
		return maxskintemperature;
	}

	/**
	 * @param maxskintemperature the maxskintemperature to set
	 */
	public void setMaxskintemperature(double maxskintemperature) {
		this.maxskintemperature = maxskintemperature;
	}

	/**
	 * @return the maxtemperature
	 */
	public double getMaxtemperature() {
		return maxtemperature;
	}

	/**
	 * @param maxtemperature the maxtemperature to set
	 */
	public void setMaxtemperature(double maxtemperature) {
		this.maxtemperature = maxtemperature;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the radiallyattached
	 */
	public boolean isRadiallyattached() {
		return radiallyattached;
	}

	/**
	 * @param radiallyattached the radiallyattached to set
	 */
	public void setRadiallyattached(boolean radiallyattached) {
		this.radiallyattached = radiallyattached;
	}

	/**
	 * @return the shielded
	 */
	public boolean isShielded() {
		return shielded;
	}

	/**
	 * @param shielded the shielded to set
	 */
	public void setShielded(boolean shielded) {
		this.shielded = shielded;
	}

	/**
	 * @return the skintemperature
	 */
	public double getSkintemperature() {
		return skintemperature;
	}

	/**
	 * @param skintemperature the skintemperature to set
	 */
	public void setSkintemperature(double skintemperature) {
		this.skintemperature = skintemperature;
	}

	/**
	 * @return the stage
	 */
	public int getStage() {
		return stage;
	}

	/**
	 * @param stage the stage to set
	 */
	public void setStage(int stage) {
		this.stage = stage;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the thermalconductionflux
	 */
	public float getThermalconductionflux() {
		return thermalconductionflux;
	}

	/**
	 * @param thermalconductionflux the thermalconductionflux to set
	 */
	public void setThermalconductionflux(float thermalconductionflux) {
		this.thermalconductionflux = thermalconductionflux;
	}

	/**
	 * @return the thermalconvectionflux
	 */
	public float getThermalconvectionflux() {
		return thermalconvectionflux;
	}

	/**
	 * @param thermalconvectionflux the thermalconvectionflux to set
	 */
	public void setThermalconvectionflux(float thermalconvectionflux) {
		this.thermalconvectionflux = thermalconvectionflux;
	}

	/**
	 * @return the thermalinternalflux
	 */
	public float getThermalinternalflux() {
		return thermalinternalflux;
	}

	/**
	 * @param thermalinternalflux the thermalinternalflux to set
	 */
	public void setThermalinternalflux(float thermalinternalflux) {
		this.thermalinternalflux = thermalinternalflux;
	}

	/**
	 * @return the thermalmass
	 */
	public float getThermalmass() {
		return thermalmass;
	}

	/**
	 * @param thermalmass the thermalmass to set
	 */
	public void setThermalmass(float thermalmass) {
		this.thermalmass = thermalmass;
	}

	/**
	 * @return the thermalradiationflux
	 */
	public float getThermalradiationflux() {
		return thermalradiationflux;
	}

	/**
	 * @param thermalradiationflux the thermalradiationflux to set
	 */
	public void setThermalradiationflux(float thermalradiationflux) {
		this.thermalradiationflux = thermalradiationflux;
	}

	/**
	 * @return the thermalresourcemass
	 */
	public float getThermalresourcemass() {
		return thermalresourcemass;
	}

	/**
	 * @param thermalresourcemass the thermalresourcemass to set
	 */
	public void setThermalresourcemass(float thermalresourcemass) {
		this.thermalresourcemass = thermalresourcemass;
	}

	/**
	 * @return the thermalskinmass
	 */
	public float getThermalskinmass() {
		return thermalskinmass;
	}

	/**
	 * @param thermalskinmass the thermalskinmass to set
	 */
	public void setThermalskinmass(float thermalskinmass) {
		this.thermalskinmass = thermalskinmass;
	}

	/**
	 * @return the thermalskintointernalflux
	 */
	public float getThermalskintointernalflux() {
		return thermalskintointernalflux;
	}

	/**
	 * @param thermalskintointernalflux the thermalskintointernalflux to set
	 */
	public void setThermalskintointernalflux(float thermalskintointernalflux) {
		this.thermalskintointernalflux = thermalskintointernalflux;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}
