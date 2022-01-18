package listeners;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.SkipException;

public class TestNGListenerDemo2 {
	
	@Test
	public void test1() {
		System.out.println("I'm inside test 1");
	}
	@Test
	public void test2() {
		System.out.println("I'm inside test 2");
		
		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.google.com/");
		driver.findElement(By.name("abc")).sendKeys("Ngoc Vu");
		driver.quit();
		}
	@Test
	public void test3() {
		System.out.println("I'm inside test 3");
		throw new SkipException("This step is skipped");
	}
}
