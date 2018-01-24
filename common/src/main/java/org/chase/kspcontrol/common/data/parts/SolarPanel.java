package org.chase.kspcontrol.common.data.parts;

import java.io.IOException;

import krpc.client.RPCException;

public class SolarPanel extends Part {
	private transient krpc.client.services.SpaceCenter.SolarPanel controlSolarpanel;
	private boolean deployable;
	private boolean deployed;
	private float energyflow;
	private String state;
	private float sunexposure;

	public SolarPanel(krpc.client.services.SpaceCenter.SolarPanel solarpanel)
			throws RPCException, IOException {
		super(solarpanel.getPart());
		
		controlSolarpanel = solarpanel;
		deployable = solarpanel.getDeployable();
		deployed = solarpanel.getDeployed();
		energyflow = solarpanel.getEnergyFlow();
		state = solarpanel.getState().name();
		sunexposure = solarpanel.getSunExposure();
	}

	public String parse(String method, Object... params) throws RPCException, IOException {
		super.parse(method, params);
		switch (method) {
		case "deployed":
			controlSolarpanel.setDeployed((boolean) params[0]);
			break;
		}
		return "worked";
	}

	/**
	 * @return the deployable
	 */
	public boolean isDeployable() {
		return deployable;
	}

	/**
	 * @param deployable the deployable to set
	 */
	public void setDeployable(boolean deployable) {
		this.deployable = deployable;
	}

	/**
	 * @return the deployed
	 */
	public boolean isDeployed() {
		return deployed;
	}

	/**
	 * @param deployed the deployed to set
	 */
	public void setDeployed(boolean deployed) {
		this.deployed = deployed;
	}

	/**
	 * @return the energyflow
	 */
	public float getEnergyflow() {
		return energyflow;
	}

	/**
	 * @param energyflow the energyflow to set
	 */
	public void setEnergyflow(float energyflow) {
		this.energyflow = energyflow;
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
	 * @return the sunexposure
	 */
	public float getSunexposure() {
		return sunexposure;
	}

	/**
	 * @param sunexposure the sunexposure to set
	 */
	public void setSunexposure(float sunexposure) {
		this.sunexposure = sunexposure;
	}
	
}
