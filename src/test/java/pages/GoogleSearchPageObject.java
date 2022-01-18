package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObject {
	
	WebDriver driver = null;
	
	By Textbox_search = By.name("q");
	By Button_search  = By.name("btnK");
	
	public GoogleSearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
public void setTextInsearchBox(String text){
	
	driver.findElement(Textbox_search).sendKeys(text);
}

public void SearchWithoutButton(){
	
	driver.findElement(Textbox_search).sendKeys(Keys.RETURN);
}

public void ClickSearchButton(){
	
	driver.findElement(Button_search).sendKeys(Keys.RETURN);
}


}
