package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {
	public static void main(String[] args) {
		test();
		
	}

public static void test() {
		
		WebDriver driver = null;

		String projectPath = System.getProperty("user.dir"); 
		System.setProperty("webdriver.chrome.driver", projectPath+"//drivers/chromedriver");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		//options.addArguments("Window-size=1280, 800");
		
		driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("q")).sendKeys("Ngoc Vu");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		driver.close();
		System.out.println("Completed");

	}
}
