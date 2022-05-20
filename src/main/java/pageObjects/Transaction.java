package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Transaction {
public WebDriver driver;
	
	public static WebElement element;

	public Transaction(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public static WebElement TransactionHeader(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[text()='Transactions'])[1]"));
	}
	
	public static WebElement BetsTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='BETS']"));
	}
	public static WebElement WithDrawlTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Withdrawals']"));
	}
	public static WebElement RewardsTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Rewards']"));
	}
	public static WebElement DepositTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Deposits']"));
	}
}
