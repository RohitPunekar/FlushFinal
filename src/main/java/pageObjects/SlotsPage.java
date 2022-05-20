package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SlotsPage {

	public WebDriver driver;

	public static WebElement element;

	public SlotsPage(WebDriver driver) 
	{
		this.driver=driver;
	}


	public static WebElement SlotsGameSearch(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@placeholder='Search']"));
	}
	}


