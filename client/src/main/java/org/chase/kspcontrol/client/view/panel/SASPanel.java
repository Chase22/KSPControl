package org.chase.kspcontrol.client.view.panel;

import org.chase.kspcontrol.client.view.component.ToggleButtonPanel;
import org.chase.kspcontrol.common.data.GeneralControl;
import org.chase.kspcontrol.common.data.Orbit;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;

public class SASPanel extends Panel implements KSPUpdateHandler<GeneralControl> {

	private ToggleButtonPanel mainControl = new ToggleButtonPanel("SAS", new GeneralControl().getPrefix(), "SAS");
	
	public void handle(GeneralControl object) {
		
	}

}
