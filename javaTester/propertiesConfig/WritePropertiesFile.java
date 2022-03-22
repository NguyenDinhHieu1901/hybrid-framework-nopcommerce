package propertiesConfig;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WritePropertiesFile {
	
	public void createPropertiesFile(String propertiesFilePath) {
		Properties prop = new Properties();
		try {
			OutputStream output = new FileOutputStream(propertiesFilePath);
			prop.setProperty("db.url", "localhost");
			prop.setProperty("db.user", "root");
			prop.setProperty("db.password", "secret");
			try {
				prop.store(output, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
