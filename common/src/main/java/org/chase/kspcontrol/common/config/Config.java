package org.chase.kspcontrol.common.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.xml.sax.SAXException;

public class Config {
	public static final String CONFIG_COMMON = "common";
	public static final String CONFIG_CLIENT = "client";
	public static final String CONFIG_SERVER = "server";
	
	private static final String CONFIG_PATH = "KerbalMissionControl/config/config.xml";

	private String prefix;
	private XMLConfiguration config;

	public static Config getCommonConfig() throws ConfigurationException, IOException, URISyntaxException {
		return new Config(CONFIG_COMMON);
	}

	public static Config getClientConfig() throws ConfigurationException, IOException, URISyntaxException {
		return new Config(CONFIG_CLIENT);
	}

	public static Config getServerConfig() throws ConfigurationException, IOException, URISyntaxException {
		return new Config(CONFIG_SERVER);
	}

	public Config(String prefix) throws ConfigurationException, IOException, URISyntaxException {
		this.prefix = prefix;
		loadConfig();
	}

	public void loadConfig() throws ConfigurationException, IOException, URISyntaxException {
		File configFile = FileUtils.getFile(FileUtils.getUserDirectoryPath(), CONFIG_PATH);
		
		if (!configFile.exists() || configFile.length() == 0) {
			InputStream defaultConfig = this.getClass().getResourceAsStream("/config.xml");
			
			FileUtils.copyToFile(defaultConfig, configFile);
		}
		config = new XMLConfiguration(configFile);
	}
	
	public static void main(String[] args) throws ConfigurationException, IOException, URISyntaxException {
		System.out.println(FileUtils.getFile(FileUtils.getUserDirectoryPath(), Config.CONFIG_PATH).getAbsolutePath());
		getCommonConfig();
	}
}
