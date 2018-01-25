package org.chase.kspcontrol.client.view;

import java.time.Duration;

import com.amjjd.unitformat.UnitFormat;

public class Formats {
	public static UnitFormat ufAltitude;
	
	static {
		ufAltitude = UnitFormat.getSIInstance("m");
		ufAltitude.setNextUnitAt(100000.00);
		ufAltitude.setMaximumFractionDigits(0);
	}
	
	public static String formatSec(double seconds) {
		long secondsRound = Math.round(seconds);
		long days = secondsRound/21600;
		long hours = (secondsRound%21600)/3600;
		long minutes = (secondsRound%3600)/60;
		long second = secondsRound%60;
		return String.format("%02d:%02d:%02d:%02d", days, hours, minutes, second);
	}
}
