import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_demo {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");		
		DesiredCapabilities caps= new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		System.setProperty("webdriver.gecko.driver",projectPath + "//drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("ABC");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.quit();

	}

}
