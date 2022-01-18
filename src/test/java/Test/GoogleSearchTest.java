package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.googleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearch();
		
	}
	
	public static void googleSearch() {
		
		
		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/geckodriver");
		driver = new FirefoxDriver();

		//go to google.com
		driver.get("https://www.google.com/");
		
		//enter text in search textbox
		//driver.findElement(By.name("q")).sendKeys("Ngoc Vu");
		googleSearchPage.textbox_search(driver).sendKeys("Ngoc Vu");
		
		//Click on search button
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		//driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		googleSearchPage.textbox_search(driver).sendKeys(Keys.RETURN);

		try {	
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//close browser
		driver.close();
		
		System.out.println("Test completed successfully");
		
	}

}

