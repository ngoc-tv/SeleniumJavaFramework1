package demo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Course2 {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/form");
		
		sbmitForm(driver);
		
		waitForAlertBanner(driver);
		
		assertEquals("The form was successfully submitted!", getAlertBannerText(driver));
		
		driver.quit();
	}
	
	public static void sbmitForm(WebDriver driver) {
		
		//driver.findElement(By.id("first-name")).sendKeys("Ngoc");
		//Input text into textbox without sendkeys()
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('first-name').value='ngoc'");
		
		driver.findElement(By.id("last-name")).sendKeys("Vu");
		driver.findElement(By.id("job-title")).sendKeys("Engineer");
		driver.findElement(By.id("radio-button-1")).click();
		driver.findElement(By.id("checkbox-2")).click();
		driver.findElement(By.cssSelector("option[value='1']")).click();
		driver.findElement(By.id("datepicker")).sendKeys("02/01/2022");
		driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
		driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
	}
	public static void waitForAlertBanner(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
	}
	public static String getAlertBannerText(WebDriver driver) {
		return driver.findElement(By.className("alert")).getText();
	}
}
