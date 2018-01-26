package org.chase.kspcontrol.common.config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class Config {
	public static final String CONFIG_COMMON = "common";
	public static final String CONFIG_CLIENT = "client";
	public static final String CONFIG_SERVER = "server";
	
	private static final String CONFIG_PATH = "KerbalMissionControl/config/config.xml";

	private String prefix;
	private XMLConfiguration config;

	public static Config getCommonConfig() throws ConfigurationException, IOException {
		return new Config(CONFIG_COMMON);
	}

	public static Config getClientConfig() throws ConfigurationException, IOException {
		return new Config(CONFIG_CLIENT);
	}

	public static Config getServerConfig() throws ConfigurationException, IOException {
		return new Config(CONFIG_SERVER);
	}

	public Config(String prefix) throws ConfigurationException, IOException {
		this.prefix = prefix;
		loadConfig();
	}

	public void loadConfig() throws ConfigurationException, IOException {
		File configFile = FileUtils.getFile(FileUtils.getUserDirectoryPath(), CONFIG_PATH);
		if (!configFile.exists()) {
			FileUtils.copyFile(new XMLConfiguration("config.xml").getFile(), configFile);
		}
		config = new XMLConfiguration(configFile);
	}
	
	public static void main(String[] args) throws ConfigurationException, IOException {
		System.out.println(FileUtils.getFile(FileUtils.getUserDirectoryPath(), Config.CONFIG_PATH).getAbsolutePath());
		getCommonConfig();
	}
}
