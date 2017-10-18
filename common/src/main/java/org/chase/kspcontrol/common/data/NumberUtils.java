package org.chase.kspcontrol.common.data;

public class NumberUtils {
	public static float specialFloating(float value) {
		if (Float.isFinite(value)) {
			return value;
		} else {
			return -1;
		}
	}
	
	public static double specialFloating(double value) {
		if (Double.isFinite(value)) {
			return value;
		} else {
			return -1;
		}
	}
}
