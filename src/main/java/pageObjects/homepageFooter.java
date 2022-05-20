package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homepageFooter {
	
	public WebDriver driver;

	public static WebElement element;

	public homepageFooter(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement ProvablyFairLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Provably Fair']"));
	}
	
	public static WebElement ImplementationTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Implementation']"));
	}
	
	public static WebElement OverviewTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Overview']"));
	}
	
	public static WebElement GambleAwareLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Gamble Aware']"));
	}
	
	public static WebElement HomeButtonLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Home']"));
	}
	
	public static WebElement AMLPolicyLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='AML Policy']"));
	}
	
	public static WebElement PrivacyPolicyLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Privacy Policy']"));
	}
	
	public static WebElement KYCPolicyLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='KYC Policy']"));
	}
	
	public static WebElement ResponsibleGamingLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Responsible gaming']"));
	}
	
	public static WebElement TermsOfServiceLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Terms of Service']"));
	}
	
	public static WebElement FooterLanguageChange(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[contains(@class,'gVLtap')]"));
	}
	
	public static WebElement language1(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='ENGLISH']"));
	}
	
	public static WebElement language2(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='中文']"));
	}
	
	public static WebElement language3(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='РУССКИЙ']"));
	}
	
	public static WebElement language4(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='FRANÇAIS']"));
	}
	
	public static WebElement FlushFooterFacebookIcon(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[contains(@class, 'chRxSb')])[1]"));
	}
	
	public static WebElement FlushFooterTwitterIcon(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[contains(@class, 'chRxSb')])[2]"));
	}
	
	public static WebElement FlushFooterInstagramIcon(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[contains(@class, 'chRxSb')])[3]"));
	}
	
	
	
	
	
	

}
