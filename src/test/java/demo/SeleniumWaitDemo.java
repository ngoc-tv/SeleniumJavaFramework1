package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.googleSearchPage;

public class SeleniumWaitDemo {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearch();
		
	}
	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver", projectPath+"//drivers/chromedriver");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Ngoc Vu");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));
		
		
		driver.findElement(By.name("abc")).click();
		
		driver.close();
	}
}
