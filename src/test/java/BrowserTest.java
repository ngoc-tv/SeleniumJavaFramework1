import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {
	public static void main(String[] args) throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		
		System.setProperty("webdriver.gecko.driver",projectPath + "//drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver",projectPath +  "//drivers/chromedriver");
		//WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com/");
//		driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[2]/div[2]/input[1]")).sendKeys("Ngoc Vu");
//		find single element
//		WebElement textbox = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
//		textbox.sendKeys("Ngoc Vu");
		//find list of elements
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		int count = listOfInputElements.size();
		System.out.println("Count of input elements:" +count);
		
		
		Thread.sleep(3000);
		
		driver.close();
	}

}
