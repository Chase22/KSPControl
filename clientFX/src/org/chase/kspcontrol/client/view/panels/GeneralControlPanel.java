package org.chase.kspcontrol.client.view.panels;

import org.chase.kspcontrol.client.ClientContext;
import org.chase.kspcontrol.client.view.components.ToggleComponent;
import org.chase.kspcontrol.common.data.GeneralControl;
import org.chase.kspcontrol.common.network.KSPUpdateHandler;

import javafx.scene.layout.FlowPane;

public class GeneralControlPanel extends FlowPane  implements KSPUpdateHandler<GeneralControl>, KSPPane {
	
	ToggleComponent light = new ToggleComponent("Lights", new GeneralControl().getPrefix(), "lights", false);
	ToggleComponent gear = new ToggleComponent("Gear", new GeneralControl().getPrefix(), "gear", false);
	ToggleComponent legs = new ToggleComponent("Legs", new GeneralControl().getPrefix(), "legs", false);
	ToggleComponent solar = new ToggleComponent("Solarpanels", new GeneralControl().getPrefix(), "solarPanels", false);
	ToggleComponent radiators = new ToggleComponent("Radiators", new GeneralControl().getPrefix(), "radiators", false);
	ToggleComponent cargoBays = new ToggleComponent("Cargobays", new GeneralControl().getPrefix(), "cargoBays", false);
	ToggleComponent antennas = new ToggleComponent("Antennas", new GeneralControl().getPrefix(), "antennas", false);

	public GeneralControlPanel() {
		ClientContext.getInstance().getMQClient().getHandler(new GeneralControl().getPrefix()).register(this);
		
		this.getChildren().add(legs);
		this.getChildren().add(light);
		this.getChildren().add(gear);
		this.getChildren().add(solar);
		this.getChildren().add(radiators);
		this.getChildren().add(cargoBays);
		this.getChildren().add(antennas);
	}
	
	@Override
	public int getPaneHeight() {
		return 3;
	}

	@Override
	public int getPaneWidth() {
		return 3;
	}

	@Override
	public void handle(GeneralControl control) {
		light.setCurrentState(control.isLights());
		gear.setCurrentState(control.isGear());
		legs.setCurrentState(control.isLegs());
		solar.setCurrentState(control.isSolarpanels());
		radiators.setCurrentState(control.isRadiators());
		cargoBays.setCurrentState(control.isCargobays());
		antennas.setCurrentState(control.isAntennas());
	}

}
