package org.chase.kspcontrol.client.view.panels;

public interface KSPPane {
	public int getPaneHeight();
	public int getPaneWidth();
	
	public String getTitle();
	public KSPPane getInstance();
	
	public void destroy();
}
