package propertiesConfig;

import commons.GlobalConstants;

public class TestPropertiesFile {
	public static void main(String[] args) {
		WritePropertiesFile write = new WritePropertiesFile();
		write.createPropertiesFile(GlobalConstants.PROJECT_PATH + "/javaTester/propertiesConfig/config.properties");
		System.out.println(ReadPropertyFileWithSingleton.getInstance().getProperty("db.url"));
		System.out.println(ReadPropertyFileWithSingleton.getInstance().getProperty("db.user"));
		System.out.println(ReadPropertyFileWithSingleton.getInstance().getProperty("db.password"));
	}

}
