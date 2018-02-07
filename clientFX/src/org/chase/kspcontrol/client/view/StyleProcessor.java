package org.chase.kspcontrol.client.view;

import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import javafx.scene.Node;

public class StyleProcessor {
	static Set<Class<?>> findAllStyledClasses() {
		final Reflections reflections = new Reflections("org.chase.kspcontrol", new TypeAnnotationsScanner());
		Set<Class<?>> allStyledClasses = reflections.getTypesAnnotatedWith(StyleAnotation.class); // NOTE HERE
		return allStyledClasses;
	}
	
	static void addStyleClasses(Node obj) {
		StyleAnotation an = obj.getClass().getAnnotation(StyleAnotation.class);
		if (an != null) {
			for (String css : an.value()) {
				obj.getStyleClass().add(css);
			}
		}
		
	}
}
