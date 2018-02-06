package org.chase.kspcontrol.common;

public class NotInitialisedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotInitialisedException() {
		super("The Object was not initialised");
	}

}
