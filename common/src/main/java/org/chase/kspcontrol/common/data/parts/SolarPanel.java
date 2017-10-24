package org.chase.kspcontrol.common.data.parts;

import java.io.IOException;

import krpc.client.RPCException;

public class SolarPanel extends Part {
	private krpc.client.services.SpaceCenter.SolarPanel controlObject;
	private boolean deployable;
	private boolean deployed;
	private float energyflow;
	private Part part;
	private String state;
	private float sunexposure;

	public SolarPanel(krpc.client.services.SpaceCenter.SolarPanel solarpanel)
			throws RPCException, IOException {
		super(solarpanel.getPart());
		
		controlObject = solarpanel;
		deployable = solarpanel.getDeployable();
		deployed = solarpanel.getDeployed();
		energyflow = solarpanel.getEnergyFlow();
		state = solarpanel.getState().name();
		sunexposure = solarpanel.getSunExposure();
	}

	public String parse(String method, Object... params) throws RPCException, IOException {
		part.parse(method, params);
		switch (method) {
		case "deployed":
			controlObject.setDeployed((boolean) params[0]);
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
	 * @return the part
	 */
	public Part getPart() {
		return part;
	}

	/**
	 * @param part the part to set
	 */
	public void setPart(Part part) {
		this.part = part;
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
