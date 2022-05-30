package variables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class ConfigProperties {

	public static Properties property;
	private static String configpath = "FlushProperties/Flush.properties";
	private static String configpath2 = "FlushProperties/Login.properties";
	private static String configpath3 = "FlushProperties/settings.properties";


	public static void FlushPropertiesFile() {
		property = new Properties();
		try {
			InputStream fis = new FileInputStream(configpath);
			try {
				property.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void LoginPropertiesFile()
	{
		property = new Properties();
		try {
			InputStream fis1 = new FileInputStream(configpath2);
			try {
				property.load(fis1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void SettingsPropertiesFile()
	{
		property = new Properties();
		try {
			InputStream fis2 = new FileInputStream(configpath3);
			try {
				property.load(fis2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
