package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemoWithTestNG {

	ExtentSparkReporter htmlReporter = null;
	ExtentReports extent = null;
	static WebDriver driver = null;
		
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentSparkReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
	}
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/geckodriver");
		driver = new FirefoxDriver();
		
	}
	
	@Test	
	public void test1() {
		ExtentTest test = extent.createTest("My first test", "sample description");
		
		driver.get("https://www.google.com/");
		test.info("navigate to google.com");
		
		test.log(Status.INFO, "Starting test cases");
		test.info("usage of info");
		test.fail("detail", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
		
	}
	@Test	
	public void test2() {
		ExtentTest test = extent.createTest("My first test", "sample description");
		
		test.log(Status.INFO, "Starting test cases");
		test.info("usage of info");
		test.pass("detail", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@AfterTest
	public void tearDownTest() {

		driver.quit();
		System.out.println("Test completed successfully");
				
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();		
	}

}
