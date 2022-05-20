package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountDropdown {
public WebDriver driver;
	
	public static WebElement element;

	public AccountDropdown(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	public static WebElement Cashier(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Cashier']"));
	}
	
	public static WebElement VIP(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='VIP']"));
	}
	
	public static WebElement Transaction(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Transactions']"));
	}
	
	public static WebElement Statistics(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Statistics']"));
	}
	public static WebElement Settings(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Logout']"));
	}
	
	
	
	
	
}


