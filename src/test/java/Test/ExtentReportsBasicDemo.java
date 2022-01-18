package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBasicDemo {

	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html");

		//create extentreports and attach report
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//create the toggle for the given test, adds all log events under it
		ExtentTest test1 = extent.createTest("My first test", "sample description");
		

		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/geckodriver");
		driver = new FirefoxDriver();
		
		test1.log(Status.INFO, "Starting test cases");
		//go to google.com
		driver.get("https://www.google.com/");
		test1.pass("navigated to google.com");
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Ngoc Vu");
		test1.pass("enter text to search box");
		
		//Click on search button
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("press search");
		
		//close browser
		driver.quit();
		test1.pass("Close browser");

		test1.info("Test1 completed");
		
		//TEST 2
		//create the toggle for the given test, adds all log events under it
		ExtentTest test2 = extent.createTest("My second test", "sample description");
		
		System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/geckodriver");
		driver = new FirefoxDriver();
		
		test2.log(Status.INFO, "Starting test cases");
		//go to google.com
		driver.get("https://www.google.com/");
		test2.pass("navigated to google.com");
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Ngoc Vu");
		test2.pass("enter text to search box");
		
		//Click on search button
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test2.fail("press search");
		
		Thread.sleep(3000);
		
		//close browser
		driver.quit();
		test2.pass("Close browser");

		test2.info("Test2 completed");
		
		//calling flush writes everything to the log file
		extent.flush();		
	}

}
