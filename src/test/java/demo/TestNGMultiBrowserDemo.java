package demo;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class TestNGMultiBrowserDemo {

	WebDriver driver= null;
	String projectPath = System.getProperty("user.dir");


	@BeforeTest
	@Parameters("browserName")
	public void setup(String browserName) {
		
		System.out.println("Browser Name:"+browserName);
		System.out.println("Thread id: "+Thread.currentThread().getId());

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+ "//drivers/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", projectPath+"//drivers/geckodriver");
			driver = new InternetExplorerDriver();
		}
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https://google.com");
		Thread.sleep(3000);
	}
	
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		System.out.println("Test complete.");
	}
}
