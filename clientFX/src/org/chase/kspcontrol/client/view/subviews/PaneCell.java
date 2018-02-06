package org.chase.kspcontrol.client.view.subviews;

import org.chase.kspcontrol.client.view.panels.KSPPane;

import javafx.scene.control.ListCell;

public class PaneCell extends ListCell<KSPPane> {
	@Override
	protected void updateItem(KSPPane item, boolean empty) {
		super.updateItem(item, empty);

        if (empty || item == null || item.getTitle() == null) {
            setText(null);
        } else {
            setText(item.getTitle());
        }
	}
}
