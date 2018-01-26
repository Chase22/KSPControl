package org.chase.kspcontrol.common.config;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ConfigUpdater {
	public static Integer getVersionOfConfig(File configFile) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(configFile);
		
		doc.getDocumentElement().normalize();
		
		String versionString = doc.getDocumentElement().getAttribute("version");
		
		return Integer.parseInt(versionString);
	}
	
}
