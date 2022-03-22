package propertiesConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import commons.GlobalConstants;

public class ReadPropertyFileWithSingleton {
	private static final String CONFIG_FILE_PATH = GlobalConstants.PROJECT_PATH + "/javaTester/propertiesConfig/config.properties";
	private static ReadPropertyFileWithSingleton instance = null;
	private Properties properties;

	private ReadPropertyFileWithSingleton() {
		properties = ReadPropertyFileWithSingleton.readConfig();
	}

	public static ReadPropertyFileWithSingleton getInstance() {
		if (instance == null) {

			System.out.println("Create new Instance");
			instance = new ReadPropertyFileWithSingleton();
			// instance.readConfig();
		} else {
			System.out.println("Exist instance");
		}
		return instance;
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	// Read file .properties
	private static Properties readConfig() {
		Properties properties = new Properties();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(CONFIG_FILE_PATH));
			properties.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed not load file config");
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
}
