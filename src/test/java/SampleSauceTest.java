import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Tests for running Headless on Sauce.
 */
public class SampleSauceTest {

	public static final String URL = "https://ondemand.us-west-1.saucelabs.com/wd/hub";
	
    public static void main(String[] args) throws Exception  {

    	ChromeOptions options = new ChromeOptions();
    	options.setPlatformName("Linux");
    	options.setBrowserVersion("latest");
    	

    	Map<String, Object> sauceOptions = new HashMap<>();					
    	sauceOptions.put("username", "oauth-vungoc1986-58d28");
    	sauceOptions.put("accessKey", "0465ae52-5475-4d20-a9f2-0c52c876e984");
    	sauceOptions.put("name", "name");

    	options.setCapability("sauce:options", sauceOptions);
    	
    	RemoteWebDriver driver = new RemoteWebDriver(new URL(URL), options);
        
        driver.get("http://google.com");
        System.out.println("title of page is: " + driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Ngoc Vu");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		System.out.println("title of page is: " + driver.getTitle());
		 System.out.println("Test completed");
        driver.quit();
    }

 
}