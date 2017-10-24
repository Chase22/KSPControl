package org.chase.kspcontrol.common.data;

import java.io.IOException;

import krpc.client.RPCException;
import krpc.client.services.SpaceCenter.Control;
import krpc.client.services.SpaceCenter.ControlInputMode;
import krpc.client.services.SpaceCenter.SASMode;
import krpc.client.services.SpaceCenter.SpeedMode;

public class GeneralControl extends ControlObject<GeneralControl, krpc.client.services.SpaceCenter.Control> {

	private transient krpc.client.services.SpaceCenter.Control controlObject;
	private boolean abort;
	private boolean actiongroup;
	private boolean antennas;
	private boolean brakes;
	private boolean cargobays;
	private int currentstage;
	private float forward;
	private boolean gear;
	private String inputmode;
	private boolean intakes;
	private boolean legs;
	private boolean lights;
	private boolean parachutes;
	private float pitch;
	private boolean rcs;
	private boolean radiators;
	private boolean reactionwheels;
	private boolean resourceharvesters;
	private boolean resourceharvestersactive;
	private float right;
	private float roll;
	private boolean sas;
	private String sasmode;
	private boolean solarpanels;
	private String source;
	private String speedmode;
	private String state;
	private float throttle;
	private float up;
	private float wheelsteering;
	private float wheelthrottle;
	private boolean wheels;
	private float yaw;
	
	@Override
	public GeneralControl createInstance(Control object) throws RPCException, IOException {
		return new GeneralControl(object);
	}

	public GeneralControl(krpc.client.services.SpaceCenter.Control control)
			throws RPCException, IOException {
		super(control);
		
		controlObject = control;
		abort = control.getAbort();
		//controlData.actiongroup = control.getActionGroup();
		antennas = control.getAntennas();
		brakes = control.getBrakes();
		cargobays = control.getCargoBays();
		currentstage = control.getCurrentStage();
		forward = control.getForward();
		gear = control.getGear();
		//controlData.inputmode = control.getInputMode().name();
		intakes = control.getIntakes();
		legs = control.getLegs();
		lights = control.getLights();
		parachutes = control.getParachutes();
		pitch = control.getPitch();
		rcs = control.getRCS();
		radiators = control.getRadiators();
		reactionwheels = control.getReactionWheels();
		resourceharvesters = control.getResourceHarvesters();
		resourceharvestersactive = control.getResourceHarvestersActive();
		right = control.getRight();
		roll = control.getRoll();
		sas = control.getSAS();
		sasmode = control.getSASMode().name();
		solarpanels = control.getSolarPanels();
		source = control.getSource().name();
		speedmode = control.getSpeedMode().name();
		state = control.getState().name();
		throttle = control.getThrottle();
		up = control.getUp();
		wheelsteering = control.getWheelSteering();
		wheelthrottle = control.getWheelThrottle();
		wheels = control.getWheels();
		yaw = control.getYaw();
	}

	public GeneralControl() {}

	public String parse(String method, Object... params) throws RPCException, IOException {
		System.out.println(method);
		System.out.println(params[0]);
		switch(method) {
		case "resourceHarvesters":
		controlObject.setResourceHarvesters((boolean) params[0]);
		break;
		case "RCS":
		controlObject.setRCS((boolean) params[0]);
		break;
		case "yaw":
		controlObject.setYaw((float) params[0]);
		break;
		case "up":
		controlObject.setUp((float) params[0]);
		break;
		case "roll":
		controlObject.setRoll((float) params[0]);
		break;
		case "actionGroup":
		controlObject.setActionGroup((int)params[0],(boolean)params[1]);
		break;
		case "wheels":
		controlObject.setWheels((boolean) params[0]);
		break;
		case "pitch":
		controlObject.setPitch((float) params[0]);
		break;
		case "abort":
		controlObject.setAbort((boolean) params[0]);
		break;
		case "solarPanels":
		controlObject.setSolarPanels((boolean) params[0]);
		break;
		case "forward":
		controlObject.setForward((float) params[0]);
		break;
		case "intakes":
		controlObject.setIntakes((boolean) params[0]);
		break;
		case "brakes":
		controlObject.setBrakes((boolean) params[0]);
		break;
		case "inputMode":
		controlObject.setInputMode(ControlInputMode.valueOf((String) params[0]));
		break;
		case "legs":
		controlObject.setLegs((boolean) params[0]);
		break;
		case "throttle":
		controlObject.setThrottle((float) params[0]);
		break;
		case "cargoBays":
		controlObject.setCargoBays((boolean) params[0]);
		break;
		case "right":
		controlObject.setRight((float) params[0]);
		break;
		case "gear":
		controlObject.setGear((boolean) params[0]);
		break;
		case "SAS":
		controlObject.setSAS((boolean) params[0]);
		break;
		case "antennas":
		controlObject.setAntennas((boolean) params[0]);
		break;
		case "radiators":
		controlObject.setRadiators((boolean) params[0]);
		break;
		case "parachutes":
		controlObject.setParachutes((boolean) params[0]);
		break;
		case "speedMode":
		controlObject.setSpeedMode((SpeedMode) params[0]);
		break;
		case "wheelThrottle":
		controlObject.setWheelThrottle((float) params[0]);
		break;
		case "SASMode":
		controlObject.setSASMode((SASMode) params[0]);
		break;
		case "lights":
		controlObject.setLights((boolean) params[0]);
		break;
		case "wheelSteering":
		controlObject.setWheelSteering((float) params[0]);
		break;
		case "resourceHarvestersActive":
		controlObject.setResourceHarvestersActive((boolean) params[0]);
		break;
		case "reactionWheels":
		controlObject.setReactionWheels((boolean) params[0]);
		break;
		}
		return "worked";
		}

	@Override
	public String getPrefix() {
		return "CONTROL";
	}

	/**
	 * @return the controlObject
	 */
	public krpc.client.services.SpaceCenter.Control getControlObject() {
		return controlObject;
	}

	/**
	 * @param controlObject the controlObject to set
	 */
	public void setControlObject(krpc.client.services.SpaceCenter.Control controlObject) {
		this.controlObject = controlObject;
	}

	/**
	 * @return the abort
	 */
	public boolean isAbort() {
		return abort;
	}

	/**
	 * @param abort the abort to set
	 */
	public void setAbort(boolean abort) {
		this.abort = abort;
	}

	/**
	 * @return the actiongroup
	 */
	public boolean isActiongroup() {
		return actiongroup;
	}

	/**
	 * @param actiongroup the actiongroup to set
	 */
	public void setActiongroup(boolean actiongroup) {
		this.actiongroup = actiongroup;
	}

	/**
	 * @return the antennas
	 */
	public boolean isAntennas() {
		return antennas;
	}

	/**
	 * @param antennas the antennas to set
	 */
	public void setAntennas(boolean antennas) {
		this.antennas = antennas;
	}

	/**
	 * @return the brakes
	 */
	public boolean isBrakes() {
		return brakes;
	}

	/**
	 * @param brakes the brakes to set
	 */
	public void setBrakes(boolean brakes) {
		this.brakes = brakes;
	}

	/**
	 * @return the cargobays
	 */
	public boolean isCargobays() {
		return cargobays;
	}

	/**
	 * @param cargobays the cargobays to set
	 */
	public void setCargobays(boolean cargobays) {
		this.cargobays = cargobays;
	}

	/**
	 * @return the currentstage
	 */
	public int getCurrentstage() {
		return currentstage;
	}

	/**
	 * @param currentstage the currentstage to set
	 */
	public void setCurrentstage(int currentstage) {
		this.currentstage = currentstage;
	}

	/**
	 * @return the forward
	 */
	public float getForward() {
		return forward;
	}

	/**
	 * @param forward the forward to set
	 */
	public void setForward(float forward) {
		this.forward = forward;
	}

	/**
	 * @return the gear
	 */
	public boolean isGear() {
		return gear;
	}

	/**
	 * @param gear the gear to set
	 */
	public void setGear(boolean gear) {
		this.gear = gear;
	}

	/**
	 * @return the inputmode
	 */
	public String getInputmode() {
		return inputmode;
	}

	/**
	 * @param inputmode the inputmode to set
	 */
	public void setInputmode(String inputmode) {
		this.inputmode = inputmode;
	}

	/**
	 * @return the intakes
	 */
	public boolean isIntakes() {
		return intakes;
	}

	/**
	 * @param intakes the intakes to set
	 */
	public void setIntakes(boolean intakes) {
		this.intakes = intakes;
	}

	/**
	 * @return the legs
	 */
	public boolean isLegs() {
		return legs;
	}

	/**
	 * @param legs the legs to set
	 */
	public void setLegs(boolean legs) {
		this.legs = legs;
	}

	/**
	 * @return the lights
	 */
	public boolean isLights() {
		return lights;
	}

	/**
	 * @param lights the lights to set
	 */
	public void setLights(boolean lights) {
		this.lights = lights;
	}

	/**
	 * @return the parachutes
	 */
	public boolean isParachutes() {
		return parachutes;
	}

	/**
	 * @param parachutes the parachutes to set
	 */
	public void setParachutes(boolean parachutes) {
		this.parachutes = parachutes;
	}

	/**
	 * @return the pitch
	 */
	public float getPitch() {
		return pitch;
	}

	/**
	 * @param pitch the pitch to set
	 */
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}

	/**
	 * @return the rcs
	 */
	public boolean isRcs() {
		return rcs;
	}

	/**
	 * @param rcs the rcs to set
	 */
	public void setRcs(boolean rcs) {
		this.rcs = rcs;
	}

	/**
	 * @return the radiators
	 */
	public boolean isRadiators() {
		return radiators;
	}

	/**
	 * @param radiators the radiators to set
	 */
	public void setRadiators(boolean radiators) {
		this.radiators = radiators;
	}

	/**
	 * @return the reactionwheels
	 */
	public boolean isReactionwheels() {
		return reactionwheels;
	}

	/**
	 * @param reactionwheels the reactionwheels to set
	 */
	public void setReactionwheels(boolean reactionwheels) {
		this.reactionwheels = reactionwheels;
	}

	/**
	 * @return the resourceharvesters
	 */
	public boolean isResourceharvesters() {
		return resourceharvesters;
	}

	/**
	 * @param resourceharvesters the resourceharvesters to set
	 */
	public void setResourceharvesters(boolean resourceharvesters) {
		this.resourceharvesters = resourceharvesters;
	}

	/**
	 * @return the resourceharvestersactive
	 */
	public boolean isResourceharvestersactive() {
		return resourceharvestersactive;
	}

	/**
	 * @param resourceharvestersactive the resourceharvestersactive to set
	 */
	public void setResourceharvestersactive(boolean resourceharvestersactive) {
		this.resourceharvestersactive = resourceharvestersactive;
	}

	/**
	 * @return the right
	 */
	public float getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(float right) {
		this.right = right;
	}

	/**
	 * @return the roll
	 */
	public float getRoll() {
		return roll;
	}

	/**
	 * @param roll the roll to set
	 */
	public void setRoll(float roll) {
		this.roll = roll;
	}

	/**
	 * @return the sas
	 */
	public boolean isSas() {
		return sas;
	}

	/**
	 * @param sas the sas to set
	 */
	public void setSas(boolean sas) {
		this.sas = sas;
	}

	/**
	 * @return the sasmode
	 */
	public String getSasmode() {
		return sasmode;
	}

	/**
	 * @param sasmode the sasmode to set
	 */
	public void setSasmode(String sasmode) {
		this.sasmode = sasmode;
	}

	/**
	 * @return the solarpanels
	 */
	public boolean isSolarpanels() {
		return solarpanels;
	}

	/**
	 * @param solarpanels the solarpanels to set
	 */
	public void setSolarpanels(boolean solarpanels) {
		this.solarpanels = solarpanels;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the speedmode
	 */
	public String getSpeedmode() {
		return speedmode;
	}

	/**
	 * @param speedmode the speedmode to set
	 */
	public void setSpeedmode(String speedmode) {
		this.speedmode = speedmode;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the throttle
	 */
	public float getThrottle() {
		return throttle;
	}

	/**
	 * @param throttle the throttle to set
	 */
	public void setThrottle(float throttle) {
		this.throttle = throttle;
	}

	/**
	 * @return the up
	 */
	public float getUp() {
		return up;
	}

	/**
	 * @param up the up to set
	 */
	public void setUp(float up) {
		this.up = up;
	}

	/**
	 * @return the wheelsteering
	 */
	public float getWheelsteering() {
		return wheelsteering;
	}

	/**
	 * @param wheelsteering the wheelsteering to set
	 */
	public void setWheelsteering(float wheelsteering) {
		this.wheelsteering = wheelsteering;
	}

	/**
	 * @return the wheelthrottle
	 */
	public float getWheelthrottle() {
		return wheelthrottle;
	}

	/**
	 * @param wheelthrottle the wheelthrottle to set
	 */
	public void setWheelthrottle(float wheelthrottle) {
		this.wheelthrottle = wheelthrottle;
	}

	/**
	 * @return the wheels
	 */
	public boolean isWheels() {
		return wheels;
	}

	/**
	 * @param wheels the wheels to set
	 */
	public void setWheels(boolean wheels) {
		this.wheels = wheels;
	}

	/**
	 * @return the yaw
	 */
	public float getYaw() {
		return yaw;
	}

	/**
	 * @param yaw the yaw to set
	 */
	public void setYaw(float yaw) {
		this.yaw = yaw;
	}

}
