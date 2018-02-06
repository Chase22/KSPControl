package org.chase.kspcontrol.client.view;

import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

public class StyleProcessor {
	static Set<Class<?>> findAllMessageDrivenClasses() {
		final Reflections reflections = new Reflections("org.chase.kspcontrol", new TypeAnnotationsScanner());
		Set<Class<?>> allMessageDrivens = reflections.getTypesAnnotatedWith(StyleAnotation.class); // NOTE HERE
		return allMessageDrivens;
	}
	
	static void addStyleClasses() {
		
	}
}
