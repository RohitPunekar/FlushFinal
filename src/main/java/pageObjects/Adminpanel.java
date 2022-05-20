package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Adminpanel {
public WebDriver driver;
	
	public static WebElement element;

	public Adminpanel(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	
	public static WebElement AdminUsername(WebDriver driver)
	{
		return driver.findElement(By.name("email"));
	}
	public static WebElement AdminPassword(WebDriver driver)
	{
		return driver.findElement(By.name("password"));
	}
	public static WebElement AdminPanelLogin(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@type='submit']"));
	}
	
	

	
	

}
