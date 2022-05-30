package com.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.DiceGamePage;
import pageObjects.Homepage;
import pageObjects.MinesGamePage;
import pageObjects.PlinkoGamePage;
import pageObjects.WelcomePopup;
import resources.base;

public class MinesGameTestCases extends base {
	public WebDriver driver;

	public Homepage homepage;

	public WebDriverWait wait;

	TestFileinput f = new TestFileinput();

	@BeforeMethod
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		log.info("Browser invoked");
	}

	@Test(enabled = true, priority = 1)
	public void LoginAsValidUser() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines Games Betting with Valid user");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		wait = new WebDriverWait(driver, 50);

		//Homepage.Loginbutton(driver).click();
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Loginbutton"))));
			
			Homepage.Loginbutton(driver).click();	
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Relogin"))));
			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

		log.info("User login successful with valid username & password");
		
		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		Actions action = new Actions(driver);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			action.moveToElement( OriginalsHeader).click().perform();
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			OriginalsHeader.click();
		}

		log.info("Scrolling up to originals header");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MinesLink"))));

		MinesGamePage.MinesLink(driver).click();
		
		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));
		
		WebElement walletBalance = MinesGamePage.WalletBalance(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance ="+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in your wallet before BET=  " + DashboardWalletAmount);
		
		System.out.println("Test case Passed");

//		try {
//			WebElement displayed;
//
//			displayed = driver.findElement(By.xpath("//*[text()='PICK RANDOM TILE']"));
//
//			for (int i = 0; i < 24; i++) {
//
//				Thread.sleep(4000);
//
//				displayed.click();
//			}
//
//		} catch (Exception e) {
//			System.out.println("Elapse condition ");
//		}
//
		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 2)
	public void MinesGameBetAfterLogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines Games Betting After Login");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 50);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Loginbutton"))));
			
			Homepage.Loginbutton(driver).click();	
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Relogin"))));
			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

		log.info("User login successful with valid username & password");
		
		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		Actions action = new Actions(driver);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			action.moveToElement( OriginalsHeader).click().perform();
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			OriginalsHeader.click();
		}

		log.info("Scrolling up to originals header");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MinesLink"))));

		MinesGamePage.MinesLink(driver).click();
		
		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));
		
		WebElement walletBalance = MinesGamePage.WalletBalance(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance ="+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");
		
		wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));

		MinesGamePage.BetAmount(driver).click();
		
		log.info("Bet Amount input field clicked Successfully ");
		
		WebElement Amount = MinesGamePage.BetAmount(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		MinesGamePage.MinesDropDown(driver).click();
		
		log.info("Clicked on Mines Dropdown successfully ");
		
		MinesGamePage.MinesDropDown5(driver).click();
		
		log.info("Clicked on Mines Dropdown 5 successfully ");
	
		MinesGamePage.BetButton(driver).click();
		
		log.info("Clicked on BET button successfully");
		
		try
		{
			WebElement displayed;

			displayed = MinesGamePage.PickRandomTile(driver);

			for (int i = 0; i < 24; i++) 
			{
				Thread.sleep(4000);

				displayed.click();
			}

		} 
		catch (Exception e) 
		{
			System.out.println("Elapse condition ");
		}
		
		System.out.println("Test Case Passed");
		
		//VideoRecorder_utlity.stopRecord()
}
	
	@Test(enabled = true, priority = 3)
	public void MinesGameBetMaxAmount() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines Games Betting with Max amount");
	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 50);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Loginbutton"))));
			
			Homepage.Loginbutton(driver).click();	
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Relogin"))));
			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

		log.info("User login successful with valid username & password");
		
		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		Actions action = new Actions(driver);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			action.moveToElement( OriginalsHeader).click().perform();
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			OriginalsHeader.click();
		}

		log.info("Scrolling up to originals header");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MinesLink"))));

		MinesGamePage.MinesLink(driver).click();
		
		log.info("Mines game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='LabelInput__LabelContent-sc-zkip7h-2 ECQgB']/span)[2]")));

		MinesGamePage.MaxAmount(driver).click();
		
		log.info("Mines game MaxAmount clicked successfully");
		
		MinesGamePage.BetAmount(driver).click();
		
		log.info("Mines game Bet Amount clicked successfully");
		
		String ActualText = MinesGamePage.BetAmount(driver).getAttribute("value");
		
		System.out.println("Actual Text= "+ActualText);
		
		String ExpectedText=MinesGamePage.MaxAmount(driver).getAttribute("innerText");
		
		System.out.println("Expected Text= "+ExpectedText);
		
		String MaxAmount = ExpectedText.replaceAll("[^0.0-9]","" );
		
		System.out.println("Expected Max Amount = "+MaxAmount);
		
		Assert.assertEquals(ActualText, MaxAmount,"Failed:Both the results are differernt");
		
		//VideoRecorder_utlity.stopRecord()
		
}
	
	@Test(enabled = true, priority = 4)
	public void MinesErrorMessageForMaxAmount() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines Games Betting with amount more than balance");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 50);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Loginbutton"))));
			
			Homepage.Loginbutton(driver).click();	
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Relogin"))));
			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

		log.info("User login successful with valid username & password");
		
		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		Actions action = new Actions(driver);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			action.moveToElement( OriginalsHeader).click().perform();
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			OriginalsHeader.click();
		}

		log.info("Scrolling up to originals header");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MinesLink"))));

		MinesGamePage.MinesLink(driver).click();
		
		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("WalletBalance"))));
		
		WebElement walletBalance = MinesGamePage.WalletBalance(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance ="+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));
		
		MinesGamePage.BetAmount(driver).click();

		WebElement Amount = MinesGamePage.BetAmount(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("90.00000000");
		
		log.info("Entering some Amount Successfully");
		
		String BetAmount = MinesGamePage.BetAmount(driver).getAttribute("value");
		
		System.out.println("BET Amount= "+BetAmount);
		
		String ErrorMsg = MinesGamePage.ErrorMessage(driver).getText();
		
		System.out.println("Error Message ="+ErrorMsg);
		
		//VideoRecorder_utlity.stopRecord()
		
}
	
	@Test(enabled = true, priority = 5)
	public void MinesGameBetWithHalfAmount() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines Games Betting with half amount");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 50);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Loginbutton"))));
			
			Homepage.Loginbutton(driver).click();	
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Relogin"))));
			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

		log.info("User login successful with valid username & password");

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		Actions action = new Actions(driver);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			action.moveToElement( OriginalsHeader).click().perform();
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			OriginalsHeader.click();
		}

		log.info("Scrolling up to originals header");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MinesLink"))));

		MinesGamePage.MinesLink(driver).click();
		
		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("WalletBalance"))));
		
		WebElement walletBalance = MinesGamePage.WalletBalance(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance ="+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));
		
		MinesGamePage.BetAmount(driver).click();

		WebElement Amount = MinesGamePage.BetAmount(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000004");
		
		log.info("Entering some Amount Successfully");
		
		String BetAmount = Amount.getAttribute("value");
		
		System.out.println("Bet Amount= "+BetAmount);
		
		double BetAmt = Double.parseDouble(BetAmount);
		
        double HAmount = (BetAmt/2);
        
        String s1 = String.format("%.8f", HAmount);
        
        System.out.println("Bet amount/2 = "+s1);
		
		MinesGamePage.HalfxButton(driver).click();
		
		String HalfAmount = MinesGamePage.BetAmount(driver).getAttribute("value");
		
		System.out.println("Amount after clicking on 1/2 button= "+HalfAmount);
		
		Assert.assertEquals(s1, HalfAmount,"Failed : Both amount are different");
		
		System.out.println("Test case passed");
		
		//VideoRecorder_utlity.stopRecord()
		
	}
	
	@Test(enabled = true, priority = 6)
	public void MinesGameBetWithDoubleAmount() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines Games Betting with Double amount");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 50);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Loginbutton"))));
			
			Homepage.Loginbutton(driver).click();	
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Relogin"))));
			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

		log.info("User login successful with valid username & password");
		
		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		Actions action = new Actions(driver);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			action.moveToElement( OriginalsHeader).click().perform();
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			OriginalsHeader.click();
		}

		log.info("Scrolling up to originals header");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MinesLink"))));

		MinesGamePage.MinesLink(driver).click();
		
		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("WalletBalance"))));
		
		WebElement walletBalance = MinesGamePage.WalletBalance(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance ="+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));
		
		MinesGamePage.BetAmount(driver).click();

		WebElement Amount = MinesGamePage.BetAmount(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		String BetAmount = Amount.getAttribute("value");
		
		System.out.println("Bet Amount= "+BetAmount);
		
		double BetAmt = Double.parseDouble(BetAmount);
		
        double DAmount = (BetAmt*2);
        
        String s1 = String.format("%.8f", DAmount);
        
        System.out.println("Bet amount*2 = "+s1);
		
		MinesGamePage.TwoxButton(driver).click();
		
		String DoubleAmount = MinesGamePage.BetAmount(driver).getAttribute("value");
		
		System.out.println("Amount after clicking on 2x button= "+DoubleAmount);
		
		Assert.assertEquals(s1, DoubleAmount,"Failed : Both amount are different");
		
		System.out.println("Test case passed");
		
		//VideoRecorder_utlity.stopRecord()
		
	}
	
	@Test(enabled = true, priority = 7)
	public void MinesGameSetting() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines Games Setting");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 50);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Loginbutton"))));
			
			Homepage.Loginbutton(driver).click();	
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Relogin"))));
			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

		log.info("User login successful with valid username & password");
		
		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		Actions action = new Actions(driver);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			action.moveToElement( OriginalsHeader).click().perform();
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			OriginalsHeader.click();
		}

		log.info("Scrolling up to originals header");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MinesLink"))));

		MinesGamePage.MinesLink(driver).click();
		
		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));
		
		MinesGamePage.MinesGameSetting(driver).click();
		
		log.info("Minesgame Settings Popup is Visible Successfully");
		
		boolean Result = MinesGamePage.SettingSoundButton(driver).isDisplayed();
		
		System.out.println(Result);
		
		if(Result==true)
		{
			System.out.println("Sound button is Displayed");
		}
		else
		{
			System.out.println("Sound button is not Displayed");
		}
		
		
		//VideoRecorder_utlity.stopRecord();	
}
	
	@Test(enabled = true, priority = 8)
	public void MinesGameRules() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines Games Rules");

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 50);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Loginbutton"))));
			
			Homepage.Loginbutton(driver).click();	
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Relogin"))));
			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

		log.info("User login successful with valid username & password");
		
		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		Actions action = new Actions(driver);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			action.moveToElement( OriginalsHeader).click().perform();
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			OriginalsHeader.click();
		}

		log.info("Scrolling up to originals header");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MinesLink"))));

		MinesGamePage.MinesLink(driver).click();
		
		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));
		
		MinesGamePage.MinesGameRules(driver).click();
		
		log.info("Minesgame Rules Popup is Visible Successfully");
		
		String Rules = MinesGamePage.MinesGameRulesPopUp(driver).getText();
		
		System.out.println(Rules);
		
		log.info("Mines Game Rules Pop Up Getting successfully");
		
		//VideoRecorder_utlity.stopRecord();	
}
	
	@Test(enabled = true, priority = 9)
	public void MinesGameLiveStats() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines Games Live Stats");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 50);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Loginbutton"))));
			
			Homepage.Loginbutton(driver).click();	
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Relogin"))));
			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

		log.info("User login successful with valid username & password");
		
		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		Actions action = new Actions(driver);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			action.moveToElement( OriginalsHeader).click().perform();
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			OriginalsHeader.click();
		}

		log.info("Scrolling up to originals header");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MinesLink"))));

		MinesGamePage.MinesLink(driver).click();
		
		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));
		
		MinesGamePage.BetAmount(driver).click();
		
		log.info("Bet Amount input field clicked Successfully ");
		
		WebElement Amount = MinesGamePage.BetAmount(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		MinesGamePage.MinesDropDown(driver).click();
		
		log.info("Clicked on Mines Dropdown successfully ");
		
		MinesGamePage.MinesDropDown5(driver).click();
		
		log.info("Clicked on Mines Dropdown 5 successfully ");
		
		MinesGamePage.MinesGameLiveStats(driver).click();
		
		log.info("Minesgame Live Stats Popup is Visible Successfully");
	
		MinesGamePage.BetButton(driver).click();
		
		log.info("Clicked on BET button successfully");
		
		try
		{
			WebElement displayed;

			displayed = MinesGamePage.PickRandomTile(driver);

			for (int i = 0; i < 24; i++) 
			{
				Thread.sleep(4000);

				displayed.click();
			}

		} 
		catch (Exception e) 
		{
			System.out.println("Elapse condition ");
		}
		
		Thread.sleep(6000);
		
		String ActText = MinesGamePage.MinesGameLiveStatsPopUp(driver).getText();
		
		System.out.println(ActText);
		
		log.info("Mines Game Live Stats Pop Up text Getting successfully");
		
		//VideoRecorder_utlity.stopRecord();	
}

	@Test(enabled = true, priority = 10)
	public void MinesGameFairnessIcon() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines Games Fairness Icon");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 50);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Loginbutton"))));
			
			Homepage.Loginbutton(driver).click();	
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.LoginProperty("Relogin"))));
			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

		log.info("User login successful with valid username & password");
		
		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		Actions action = new Actions(driver);
		
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			action.moveToElement( OriginalsHeader).click().perform();
		}
		catch(Exception e)
		{
			driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(f.PlinkoProperty("OriginalHeader"))));
			OriginalsHeader.click();
		}

		log.info("Scrolling up to originals header");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MinesLink"))));

		MinesGamePage.MinesLink(driver).click();
		
		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));
		
		WebElement walletBalance = MinesGamePage.WalletBalance(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance ="+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));

		WebElement Amount = MinesGamePage.BetAmount(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		MinesGamePage.MinesDropDown(driver).click();
		
		log.info("Clicked on Mines Dropdown successfully ");
		
		MinesGamePage.MinesDropDown5(driver).click();
		
		log.info("Clicked on Mines Dropdown 5 successfully ");
		
		MinesGamePage.BetButton(driver).click();
			
		try {
			WebElement displayed;

			displayed = MinesGamePage.PickRandomTile(driver);

			for (int i = 0; i < 24; i++) 
			{
				Thread.sleep(4000);

				displayed.click();
			}
		} 
		catch (Exception e) 
		{
			System.out.println("Elapse condition ");
		}
		
		MinesGamePage.MinesGameFairnessIcon(driver).click();
		
		log.info("Minesgame Fairness Popup is Visible Successfully");
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.LoginProperty("ChangeButton"))));
		
		MinesGamePage.MinesGameFairnessChangeButton(driver).click();
		
		log.info("Minesgame Fairness Popup CHANGE button clicked Successfully");
		
		String ActiveServerSeed = MinesGamePage.MinesGameFairnessActiveServerSeed(driver).getAttribute("value");
		
		System.out.println("Activr server seed = "+ActiveServerSeed);
		
		String NextServerSeed = MinesGamePage.MinesGameFairnessNextServerSeed(driver).getAttribute("value");
		
		System.out.println("Next Server seed = "+NextServerSeed);
		
		MinesGamePage.MinesGameFairnessGoToTransaction(driver).click();
		
		log.info("Minesgame Fairness Popup 'Go To Transactions' button clicked Successfully");
		
		MinesGamePage.MinesGameFairnessTransactions(driver).click();
		
		log.info("Minesgame Fairness Popup 'Transactions 1st row' button clicked Successfully");
		
		MinesGamePage.MinesGameFairnessVerifyBet(driver).click();
		
		log.info("Minesgame Fairness Popup 'Verify Bet' button clicked Successfully");
		
		String GameName = MinesGamePage.MinesGameFairnessVerifyBetGame(driver).getText();
		
		System.out.println("Game Name = "+GameName);
		
		log.info("Minesgame Fairness Popup Game name getting Successfully");
		
		String Nonce = MinesGamePage.MinesGameFairnessVerifyBetNonce(driver).getAttribute("value");
		
		System.out.println("Nonce = "+Nonce);
		
		log.info("Minesgame Fairness Popup Nonce getting Successfully");
		
	    String Mines = MinesGamePage.MinesGameFairnessVerifyBetMines(driver).getText();
		
	    System.out.println("Mines = "+Mines);
		
	    log.info("Minesgame Fairness Popup Mines getting Successfully");
	    
	   String ServerSeed = MinesGamePage.MinesGameFairnessVerifyBetServerSeed(driver).getAttribute("value");
		
		System.out.println("Server seed after Verification = "+ServerSeed);
		
		log.info("Minesgame Fairness Popup Server Seed getting Successfully");
		
		
		//VideoRecorder_utlity.stopRecord();	
}
	
	@Test(enabled = true, priority = 11)
	public void MinesGameSetMaxMines() throws Exception 
	{
		//VideoRecorder_utlity.startRecord("Mines Games Set Maximun No. of Mines");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
				wait = new WebDriverWait(driver, 50);
				
				try
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(f.LoginProperty("Loginbutton"))));
					
					Homepage.Loginbutton(driver).click();	
				}
				catch(Exception e)
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(f.LoginProperty("Relogin"))));
					Homepage.ReLoginbutton(driver).click();
				}

				log.info("Login button clicked successfully");

				WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

				log.info("Entered valid username");

				WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

				log.info("Entered valid password");

				WelcomePopup.Welcomeplaynow(driver).click();

				log.info("Clicked on Play Now button");

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.MinesgameProperty("UserName"))));

				log.info("User login successful with valid username & password");
				
				WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

				Actions action = new Actions(driver);
				
				try
				{
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(f.PlinkoProperty("OriginalHeader"))));
					action.moveToElement( OriginalsHeader).click().perform();
				}
				catch(Exception e)
				{
					driver.navigate().refresh();
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath(f.PlinkoProperty("OriginalHeader"))));
					OriginalsHeader.click();
				}

				log.info("Scrolling up to originals header");

				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath(f.LoginProperty("MinesLink"))));

				MinesGamePage.MinesLink(driver).click();
				
				log.info("Mines game link clicked successfully");

				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));
				
				WebElement walletBalance = MinesGamePage.WalletBalance(driver);
				
				String TotalBalance = walletBalance.getAttribute("innerText");
				
				System.out.println("TotalBalance ="+TotalBalance);
				
				log.info("Getting Wallet Balance Successfully ");
				
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(f.LoginProperty("Manual"))));

				WebElement Amount = MinesGamePage.BetAmount(driver);
				
				Amount.sendKeys(Keys.CONTROL, "a");

				Amount.sendKeys(Keys.DELETE);

				Amount.sendKeys("0.00000002");
				
				log.info("Entering some Amount Successfully");
				
				MinesGamePage.MinesDropDown(driver).click();
				
				log.info("Clicked on Mines Dropdown successfully ");
				
				MinesGamePage.MinesDropDown24(driver).click();
				
				log.info("Clicked on Mines Dropdown 24 successfully ");
				
				MinesGamePage.BetButton(driver).click();
				
				log.info("Clicked on BET button successfully");
				
				MinesGamePage.PickRandomTile(driver).click();
				
				log.info("Clicked on Pick Random Tile successfully");
				
				
				//VideoRecorder_utlity.stopRecord();
	}
	
	
	
	@AfterMethod
	public void EndTest() throws InterruptedException 
	{
		Thread.sleep(2000);
		
		driver.close();
		 
		log.info("Browser closed");
	}
}