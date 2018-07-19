package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadFile {

	
	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			FileInputStream input = new FileInputStream("configuration.properties");
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getProperties(String key) {
		String value = prop.getProperty(key);
		return value;
		
	}
	
}
