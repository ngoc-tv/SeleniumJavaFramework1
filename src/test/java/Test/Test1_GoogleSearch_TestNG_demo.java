package Test;

import org.testng.annotations.Test;

import config.PropertiesFile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Test1_GoogleSearch_TestNG_demo {
	
	static WebDriver driver = null;
	public static String browserName = null;

	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getPropeties();

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"//drivers/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		//logger.info("Browser started");
	}
	
	@Test
	public static void googleSearch() {
		
		//go to google.com
		driver.get("https://www.google.com/");
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Ngoc Vu");
		
		//Click on search button
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void tearDownTest() {
		//close browser
		//driver.close();
		driver.quit();
		System.out.println("Test completed successfully");
		PropertiesFile.setProperties();
				
	}

}

