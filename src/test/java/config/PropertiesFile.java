package config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Test.Test1_GoogleSearch_TestNG_demo;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String projectPath = System.getProperty("user.dir"); 


	public static void main(String[] args) {

		getPropeties();
		setProperties();
		getPropeties();
	}
	
	public static void getPropeties() {
		try {
			InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			Test1_GoogleSearch_TestNG_demo.browserName = browser;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());	
			System.out.println(ex.getCause());
			ex.printStackTrace();
		}
	}
	
	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
			prop.setProperty("result", "pass");
			prop.store(output, null);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());	
			System.out.println(ex.getCause());	
			ex.printStackTrace();
		}
	}

}
