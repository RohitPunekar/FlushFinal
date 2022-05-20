package com.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class TestFileinput {

	public String FlushProperty(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(".//FlushProperties//Flush.properties");
		prop.load(fin);

		return prop.getProperty(key);	
	}

	public String LoginProperty(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(".//FlushProperties//Login.properties");
		prop.load(fin);

		return prop.getProperty(key);
	}

	public String SettingsProperty(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(".//FlushProperties//settings.properties");
		prop.load(fin);

		return prop.getProperty(key);
	}

	public String VIPProperty(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(".//FlushProperties//VIP.properties");
		prop.load(fin);

		return prop.getProperty(key);

	}
	
	public String PlinkoProperty(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(".//FlushProperties//Plinko.properties");
		prop.load(fin);

		return prop.getProperty(key);

	}
	
	public String CrashProperty(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(".//FlushProperties//Crash.properties");
		prop.load(fin);

		return prop.getProperty(key);

	}
	
	public String FooterProperty(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(".//FlushProperties//HomepageFooter.properties");
		prop.load(fin);

		return prop.getProperty(key);

	}
}


