package org.chase.kspcontrol.client.view.formats;

import javafx.util.StringConverter;

public class HeightTextConverter extends StringConverter<Double> {

	@Override
	public Double fromString(String string) {
		return null;
	}

	@Override
	public String toString(Double object) {
		return Formats.ufAltitude.format(object);
	}

}
