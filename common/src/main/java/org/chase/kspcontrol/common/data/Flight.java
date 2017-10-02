package org.chase.kspcontrol.common.data;

import java.io.IOException;

import org.chase.kspcontrol.common.NetworkObject;
import org.javatuples.Quartet;
import org.javatuples.Triplet;

import krpc.client.RPCException;

public class Flight extends NetworkObject<Flight> {
	private float gforce;
	
	//Altitudes
	private double meanAltitude;
	private double surfaceAltitude;
	private double BedrockAltitude;
	private double elevation;
	
	//Geocoordinates
	private double latitude;
	private double longitude;
	
	//Velocitys
	private Triplet<Double, Double, Double> velocity;
	private double speed;
	private double horizontalSpeed;
	private double verticalSpeed;
	
	//Position
	private Triplet<Double, Double, Double> centerOfMass;
	private Quartet<Double, Double, Double, Double> rotation;
	private Triplet<Double, Double, Double> direction;
	
	// Flightdirections
	private float pitch;
	private float heading;
	private float roll;
	
	public static Flight createInstance(krpc.client.services.SpaceCenter.Flight flight) throws RPCException, IOException {
		Flight flightData = new Flight();
		
		flightData.setBedrockAltitude(flight.getBedrockAltitude());
		flightData.setCenterOfMass(flight.getCenterOfMass());
		flightData.setDirection(flight.getDirection());
		flightData.setElevation(flight.getElevation());
		flightData.setGforce(flight.getGForce());
		flightData.setHeading(flight.getHeading());
		flightData.setHorizontalSpeed(flight.getHorizontalSpeed());
		flightData.setLatitude(flight.getLatitude());
		flightData.setLongitude(flight.getLongitude());
		flightData.setMeanAltitude(flight.getMeanAltitude());
		flightData.setPitch(flight.getPitch());
		flightData.setRoll(flight.getRoll());
		flightData.setRotation(flight.getRotation());
		flightData.setSpeed(flight.getSpeed());
		flightData.setSurfaceAltitude(flight.getSurfaceAltitude());
		flightData.setVelocity(flight.getVelocity());
		flightData.setVerticalSpeed(flight.getVerticalSpeed());
		
		return flightData;
	}
	
	@Override
	public String getPrefix() {
		return "FLIGHT";
	}
	
	public float getGforce() {
		return gforce;
	}
	public void setGforce(float gforce) {
		this.gforce = gforce;
	}
	public double getMeanAltitude() {
		return meanAltitude;
	}
	public void setMeanAltitude(double meanAltitude) {
		this.meanAltitude = meanAltitude;
	}
	public double getSurfaceAltitude() {
		return surfaceAltitude;
	}
	public void setSurfaceAltitude(double surfaceAltitude) {
		this.surfaceAltitude = surfaceAltitude;
	}
	public double getBedrockAltitude() {
		return BedrockAltitude;
	}
	public void setBedrockAltitude(double bedrockAltitude) {
		BedrockAltitude = bedrockAltitude;
	}
	public double getElevation() {
		return elevation;
	}
	public void setElevation(double elevation) {
		this.elevation = elevation;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Triplet<Double, Double, Double> getVelocity() {
		return velocity;
	}
	public void setVelocity(Triplet<Double, Double, Double> velocity) {
		this.velocity = velocity;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getHorizontalSpeed() {
		return horizontalSpeed;
	}
	public void setHorizontalSpeed(double horizontalSpeed) {
		this.horizontalSpeed = horizontalSpeed;
	}
	public double getVerticalSpeed() {
		return verticalSpeed;
	}
	public void setVerticalSpeed(double verticalSpeed) {
		this.verticalSpeed = verticalSpeed;
	}
	public Triplet<Double, Double, Double> getCenterOfMass() {
		return centerOfMass;
	}
	public void setCenterOfMass(Triplet<Double, Double, Double> centerOfMass) {
		this.centerOfMass = centerOfMass;
	}
	public Quartet<Double, Double, Double, Double> getRotation() {
		return rotation;
	}
	public void setRotation(Quartet<Double, Double, Double, Double> rotation) {
		this.rotation = rotation;
	}
	public Triplet<Double, Double, Double> getDirection() {
		return direction;
	}
	public void setDirection(Triplet<Double, Double, Double> direction) {
		this.direction = direction;
	}
	public float getPitch() {
		return pitch;
	}
	public void setPitch(float pitch) {
		this.pitch = pitch;
	}
	public float getHeading() {
		return heading;
	}
	public void setHeading(float heading) {
		this.heading = heading;
	}
	public float getRoll() {
		return roll;
	}
	public void setRoll(float roll) {
		this.roll = roll;
	}
	
}
