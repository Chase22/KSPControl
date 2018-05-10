package org.chase.kspcontrol.client.view.formats;

import java.time.Duration;

import com.amjjd.unitformat.UnitFormat;

public class Formats {
	public static final UnitFormat ufAltitude;
	public static final UnitFormat ufSpeed;
	
	static {
		ufAltitude = UnitFormat.getSIInstance("m");
		ufAltitude.setNextUnitAt(100000.00);
		ufAltitude.setMaximumFractionDigits(0);
		
		ufSpeed = UnitFormat.getSIInstance("m/s");
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
