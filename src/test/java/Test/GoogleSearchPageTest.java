package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.GoogleSearchPageObject;

public class GoogleSearchPageTest {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		googleSearchTest();

	}
	
	public static void googleSearchTest() {
		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/geckodriver");
		driver = new FirefoxDriver();
		
		//go to google.com
		driver.get("https://www.google.com/");
		
		GoogleSearchPageObject searchPageObj = new GoogleSearchPageObject(driver);
		searchPageObj.setTextInsearchBox("Ngoc Vu");
		searchPageObj.SearchWithoutButton();
		
		//close browser
		driver.close();
		
		System.out.println("Test completed successfully");
	}
	
		
		

}
