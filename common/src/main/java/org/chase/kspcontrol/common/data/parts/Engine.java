package org.chase.kspcontrol.common.data.parts;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import krpc.client.RPCException;

public class Engine extends Part {
	private krpc.client.services.SpaceCenter.Engine controlObject;
	private boolean active;
	private boolean automodeswitch;
	private float availablethrust;
	// private Pair availabletorque;
	private boolean canrestart;
	private boolean canshutdown;
	private float gimballimit;
	private boolean gimballocked;
	private float gimbalrange;
	private boolean gimballed;
	private boolean hasfuel;
	private boolean hasmodes;
	private float kerbinsealevelspecificimpulse;
	private float maxthrust;
	private float maxvacuumthrust;
	private String mode;
	private Map modes;
	private List propellantnames;
	private Map propellantratios;
	private List propellants;
	private float specificimpulse;
	private float throttle;
	private boolean throttlelocked;
	private float thrust;
	private float thrustlimit;
	private List thrusters;
	private float vacuumspecificimpulse;

	public Engine(krpc.client.services.SpaceCenter.Engine engine) throws RPCException, IOException {
		super(engine.getPart());

		controlObject = engine;
		active = engine.getActive();
		automodeswitch = engine.getAutoModeSwitch();
		availablethrust = engine.getAvailableThrust();
		// availabletorque = engine.getAvailableTorque();
		canrestart = engine.getCanRestart();
		canshutdown = engine.getCanShutdown();
		gimballimit = engine.getGimbalLimit();
		gimballocked = engine.getGimbalLocked();
		gimbalrange = engine.getGimbalRange();
		gimballed = engine.getGimballed();
		hasfuel = engine.getHasFuel();
		hasmodes = engine.getHasModes();
		kerbinsealevelspecificimpulse = engine.getKerbinSeaLevelSpecificImpulse();
		maxthrust = engine.getMaxThrust();
		maxvacuumthrust = engine.getMaxVacuumThrust();
		mode = engine.getMode();
		modes = engine.getModes();
		propellantnames = engine.getPropellantNames();
		propellantratios = engine.getPropellantRatios();
		propellants = engine.getPropellants();
		specificimpulse = engine.getSpecificImpulse();
		throttle = engine.getThrottle();
		throttlelocked = engine.getThrottleLocked();
		thrust = engine.getThrust();
		thrustlimit = engine.getThrustLimit();
		thrusters = engine.getThrusters();
		vacuumspecificimpulse = engine.getVacuumSpecificImpulse();

	}

	public String parse(String method, Object... params) throws RPCException, IOException {
		super.parse(method, params);
		switch (method) {
		case "autoModeSwitch":
			controlObject.setAutoModeSwitch((boolean) params[0]);
			break;
		case "gimbalLimit":
			controlObject.setGimbalLimit((float) params[0]);
			break;
		case "active":
			controlObject.setActive((boolean) params[0]);
			break;
		case "thrustLimit":
			controlObject.setThrustLimit((float) params[0]);
			break;
		case "mode":
			controlObject.setMode((String) params[0]);
			break;
		case "gimbalLocked":
			controlObject.setGimbalLocked((boolean) params[0]);
			break;
		}
		return "worked";
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the automodeswitch
	 */
	public boolean isAutomodeswitch() {
		return automodeswitch;
	}

	/**
	 * @param automodeswitch the automodeswitch to set
	 */
	public void setAutomodeswitch(boolean automodeswitch) {
		this.automodeswitch = automodeswitch;
	}

	/**
	 * @return the availablethrust
	 */
	public float getAvailablethrust() {
		return availablethrust;
	}

	/**
	 * @param availablethrust the availablethrust to set
	 */
	public void setAvailablethrust(float availablethrust) {
		this.availablethrust = availablethrust;
	}

	/**
	 * @return the canrestart
	 */
	public boolean isCanrestart() {
		return canrestart;
	}

	/**
	 * @param canrestart the canrestart to set
	 */
	public void setCanrestart(boolean canrestart) {
		this.canrestart = canrestart;
	}

	/**
	 * @return the canshutdown
	 */
	public boolean isCanshutdown() {
		return canshutdown;
	}

	/**
	 * @param canshutdown the canshutdown to set
	 */
	public void setCanshutdown(boolean canshutdown) {
		this.canshutdown = canshutdown;
	}

	/**
	 * @return the gimballimit
	 */
	public float getGimballimit() {
		return gimballimit;
	}

	/**
	 * @param gimballimit the gimballimit to set
	 */
	public void setGimballimit(float gimballimit) {
		this.gimballimit = gimballimit;
	}

	/**
	 * @return the gimballocked
	 */
	public boolean isGimballocked() {
		return gimballocked;
	}

	/**
	 * @param gimballocked the gimballocked to set
	 */
	public void setGimballocked(boolean gimballocked) {
		this.gimballocked = gimballocked;
	}

	/**
	 * @return the gimbalrange
	 */
	public float getGimbalrange() {
		return gimbalrange;
	}

	/**
	 * @param gimbalrange the gimbalrange to set
	 */
	public void setGimbalrange(float gimbalrange) {
		this.gimbalrange = gimbalrange;
	}

	/**
	 * @return the gimballed
	 */
	public boolean isGimballed() {
		return gimballed;
	}

	/**
	 * @param gimballed the gimballed to set
	 */
	public void setGimballed(boolean gimballed) {
		this.gimballed = gimballed;
	}

	/**
	 * @return the hasfuel
	 */
	public boolean isHasfuel() {
		return hasfuel;
	}

	/**
	 * @param hasfuel the hasfuel to set
	 */
	public void setHasfuel(boolean hasfuel) {
		this.hasfuel = hasfuel;
	}

	/**
	 * @return the hasmodes
	 */
	public boolean isHasmodes() {
		return hasmodes;
	}

	/**
	 * @param hasmodes the hasmodes to set
	 */
	public void setHasmodes(boolean hasmodes) {
		this.hasmodes = hasmodes;
	}

	/**
	 * @return the kerbinsealevelspecificimpulse
	 */
	public float getKerbinsealevelspecificimpulse() {
		return kerbinsealevelspecificimpulse;
	}

	/**
	 * @param kerbinsealevelspecificimpulse the kerbinsealevelspecificimpulse to set
	 */
	public void setKerbinsealevelspecificimpulse(float kerbinsealevelspecificimpulse) {
		this.kerbinsealevelspecificimpulse = kerbinsealevelspecificimpulse;
	}

	/**
	 * @return the maxthrust
	 */
	public float getMaxthrust() {
		return maxthrust;
	}

	/**
	 * @param maxthrust the maxthrust to set
	 */
	public void setMaxthrust(float maxthrust) {
		this.maxthrust = maxthrust;
	}

	/**
	 * @return the maxvacuumthrust
	 */
	public float getMaxvacuumthrust() {
		return maxvacuumthrust;
	}

	/**
	 * @param maxvacuumthrust the maxvacuumthrust to set
	 */
	public void setMaxvacuumthrust(float maxvacuumthrust) {
		this.maxvacuumthrust = maxvacuumthrust;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the modes
	 */
	public Map getModes() {
		return modes;
	}

	/**
	 * @param modes the modes to set
	 */
	public void setModes(Map modes) {
		this.modes = modes;
	}

	/**
	 * @return the propellantnames
	 */
	public List getPropellantnames() {
		return propellantnames;
	}

	/**
	 * @param propellantnames the propellantnames to set
	 */
	public void setPropellantnames(List propellantnames) {
		this.propellantnames = propellantnames;
	}

	/**
	 * @return the propellantratios
	 */
	public Map getPropellantratios() {
		return propellantratios;
	}

	/**
	 * @param propellantratios the propellantratios to set
	 */
	public void setPropellantratios(Map propellantratios) {
		this.propellantratios = propellantratios;
	}

	/**
	 * @return the propellants
	 */
	public List getPropellants() {
		return propellants;
	}

	/**
	 * @param propellants the propellants to set
	 */
	public void setPropellants(List propellants) {
		this.propellants = propellants;
	}

	/**
	 * @return the specificimpulse
	 */
	public float getSpecificimpulse() {
		return specificimpulse;
	}

	/**
	 * @param specificimpulse the specificimpulse to set
	 */
	public void setSpecificimpulse(float specificimpulse) {
		this.specificimpulse = specificimpulse;
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
	 * @return the throttlelocked
	 */
	public boolean isThrottlelocked() {
		return throttlelocked;
	}

	/**
	 * @param throttlelocked the throttlelocked to set
	 */
	public void setThrottlelocked(boolean throttlelocked) {
		this.throttlelocked = throttlelocked;
	}

	/**
	 * @return the thrust
	 */
	public float getThrust() {
		return thrust;
	}

	/**
	 * @param thrust the thrust to set
	 */
	public void setThrust(float thrust) {
		this.thrust = thrust;
	}

	/**
	 * @return the thrustlimit
	 */
	public float getThrustlimit() {
		return thrustlimit;
	}

	/**
	 * @param thrustlimit the thrustlimit to set
	 */
	public void setThrustlimit(float thrustlimit) {
		this.thrustlimit = thrustlimit;
	}

	/**
	 * @return the thrusters
	 */
	public List getThrusters() {
		return thrusters;
	}

	/**
	 * @param thrusters the thrusters to set
	 */
	public void setThrusters(List thrusters) {
		this.thrusters = thrusters;
	}

	/**
	 * @return the vacuumspecificimpulse
	 */
	public float getVacuumspecificimpulse() {
		return vacuumspecificimpulse;
	}

	/**
	 * @param vacuumspecificimpulse the vacuumspecificimpulse to set
	 */
	public void setVacuumspecificimpulse(float vacuumspecificimpulse) {
		this.vacuumspecificimpulse = vacuumspecificimpulse;
	}
	
	

}
