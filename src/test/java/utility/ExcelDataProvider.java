package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelDataProvider {

	static WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		
		//BasicConfigurator.configure();
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"//drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test(dataProvider = "test1Data")
	public void test1(String userName, String passWord) throws InterruptedException {
		System.out.println("test1: " + userName + " | " + passWord);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).sendKeys(passWord);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
	}

	@DataProvider(name = "test1Data")
	public Object[][] getData() {
		String projectpath = System.getProperty("user.dir");
		String excelPath = projectpath+"/excel/data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount]; 
		
		for(int i=1 ; i < rowCount; i++) {
			for(int j=0; j< colCount; j++){
			 String cellData =	ExcelUtils.getCellDataString(i, j);
			 System.out.print("testData " + cellData + " | ");
			 data[i-1][j] = cellData;
			}
			System.out.println();
		}
		return data;
		
	}
}
