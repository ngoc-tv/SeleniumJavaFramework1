package demo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Formy_Test1 {

	public static void main(String[] args) {
		//autoComplete();
		scroll();
		//switchWindow();
		//switchToAlert();
		//javaScriptCommand();
		//dragAndDrop();
		//radioButton();
		//checkBox();
		//datePicker();
		//dropDownMenu();
		//fileUpload();
	}
	
	public static void inputName() {
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/keypress");
		
		WebElement name = driver.findElement(By.id("name"));
		name.click();
		name.sendKeys("Ngoc");
		
		WebElement button = driver.findElement(By.id("button"));
		button.click();
		driver.close();
	}
	// For "using autocomplete"
	public static void autoComplete() {
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/maps");
		
		WebElement autoComplete = driver.findElement(By.id("searchboxinput"));
		autoComplete.sendKeys("1555 Park blvd, palo alto, CA");
		
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//List<WebElement> elements = driver.findElements(By.xpath("//div[@role = 'gridcell']"));
		//WebElement autoCompleteResult = elements.get(0);
		//autoCompleteResult.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role = 'gridcell']")));
		List<WebElement> elements = driver.findElements(By.xpath("//div[@role = 'gridcell']"));
		WebElement autoCompleteResult = elements.get(0);
		autoCompleteResult.click();
		
		driver.quit();
	}
	// For "Scroll to element"
	public static void scroll() {
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/scroll");
		
		WebElement name = driver.findElement(By.id("name"));
		Actions action =new Actions(driver);
		action.moveToElement(name);
		name.sendKeys("Ngoc Vu");
		
		WebElement date = driver.findElement(By.id("date"));
		date.sendKeys("01/29/2022");
		
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/login.png");
        try {
			FileUtils.copyFile(srcFile, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//driver.close();
	}
	//For "Switch to active window" 
	public static void switchWindow() {
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/switch-window");
		
		WebElement newTabBttn = driver.findElement(By.id("new-tab-button"));
		newTabBttn.click();
		
		String originalHandle = driver.getWindowHandle();
		for(String handle1: driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
		}
		driver.switchTo().window(originalHandle);
			
		//driver.close();
	}
	//Switch to alert
	public static void switchToAlert() {
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/switch-window");
		
		WebElement alertBttn = driver.findElement(By.id("alert-button"));
		alertBttn.click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();	
	}
	//Executing JavaScript command
	public static void javaScriptCommand() {
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/modal");
		
		WebElement modalBttn = driver.findElement(By.id("modal-button"));
		modalBttn.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement closeBttn = driver.findElement(By.id("close-button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", closeBttn);
	}
		
	//Drag and Drop
		public static void dragAndDrop() {
			String projectPath= System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://formy-project.herokuapp.com/dragdrop");
			
			WebElement image = driver.findElement(By.id("image"));

			WebElement box = driver.findElement(By.id("box"));
			
			Actions action = new Actions(driver);
			action.dragAndDrop(image, box).build().perform();
		}

		//Radio button
		public static void radioButton() {
			String projectPath= System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://formy-project.herokuapp.com/radiobutton");
			
			WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
			radioButton1.click();
			
			WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
			radioButton2.click();
			
			//WebElement radioButton3 = driver.findElement(By.cssSelector("input[value='option3']"));
			WebElement radioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
			radioButton3.click();
			
		}
		//Checkbox
		public static void checkBox() {
			String projectPath= System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://formy-project.herokuapp.com/checkbox");
			
			WebElement checkBox1 = driver.findElement(By.id("checkbox-1"));
			checkBox1.click();
			
			WebElement checkBox2 = driver.findElement(By.id("checkbox-2"));
			checkBox2.click();
			
			//WebElement radioButton3 = driver.findElement(By.cssSelector("input[value='option3']"));
			WebElement checkBox3 = driver.findElement(By.cssSelector("#checkbox-3"));
			checkBox3.click();
		}		
		//Date picker
		public static void datePicker() {
			String projectPath= System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://formy-project.herokuapp.com/datepicker");
			
			WebElement dateField = driver.findElement(By.id("datepicker"));
			dateField.sendKeys("02/04/2022");
			dateField.sendKeys(Keys.RETURN);
		}		
		
		//Dropdown Menu
		public static void dropDownMenu() {
			String projectPath= System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://formy-project.herokuapp.com/dropdown");
			
			WebElement dropDownMenu = driver.findElement(By.id("dropdownMenuButton"));
			dropDownMenu.click();
			
			WebElement autoCompleteItem = driver.findElement(By.id("autocomplete"));
			autoCompleteItem.click();
		}
		//File Upload
		public static void fileUpload() {
			String projectPath= System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://formy-project.herokuapp.com/fileupload");
			
			WebElement fileUpload = driver.findElement(By.id("file-upload-field"));
			fileUpload.sendKeys("28411.pdf");
		}		
}
