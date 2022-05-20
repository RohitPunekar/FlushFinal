package com.Test;

import java.io.IOException;
import java.math.BigDecimal;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.CrashGamePage;
import pageObjects.DiceGamePage;
import pageObjects.Homepage;
import pageObjects.WheelGamePage;
import resources.base;

public class CrashGameTestCases extends base {

	public WebDriver driver;

	public Homepage homepage;

	public WebDriverWait wait;


	TestFileinput f = new TestFileinput();

	@BeforeMethod
	public void Initialization() throws IOException {

		driver =initializeDriver();

		driver.get(prop.getProperty("url"));

		log.info("Browser invoked");
	}


	@Test(enabled = true, priority = 1)
	public void CrashGameBetFullFlowChecking() throws Exception {

		//VideoRecorder_utlity.startRecord("Crash Games Betting");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("CrashLink"))));

		CrashGamePage.CrashLink(driver).click();

		log.info("Crash game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		System.out.println("TotalBalance ="+Totalmoney);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in your wallet =  " + DashboardWalletAmount);

		WebElement Amount = CrashGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.0000100");

		log.info("Entering some Amount Successfully");

		Double BetAmount = 0.00000010;

		WebElement CashOut = CrashGamePage.CashOutDropdown(driver);

		CashOut.sendKeys(Keys.CONTROL, "a");

		CashOut.sendKeys(Keys.DELETE);

		CashOut.sendKeys("5");

		log.info("Entering Cashout At");

		CrashGamePage.BetNextRoundBtn(driver).click();

		log.info("Bet Next Round button clicked Successfully ");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashGameScore2"))));

		System.out.println( CrashGamePage.CrashGameResult2(driver).getText());

		Thread.sleep(3000);

		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(f.CrashProperty("BetNextRoundBtn"))));
		}catch(Exception e) {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(f.CrashProperty("BetButton"))));
		}

		WebElement Statistics = CrashGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		CrashGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = CrashGamePage.PayoutCrashGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" +PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		//System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(Totalmoney))
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
	public void CrashGameLoginDuringLogout() throws Exception {

		//VideoRecorder_utlity.startRecord("Crash Games Betting");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/crash");

		log.info("Redirected to Crashgame url");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("BetNextRoundBtn"))));

		//		Thread.sleep(2000);

		CrashGamePage.BetNextRoundBtn(driver).click();

		log.info("Bet Next Round button clicked Successfully ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Login"))));

		log.info("Login page is Visible Successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		System.out.println("TotalBalance ="+Totalmoney);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = CrashGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.0000100");

		log.info("Entering some Amount Successfully");

		Double BetAmount = 0.00000010;

		WebElement CashOut = CrashGamePage.CashOutDropdown(driver);

		CashOut.sendKeys(Keys.CONTROL, "a");

		CashOut.sendKeys(Keys.DELETE);

		CashOut.sendKeys("5");

		log.info("Entering Cashout At");

		CrashGamePage.BetNextRoundBtn(driver).click();

		log.info("Bet Next Round button clicked Successfully ");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashGameScore1"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement Statistics = CrashGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		CrashGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = CrashGamePage.PayoutCrashGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" +PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		//System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(Totalmoney))
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

	@Test(enabled = true, priority = 3)
	public void CrashGameBetAfterLogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Crash Games Betting");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("CrashLink"))));

		CrashGamePage.CrashLink(driver).click();

		log.info("Crash game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		System.out.println("TotalBalance ="+Totalmoney);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = CrashGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.0000100");

		log.info("Entering some Amount Successfully");

		Double BetAmount = 0.00000010;

		WebElement CashOut = CrashGamePage.CashOutDropdown(driver);

		CashOut.sendKeys(Keys.CONTROL, "a");

		CashOut.sendKeys(Keys.DELETE);

		CashOut.sendKeys("5");

		log.info("Entering Cashout At");

		CrashGamePage.BetNextRoundBtn(driver).click();

		log.info("Bet Next Round button clicked Successfully ");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashGameScore1"))));

		WebElement Statistics = CrashGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		CrashGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = CrashGamePage.PayoutCrashGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" +PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		//System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(Totalmoney))
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

	@Test(enabled = true, priority = 4)
	public void CrashGameBetMaxAmount() throws Exception {

		//VideoRecorder_utlity.startRecord("Crash Games Max Betting Warning");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("CrashLink"))));

		CrashGamePage.CrashLink(driver).click();

		log.info("Crash game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		WebElement Amount = CrashGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("2.00000100");

		log.info("Entering some Amount Successfully");

		String MaxAmountExceed = CrashGamePage.CrashGameMaxBalanceError(driver).getText();

		Assert.assertEquals(MaxAmountExceed, "You can't bet more than your balance!");

		log.info("Maximum balance warning message is visible successfully");

		System.out.println(MaxAmountExceed);


		//VideoRecorder_utlity.stopRecord();	
	}

	@Test(enabled = true, priority = 5)
	public void CrashGameBetWithHalfAmount() throws Exception {

		//VideoRecorder_utlity.startRecord("Crash Games Betting half");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("CrashLink"))));

		CrashGamePage.CrashLink(driver).click();

		log.info("Crash game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		System.out.println("TotalBalance ="+Totalmoney);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = CrashGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.0000100");

		log.info("Entering some Amount Successfully");

		Double BetAmount = 0.00000010;

		CrashGamePage.HalfxButton(driver).click();

		log.info("Clicked on 1/2 button Successfully");

		CrashGamePage.BetNextRoundBtn(driver).click();

		log.info("Bet Next Round button clicked Successfully ");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashGameScore1"))));

		WebElement Statistics = CrashGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		CrashGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = CrashGamePage.PayoutCrashGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" +PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		//System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(Totalmoney))
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

	@Test(enabled = true, priority = 6)
	public void CrashGameBetWithDoubleAmount() throws Exception {

		//VideoRecorder_utlity.startRecord("Crash Games Betting ");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("CrashLink"))));

		CrashGamePage.CrashLink(driver).click();

		log.info("Crash game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		System.out.println("TotalBalance ="+Totalmoney);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = CrashGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.0000100");

		log.info("Entering some Amount Successfully");

		Double BetAmount = 0.00000010;

		CrashGamePage.DoublexButton(driver).click();

		log.info("Clicked on 2x button Successfully");

		CrashGamePage.BetNextRoundBtn(driver).click();

		log.info("Bet Next Round button clicked Successfully ");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashGameScore1"))));

		WebElement Statistics = CrashGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		CrashGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = CrashGamePage.PayoutCrashGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" +PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		//System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(Totalmoney))
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

	@Test(enabled = true, priority = 7)
	public void CrashGameSetting() throws Exception
	{
		//VideoRecorder_utlity.startRecord("Crash Game Setting");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("CrashLink"))));

		CrashGamePage.CrashLink(driver).click();

		log.info("Crash game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		CrashGamePage.CrashGameSettingICon(driver).click();

		log.info("Clicked on crash game Settings icon");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SettingsProperty("SettingsPopup"))));

		log.info("Crashgame Settings Popup is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 8)
	public void CrashGameRules() throws Exception
	{
		//VideoRecorder_utlity.startRecord("Crash Game Rules");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("CrashLink"))));

		CrashGamePage.CrashLink(driver).click();

		log.info("Crash game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		CrashGamePage.CrashGameRulesIcon(driver).click();

		log.info("Clicked on Crash Game Rules icon");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SettingsProperty("RulesPopup"))));

		log.info("Crashgame Rules Popup is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 9)
	public void CrashGameLiveStatsButton() throws Exception
	{
		//VideoRecorder_utlity.startRecord("Crash Game Live Stats");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("CrashLink"))));

		CrashGamePage.CrashLink(driver).click();

		log.info("Crash game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));	

		CrashGamePage.CrashGameLiveStatusIcon(driver).click();

		log.info("Clicked on Live Stats Icon");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SettingsProperty("LiveStatsPopup"))));

		log.info("Crashgame Live Stats Popup is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 10)
	public void CrashGameFairnessIcon() throws Exception
	{
		//VideoRecorder_utlity.startRecord("Crash Game Live Stats");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("CrashLink"))));

		CrashGamePage.CrashLink(driver).click();

		log.info("Crash game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		CrashGamePage.CrashGameFairnessIcon(driver).click();

		log.info("Clicked on Crash Game Fairness Icon");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SettingsProperty("FairnessPopup"))));

		log.info("Crashgame Fairness Popup is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 11)
	public void CrashGameAutoNumberOfBetsTwo() throws Exception {

		//VideoRecorder_utlity.startRecord("WheelGame Auto Number Of Bets Two");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");;

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("CrashLink"))));

		CrashGamePage.CrashLink(driver).click();

		log.info("Crash game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		System.out.println("TotalBalance ="+Totalmoney);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in your wallet =  " + DashboardWalletAmount);


		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.CrashProperty("AUTO"))));

		CrashGamePage.AutoButton(driver).click();

		log.info("AUTO Button Clicked Successfully ");

		WebElement Amount = CrashGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default amount successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default amount successfully");

		Amount.sendKeys("0.00000010");

		log.info("Entering some amount successfully");

		Double BetAmount = 0.00000010;

		CrashGamePage.AutoNoOfBets(driver).sendKeys("1");

		log.info("1 Number of Bets Entered Successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.CrashProperty("StartAutobet"))));

		CrashGamePage.StartAutoBet(driver).click();

		log.info("Start Auto Button Clicked Successfully");

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashGameScore1"))));

		System.out.println( CrashGamePage.CrashGameResult1(driver).getText());

		//		Thread.sleep(3000);
		//		
		//		try {
		//			wait.until(ExpectedConditions
		//					.visibilityOfElementLocated(By.xpath(f.CrashProperty("BetButton"))));	
		//		}catch(Exception e) {
		//			wait.until(ExpectedConditions
		//					.visibilityOfElementLocated(By.xpath(f.CrashProperty("StartAutobet"))));
		//		}
		//
		//		log.info("Verifying two Crash game Scores are Visible Successfully");

		WebElement Statistics = CrashGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		CrashGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = CrashGamePage.PayoutCrashGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt );

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" +PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		//System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if(WalletAmountAfterBET > WalletAmount )
		{
			System.out.println("User is in profit");
		}
		else if(TotalBalanceAfterBET.equals(Totalmoney))
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



	@AfterMethod
	public void EndTest() 
	{
		driver.close();

		log.info("Browser closed");
	}


}
