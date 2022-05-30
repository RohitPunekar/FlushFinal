package com.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.DiceGamePage;
import pageObjects.Homepage;
import pageObjects.PlinkoGamePage;
import pageObjects.WelcomePopup;
import resources.VideoRecorder_utlity;
import resources.base;

public class PlinkoGameTestCases extends base
{
	public WebDriver driver;

	public Homepage homepage;

	public WebDriverWait wait;
	
	TestFileinput f = new TestFileinput();
	
	@BeforeMethod
	public void Initialization() throws IOException 
	{
		
		driver =initializeDriver();
		
		driver.get(prop.getProperty("url"));
		
		log.info("Browser invoked");
	}
	@Test(enabled = true, priority = 1)
	public void PlinkoGameBetFullFlowcheckingWithRiskLow() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Bet Full Flow checking with Low Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
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
		
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("PlinkoLink"))));
		
		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");

		//Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("WalletBalance"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Manual"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskLow(driver).click();
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
	
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(4000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("PayoutPlinkoGame"))));
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance = "+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");

		//VideoRecorder_utlity.stopRecord();
		
	}
	
	@Test(enabled = true, priority = 2)
	public void PlinkoGameBetFullFlowcheckingWithRiskMedium() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Bet Full Flow checking with Medium Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));
		
		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Manual"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskMedium(driver).click();
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows9(driver).click();
		
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(4000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
	
		Thread.sleep(4000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance ="+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 3)
	public void PlinkoGameBetFullFlowcheckingWithRiskHigh() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Bet Full Flow checking with High Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance ="+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Manual"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskHigh(driver).click();
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows10(driver).click();
		
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(4000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(4000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount =" +PayoutAmount);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance ="+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 4)
	public void PlinkoGameHalfAmountWithLowRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Half Amount With Low Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Manual"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		String BetAmount = Amount.getAttribute("value");
		
		System.out.println("Bet Amount= "+BetAmount);
		
		double BetAmt = Double.parseDouble(BetAmount);
		
        double HAmount = (BetAmt/2);
        
        String s1 = String.format("%.8f", HAmount);
        
        System.out.println("Bet amount/2 = "+s1);
		
		PlinkoGamePage.HalfAmount(driver).click();
		
		//Thread.sleep(2000);
		
		PlinkoGamePage.BetAmountInpField(driver).click();
		
		String HalfAmount = Amount.getAttribute("value");
		
		log.info("Getting half Amount Successfully through string format");
		
		System.out.println("Half Amount after clicking 1/2 button  = " + HalfAmount );
		
//		double HalfAmt = Double.parseDouble(HalfAmount);
//		
//		String s2 = String.format("%.8f", HalfAmt);
//		
//		System.out.println("Amount After clicking 1/2 button =" +s2);
		
		PlinkoGamePage.Risk(driver).click();
		
		log.info("Risk button clicked successfully");
		
		PlinkoGamePage.RiskLow(driver).click();
		
		log.info("Low Risk Selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		log.info("Row button clicked successfully");
		
		PlinkoGamePage.NoOfRows11(driver).click();
		
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(4000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(4000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance ="+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		
		Assert.assertEquals(s1,HalfAmount, "Failed:Results are not same");
		
		System.out.println("Test case Passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 5)
	public void PlinkoGameHalfAmountWithMediumRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Half Amount With Medium Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Manual"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		String BetAmount = Amount.getAttribute("value");
		
		System.out.println("Bet Amount= "+BetAmount);
		
		double BetAmt = Double.parseDouble(BetAmount);
		
        double HAmount = (BetAmt/2);
        
        String s1 = String.format("%.8f", HAmount);
        
        System.out.println("Bet amount/2 = "+s1);
		
		PlinkoGamePage.HalfAmount(driver).click();
		
		//Thread.sleep(2000);
		
		PlinkoGamePage.BetAmountInpField(driver).click();
		
		String HalfAmount = Amount.getAttribute("value");
		
		log.info("Getting half Amount Successfully through string format");
		
		System.out.println("Half Amount after clicking 1/2 button  =" + HalfAmount );
		
//		double HalfAmt = Double.parseDouble(HalfAmount);
//		
//		String s2 = String.format("%.8f", HalfAmt);
//		
//		System.out.println("Amount After clicking 1/2 button =" +s2);
		
		PlinkoGamePage.Risk(driver).click();
		
		log.info("Risk button clicked successfully");
		
		PlinkoGamePage.RiskMedium(driver).click();
		
		log.info("Medium Risk Selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		log.info("Row button clicked successfully");
		
		PlinkoGamePage.NoOfRows12(driver).click();
		
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(4000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(4000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance = "+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		
		Assert.assertEquals(s1,HalfAmount, "Failed:Results are not same");
		
		System.out.println("Test case Passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 6)
	public void PlinkoGameHalfAmountWithHighRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Half Amount With High Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Manual"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		String BetAmount = Amount.getAttribute("value");
		
		System.out.println("Bet Amount= "+BetAmount);
		
		double BetAmt = Double.parseDouble(BetAmount);
		
        double HAmount = (BetAmt/2);
        
        String s1 = String.format("%.8f", HAmount);
        
        System.out.println("Bet Amount/2 = "+s1);
		
		PlinkoGamePage.HalfAmount(driver).click();
		
		//Thread.sleep(2000);
		
		PlinkoGamePage.BetAmountInpField(driver).click();
		
		String HalfAmount = Amount.getAttribute("value");
		
		log.info("Getting half Amount Successfully through string format");
		
		System.out.println("Half Amount after clicking 1/2 button  = " + HalfAmount );
		
//		double HalfAmt = Double.parseDouble(HalfAmount);
//		
//		String s2 = String.format("%.8f", HalfAmt);
//		
//		System.out.println("Amount After clicking 1/2 button =" +s2);
		
		PlinkoGamePage.Risk(driver).click();
		
		log.info("Risk button clicked successfully");
		
		PlinkoGamePage.RiskHigh(driver).click();
		
		log.info("High Risk Selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		log.info("Row button clicked successfully");
		
		PlinkoGamePage.NoOfRows13(driver).click();
		
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(4000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(4000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance = "+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		
		Assert.assertEquals(s1,HalfAmount, "Failed:Results are not same");
		
		System.out.println("Test case Passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 7)
	public void PlinkoGameDoubleAmountWithLowRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Double Amount With Low Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Manual"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		String BetAmount = Amount.getAttribute("value");
		
		System.out.println("Bet Amount= "+BetAmount);
		
		double BetAmt = Double.parseDouble(BetAmount);
		
        double DAmount = (BetAmt*2);
        
        String s1 = String.format("%.8f", DAmount);
        
        System.out.println("Bet Amount * 2 = "+s1);
		
		PlinkoGamePage.DoubleAmount(driver).click();
		
		//Thread.sleep(2000);
		
		PlinkoGamePage.BetAmountInpField(driver).click();
		
		String DoubleAmount = Amount.getAttribute("value");
		
		log.info("Getting Double Amount Successfully through string format");
		
		System.out.println("Double Amount after clicking 2x button  =" + DoubleAmount );
		
//		double DoubleAmt = Double.parseDouble(DoubleAmount);
//		
//		String s2 = String.format("%.8f", DoubleAmt);
//		
//		System.out.println("Amount After clicking 2x button =" +s2);
		
		PlinkoGamePage.Risk(driver).click();
		
		log.info("Risk button clicked successfully");
		
		PlinkoGamePage.RiskLow(driver).click();
		
		log.info("Low Risk Selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		log.info("Row button clicked successfully");
		
		PlinkoGamePage.NoOfRows14(driver).click();
		
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(4000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(4000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance = "+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		
		Assert.assertEquals(s1,DoubleAmount, "Failed:Results are not same");
		
		System.out.println("Test case Passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	

	@Test(enabled = true, priority = 8)
	public void PlinkoGameDoubleAmountWithMediumRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Double Amount With Medium Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Manual"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		String BetAmount = Amount.getAttribute("value");
		
		System.out.println("Bet Amount= "+BetAmount);
		
		double BetAmt = Double.parseDouble(BetAmount);
		
        double DAmount = (BetAmt*2);
        
        String s1 = String.format("%.8f", DAmount);
        
        System.out.println("Bet Amount * 2 = "+s1);
		
		PlinkoGamePage.DoubleAmount(driver).click();
		
		//Thread.sleep(2000);
		
		PlinkoGamePage.BetAmountInpField(driver).click();
		
		String DoubleAmount = Amount.getAttribute("value");
		
		log.info("Getting Double Amount Successfully through string format");
		
		System.out.println("Double Amount after clicking 2x button  =" + DoubleAmount );
		
//		double DoubleAmt = Double.parseDouble(DoubleAmount);
//		
//		String s2 = String.format("%.8f", DoubleAmt);
//		
//		System.out.println("Amount After clicking 2x button =" +s2);
		
		PlinkoGamePage.Risk(driver).click();
		
		log.info("Risk button clicked successfully");
		
		PlinkoGamePage.RiskMedium(driver).click();
		
		log.info("Medium Risk Selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		log.info("Row button clicked successfully");
		
		PlinkoGamePage.NoOfRows14(driver).click();
		
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(4000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance = "+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		Assert.assertEquals(s1,DoubleAmount, "Failed:Results are not same");
		
		System.out.println("Test case Passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	@Test(enabled = true, priority = 9)
	public void PlinkoGameDoubleAmountWithHighRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Double Amount With High Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Manual"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		String BetAmount = Amount.getAttribute("value");
		
		System.out.println("Bet Amount= "+BetAmount);
		
		double BetAmt = Double.parseDouble(BetAmount);
		
        double DAmount = (BetAmt*2);
        
        String s1 = String.format("%.8f", DAmount);
        
        System.out.println("Bet Amount * 2 = "+s1);
		
		PlinkoGamePage.DoubleAmount(driver).click();
		
		//Thread.sleep(2000);
		
		PlinkoGamePage.BetAmountInpField(driver).click();
		
		String DoubleAmount = Amount.getAttribute("value");
		
		log.info("Getting Double Amount Successfully through string format");
		
		System.out.println("Double Amount after clicking 2x button  =" + DoubleAmount );
		
//		double DoubleAmt = Double.parseDouble(DoubleAmount);
//		
//		String s2 = String.format("%.8f", DoubleAmt);
//		
//		System.out.println("Amount After clicking 2x button =" +s2);
		
		PlinkoGamePage.Risk(driver).click();
		
		log.info("Risk button clicked successfully");
		
		PlinkoGamePage.RiskHigh(driver).click();
		
		log.info("high Risk Selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		log.info("Row button clicked successfully");
		
		PlinkoGamePage.NoOfRows15(driver).click();
		
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(6000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(4000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance = "+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		
		Assert.assertEquals(s1,DoubleAmount, "Failed:Results are not same");
		
		System.out.println("Test case Passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}
	
	@Test(enabled = true, priority = 10)
	public void PlinkoGameAutoBetTabWithLowRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Auto Bet Tab With Low Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Auto"))));
		
		PlinkoGamePage.Auto(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskLow(driver).click();
		
		log.info("Low risk selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		 WebElement NoOfBets = PlinkoGamePage.AutoNoOfBetsField(driver);
		 
		 NoOfBets.click();
		 
		 NoOfBets.sendKeys(Keys.CONTROL,"a");
		 
		 NoOfBets.sendKeys(Keys.DELETE);
		 
		 NoOfBets.sendKeys("5");
		
		 log.info("Entering No of bets successfully");
		
		PlinkoGamePage.ClickOnStartAutoBet(driver).click();
		
		log.info("Start Auto Bet button clicked successfully");
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance = "+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 11)
	public void PlinkoGameAutoBetTabWithMediumRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Auto Bet Tab With Medium Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Auto"))));
		
		PlinkoGamePage.Auto(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskMedium(driver).click();
		
		log.info("Medium risk selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		 WebElement NoOfBets = PlinkoGamePage.AutoNoOfBetsField(driver);
		 
		 NoOfBets.click();
		 
		 NoOfBets.sendKeys(Keys.CONTROL,"a");
		 
		 NoOfBets.sendKeys(Keys.DELETE);
		 
		 NoOfBets.sendKeys("5");
		
		 log.info("Entering No of bets successfully");
		
		PlinkoGamePage.ClickOnStartAutoBet(driver).click();
		
		log.info("Start Auto Bet button clicked successfully");
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance = "+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 12)
	public void PlinkoGameAutoBetTabWithHighRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Auto Bet Tab With High Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Auto"))));
		
		PlinkoGamePage.Auto(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskHigh(driver).click();
		
		log.info("High risk selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows12(driver).click();
		
		 WebElement NoOfBets = PlinkoGamePage.AutoNoOfBetsField(driver);
		 
		 NoOfBets.click();
		 
		 NoOfBets.sendKeys(Keys.CONTROL,"a");
		 
		 NoOfBets.sendKeys(Keys.DELETE);
		 
		 NoOfBets.sendKeys("5");
		
		 log.info("Entering No of bets successfully");
		
		PlinkoGamePage.ClickOnStartAutoBet(driver).click();
		
		log.info("Start Auto Bet button clicked successfully");
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		//System.out.println("TotalBalance ="+TotalBalanceAfterBET);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 13)
	public void PlinkoGameAutoHalfAmountWithLowRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Auto Bet Half Amount With Low Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Auto"))));
		
		PlinkoGamePage.Auto(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000004");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.HalfAmount(driver).click();
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskLow(driver).click();
		
		log.info("Low risk selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		 WebElement NoOfBets = PlinkoGamePage.AutoNoOfBetsField(driver);
		 
		 NoOfBets.click();
		 
		 NoOfBets.sendKeys(Keys.CONTROL,"a");
		 
		 NoOfBets.sendKeys(Keys.DELETE);
		 
		 NoOfBets.sendKeys("5");
		
		 log.info("Entering No of bets successfully");
		
		PlinkoGamePage.ClickOnStartAutoBet(driver).click();
		
		log.info("Start Auto Bet button clicked successfully");
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance);
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 14)
	public void PlinkoGameAutoHalfAmountWithMediumRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Auto Bet Half Amount With Medium Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Auto"))));
		
		PlinkoGamePage.Auto(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000004");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.HalfAmount(driver).click();
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskMedium(driver).click();
		
		log.info("Medium risk selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		 WebElement NoOfBets = PlinkoGamePage.AutoNoOfBetsField(driver);
		 
		 NoOfBets.click();
		 
		 NoOfBets.sendKeys(Keys.CONTROL,"a");
		 
		 NoOfBets.sendKeys(Keys.DELETE);
		 
		 NoOfBets.sendKeys("5");
		
		 log.info("Entering No of bets successfully");
		
		PlinkoGamePage.ClickOnStartAutoBet(driver).click();
		
		log.info("Start Auto Bet button clicked successfully");
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 15)
	public void PlinkoGameAutoHalfAmountWithHighRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Auto Bet Half Amount With High Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Auto"))));
		
		PlinkoGamePage.Auto(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000004");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.HalfAmount(driver).click();
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskHigh(driver).click();
		
		log.info("High risk selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		 WebElement NoOfBets = PlinkoGamePage.AutoNoOfBetsField(driver);
		 
		 NoOfBets.click();
		 
		 NoOfBets.sendKeys(Keys.CONTROL,"a");
		 
		 NoOfBets.sendKeys(Keys.DELETE);
		 
		 NoOfBets.sendKeys("5");
		
		 log.info("Entering No of bets successfully");
		
		PlinkoGamePage.ClickOnStartAutoBet(driver).click();
		
		log.info("Start Auto Bet button clicked successfully");
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 16)
	public void PlinkoGameAutoDoubleAmountWithLowRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Auto Bet Double Amount With Low Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Auto"))));
		
		PlinkoGamePage.Auto(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.DoubleAmount(driver).click();
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskLow(driver).click();
		
		log.info("Low risk selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		 WebElement NoOfBets = PlinkoGamePage.AutoNoOfBetsField(driver);
		 
		 NoOfBets.click();
		 
		 NoOfBets.sendKeys(Keys.CONTROL,"a");
		 
		 NoOfBets.sendKeys(Keys.DELETE);
		 
		 NoOfBets.sendKeys("5");
		
		 log.info("Entering No of bets successfully");
		
		PlinkoGamePage.ClickOnStartAutoBet(driver).click();
		
		log.info("Start Auto Bet button clicked successfully");
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 17)
	public void PlinkoGameAutoDoubleAmountWithMediumRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Auto Bet Double Amount With Medium Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Auto"))));
		
		PlinkoGamePage.Auto(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.DoubleAmount(driver).click();
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskMedium(driver).click();
		
		log.info("Medium risk selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		 WebElement NoOfBets = PlinkoGamePage.AutoNoOfBetsField(driver);
		 
		 NoOfBets.click();
		 
		 NoOfBets.sendKeys(Keys.CONTROL,"a");
		 
		 NoOfBets.sendKeys(Keys.DELETE);
		 
		 NoOfBets.sendKeys("5");
		
		 log.info("Entering No of bets successfully");
		
		PlinkoGamePage.ClickOnStartAutoBet(driver).click();
		
		log.info("Start Auto Bet button clicked successfully");
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
	
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 18)
	public void PlinkoGameAutoDoubleAmountWithHighRisk() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Bet Full Flow checking with Medium Risk");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Auto"))));
		
		PlinkoGamePage.Auto(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.DoubleAmount(driver).click();
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskHigh(driver).click();
		
		log.info("High risk selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		 WebElement NoOfBets = PlinkoGamePage.AutoNoOfBetsField(driver);
		 
		 NoOfBets.click();
		 
		 NoOfBets.sendKeys(Keys.CONTROL,"a");
		 
		 NoOfBets.sendKeys(Keys.DELETE);
		 
		 NoOfBets.sendKeys("5");
		
		 log.info("Entering No of bets successfully");
		
		PlinkoGamePage.ClickOnStartAutoBet(driver).click();
		
		log.info("Start Auto Bet button clicked successfully");
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 19)
	public void PlinkoGameAutoBetTabWithLowRiskInfinite() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Auto Bet with low Risk & Infinite No. Of Bets");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		WebElement walletBalance = Homepage.WalletBalanceDropdown(driver);
		
		String TotalBalance = walletBalance.getAttribute("innerText");
		
		System.out.println("TotalBalance = "+TotalBalance);
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(TotalBalance);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet before BET=  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Auto"))));
		
		PlinkoGamePage.Auto(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskLow(driver).click();
		
		log.info("Low risk selected successfully");
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		 WebElement NoOfBets = PlinkoGamePage.AutoNoOfBetsField(driver);
		 
		 NoOfBets.click();
		 
		 NoOfBets.sendKeys(Keys.CONTROL,"a");
		 
		 NoOfBets.sendKeys(Keys.DELETE);
		 
		 NoOfBets.sendKeys("0");
		
		 log.info("Entering No of bets successfully");
		
		PlinkoGamePage.ClickOnStartAutoBet(driver).click();
		
		log.info("Start Auto Bet button clicked successfully");
		
		Thread.sleep(5000);
		
		PlinkoGamePage.ClickOnStopAutoBet(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Statistics = PlinkoGamePage.MyBets(driver);
		
		js.executeScript("arguments[0].scrollIntoView();", Statistics);
		
		PlinkoGamePage.MyBets(driver).click();
		
		Thread.sleep(8000);
		
		WebElement Payout = PlinkoGamePage.PayoutPlinkoGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  = " + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);
		
		System.out.println("PayoutAmount = " +PayoutAmount);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].scrollIntoView();", walletBalance );
		
		String TotalBalanceAfterBET = walletBalance.getAttribute("innerText");
		
		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);
		
		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string PayoutAmount into number successfully");
		
		System.out.println("-------------------------------------------");
		
		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(TotalBalance))
		{
			System.out.println("No Profit No Loss");
		}
		else
		{
			System.out.println("User is in Loss");
		}
		
		System.out.println("Test case passed");
		
	//	VideoRecorder_utlity.stopRecord();
	
	}	
	
	@Test(enabled = true, priority = 20)
	public void PlinkoGameSetting() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Setting");
	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Homepage page = new Homepage(driver);
				
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		PlinkoGamePage.PlinkoGameSetting(driver).click();
		
		log.info("Plinkogame Settings Popup is Visible Successfully");
		
		boolean Result = PlinkoGamePage.PlinkoGameSettingSoundButton(driver).isDisplayed();
		
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
	
	@Test(enabled = true, priority = 21)
	public void PlinkoGameRules() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Rules");
		
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		PlinkoGamePage.PlinkoGameRules(driver).click();
		
		log.info("Plinkogame Rules Popup is Visible Successfully");
		
		String ActText = PlinkoGamePage.PlinkoGameRulesPopUp(driver).getText();
		
		System.out.println(ActText);
		
		log.info("Plinkogame Rules Popup text is getting Successfully");
		
		//VideoRecorder_utlity.stopRecord();
		
	}
	
	@Test(enabled = true, priority = 22)
	public void PlinkoGameLiveStats() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Live Stats");
		
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskLow(driver).click();
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		PlinkoGamePage.PlinkoGameLiveStats(driver).click();
		
		log.info("Plinkogame Live Stats Popup is Visible Successfully");
		
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(6000);
		
		String ActText = PlinkoGamePage.PlinkoGameLiveStatsPopUp(driver).getText();
		
		System.out.println(ActText);
		
		log.info("Plinkogame Live Stats Popup text is getting Successfully");
		
		//VideoRecorder_utlity.stopRecord();
		
	}
	
	@Test(enabled = true, priority = 23)
	public void PlinkoGameFairnessIcon() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Fairness Icon");
		
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));
		
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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));

		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");
		
		log.info("Entering some Amount Successfully");
		
		PlinkoGamePage.Risk(driver).click();
		
		PlinkoGamePage.RiskLow(driver).click();
		
		PlinkoGamePage.Rows(driver).click();
		
		PlinkoGamePage.NoOfRows8(driver).click();
		
		PlinkoGamePage.ClickOnBETBotton(driver).click();
		
		log.info("Bet button clicked successfully");
		
		Thread.sleep(4000);
		
		PlinkoGamePage.PlinkoGameFairnessIcon(driver).click();
		
		log.info("Plinkogame Fairness PopUp is Visible Successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
			By.xpath(f.PlinkoProperty("Change"))));
		
		WebElement ServerSeed = PlinkoGamePage.PlinkoGameFairnessActiveServerSeed(driver);
		
		WebElement NextServerSeed = PlinkoGamePage.PlinkoGameFairnessNextServerSeed(driver);
		
		String ActiveServerSeed = ServerSeed.getAttribute("value");
		 
		System.out.println("Active Server seed = "+ActiveServerSeed);
		 
		String NextServerSeedHashed = NextServerSeed.getAttribute("value");
		
	    System.out.println("Next Server Seed Hashed = "+NextServerSeedHashed);
		 
		PlinkoGamePage.PlinkoGameFairnessPopUp(driver).click();
			
		log.info("Plinkogame Fairness PopUp 'CHANGE' Button Clicked Successfully");
		 
		PlinkoGamePage.PlinkoGameFairnessGoToTransaction(driver).click();
		
		log.info("Plinkogame Fairness PopUp 'Go to Transaction Link' Clicked Successfully");
		
		PlinkoGamePage.PlinkoGameFairnessTransactionsRow(driver).click();
				
//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath(f.PlinkoProperty("VerifyBet"))));
		
		PlinkoGamePage.PlinkoGameFairnessVerifyBet(driver).click();
		
		log.info("Plinkogame Fairness PopUp Verify Bet button Clicked Successfully");
		
		String GameName = PlinkoGamePage.PlinkoGameFairnessGameTab(driver).getText();
		
		System.out.println(GameName);
		
		log.info("Plinkogame Fairness PopUp Game Name get Successfully");
		
		String Risk = PlinkoGamePage.PlinkoGameFairnessRiskTab(driver).getText();
		
		System.out.println(Risk);
		
		log.info("Plinkogame Fairness PopUp Risk Tab text get Successfully");
		
		String Rows = PlinkoGamePage.PlinkoGameFairnessRowsTab(driver).getText();
		
		System.out.println(Rows);
		
		log.info("Plinkogame Fairness PopUp Rows Tab Text get Successfully");	
		
		Assert.assertNotEquals(ServerSeed, NextServerSeed,"Failed :Both results are same");
		
		System.out.println("Test case passed");
		
		//VideoRecorder_utlity.stopRecord();
		
	}
	
	@Test(enabled = true, priority = 24)
	public void PlinkoGameBetMaximumErrorMessageChecking() throws Exception
	{
		//VideoRecorder_utlity.startRecord("PlinkoGame Error Message Checking");
		
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
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("UserName"))));

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
				By.xpath(f.PlinkoProperty("PlinkoLink"))));
		
		PlinkoGamePage.PlinkoLink(driver).click();
		
		log.info("Plinko game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("UserName"))));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.PlinkoProperty("Manual"))));
		
		PlinkoGamePage.Manual(driver).click();
		
		WebElement Amount = PlinkoGamePage.BetAmountInpField(driver);
		
		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("20.00000100");
		
		log.info("Entering some Amount Successfully");
		
		String ErrorMsg = PlinkoGamePage.PlinkoGameErrorMessage(driver).getText();
		
		log.info("Getting Error Message Successfully");
		
		System.out.println(ErrorMsg);
		
		//VideoRecorder_utlity.stopRecord();
	
	}
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.close();
		
		log.info("Browser closed");
	}
	
	

}