
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

import pageObjects.DiceGamePage;
import pageObjects.Homepage;
import resources.base;

public class DiceGameTestcases extends base {

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
	public void DiceGameBetFullFlowchecking() throws Exception {
		
		////VideoRecorder_utlity.startRecord("DiceGame Bet Full Flow checking");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);
		
		log.info("Login Successfully with valid username and valid Password ");
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Dice'])[1]")));

		// Homepage.DiceGame(driver).click();

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in your wallet =  " + DashboardWalletAmount);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("DiceBetAmountinputField"))));

		WebElement Amount = DiceGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.0000100");

		log.info("Entering some Amount Successfully");

		Double BetAmount = 0.0000100;

		DiceGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

//		wait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath(f.FlushProperty("PanelDicenumber"))));

		Thread.sleep(2000);
		
		log.info("Dice Value is Visible Successfully");

		WebElement DiceResultNumber = DiceGamePage.LatestResultDiceGame(driver);

		String Dicenumber = DiceResultNumber.getAttribute("innerText");

		log.info("Getting dice number Successfully through string format");

		System.out.println("Dice break number  =" + Dicenumber);

		double checkdice = Double.parseDouble(Dicenumber);

		log.info("Converting string dice number in to number successfully");

		if (checkdice > 50) {

			System.out.println("User Win the Dice game ");

			double Balanceamount = (WalletAmount + BetAmount);

			// System.out.println("Dice Game Win after total Amount in you wallet = " +
			// Balanceamount);

			String s1 = String.format("%.8f", Balanceamount);

			System.out.println("Dice Game Win after total Amount in your wallet = " + s1);

			WebElement Walletbalance1 = Homepage.WalletBalanceDropdown(driver);

			String Totalmoney1 = Walletbalance1.getAttribute("innerText");

//			System.out.println("Getting calculation ouptput "+ s1);
//			
//			System.out.println("Getting dashboard amount "+ Totalmoney1);

			Assert.assertEquals(s1, Totalmoney1);

			System.out.println("Test case pass");

		} else {
			System.out.println("User Loss the Dice game ");

			double Balanceamount = (WalletAmount - BetAmount);

			// System.out.println("Dice Game Loss after total Amount in you wallet = " +
			// Balanceamount);

			String s2 = String.format("%.8f", Balanceamount);

			System.out.println("Dice Game Loss after total Amount in you wallet = " + s2);

			WebElement Walletbalance2 = Homepage.WalletBalanceDropdown(driver);

			String Totalmoney2 = Walletbalance2.getAttribute("innerText");

//			System.out.println("Getting calculation ouptput "+ s2);
//			
//			System.out.println("Getting dashboard amount "+ Totalmoney2);

			Assert.assertEquals(s2, Totalmoney2);

			System.out.println("Test case pass");
		}
		WebElement statics = DiceGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", statics);

		DiceGamePage.MyBets(driver).click();

		DiceGamePage.MyBetsLatestDice(driver).click();

		DiceGamePage.BetPopup(driver).click();

		Thread.sleep(4000);

		// Getting first server seed

		WebElement Activeserverseed = DiceGamePage.FAIRNESSActiveserverseed(driver);

		String Serverseed = Activeserverseed.getAttribute("value");

		System.out.println("Server seed=  " + Serverseed);
		
		log.info("Server seed Value is visible Successfully");

		// Getting Next server Seed
		
		Thread.sleep(2000);
		
		WebElement Nextserverseed = DiceGamePage.FAIRNESSNextserverseed(driver);

		String ServerseedNext = Nextserverseed.getAttribute("value");

		System.out.println("Next server seed =  " + ServerseedNext);
		
		log.info("Next Server seed Value is visible Successfully");

		// Click on changing button
/*
		DiceGamePage.FAIRNESSChangeButton(driver).click();

		// After changing the server seed getting

		WebElement Activeserverseed1 = DiceGamePage.FAIRNESSActiveserverseed(driver);

		String Serverseed1 = Activeserverseed1.getAttribute("value");

		System.out.println("Latest Active seed =  " + Serverseed1);

		Assert.assertEquals(ServerseedNext, Serverseed1);

		// Assertion pending

		// System.out.println("Next = " + Nextserverseed);
	*/
		
		////VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 2)
	public void HalfAmount() throws Exception {
		
		////VideoRecorder_utlity.startRecord("Half Amount");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Dice'])[1]")));

		// Homepage.DiceGame(driver).click();

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		double WalletAmount = new Double(Totalmoney);

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in your wallet =  " + DashboardWalletAmount);

		WebElement Amount = DiceGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000100");

		Double BetAmount = 0.00000100;

		DiceGamePage.HalfAmount(driver).click();

		DiceGamePage.BetButton(driver).click();

		WebElement ProfitOnWin = DiceGamePage.ProfitOnWinInputBox(driver);

		String WinProfit = ProfitOnWin.getAttribute("value");

		System.out.println("=============" + WinProfit);

		// BigDecimal num = new BigDecimal(WinProfit);

		// System.out.println("Converted String to BigDecimal : " + num);

		double str1 = Double.parseDouble(WinProfit);

		System.out.println("+++++++++++" + str1);

		////VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 3)
	public void DiceGameDoubleBetAmount() throws Exception {
		
		////VideoRecorder_utlity.startRecord("Dice Game Double Bet Amount");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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
		
		log.info("Clicked on Login Button Successfully");

		page.Login(driver);
		
		log.info("Login Successfully with valid username and valid Password ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting wallet baalnce successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String value converting into decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in your wallet =  " + DashboardWalletAmount);

		WebElement Amount = DiceGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default amount successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default amount successfully");

		Amount.sendKeys("0.00001000");

		log.info("Entering some amount successfully");

		Double BetAmount = 0.00002000;

		DiceGamePage.DoubleAmount(driver).click();

		log.info("2x Button clicked successfully");

		DiceGamePage.BetButton(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.FlushProperty("PanelDicenumber"))));

		log.info("Checking dice value");

		WebElement DiceResultNumber = DiceGamePage.LatestResultDiceGame(driver);

		String Dicenumber = DiceResultNumber.getAttribute("innerText");

		log.info("Getting dice number successfully through string format");

		System.out.println("Dice break number  =" + Dicenumber);

		double checkdice = Double.parseDouble(Dicenumber);

		log.info("Converting string dice number in to number successfully");

		if (checkdice > 50) {

			System.out.println("User Win the Dice game ");

			double Balanceamount = (WalletAmount + BetAmount);

			// System.out.println("Dice Game Win after total Amount in your wallet = " +
			// Balanceamount);

			String s1 = String.format("%.8f", Balanceamount);

			System.out.println("Dice Game Win after total Amount in you wallet = " + s1);

			WebElement Walletbalance1 = Homepage.WalletBalanceDropdown(driver);

			String Totalmoney1 = Walletbalance1.getAttribute("innerText");

//			System.out.println("Getting calculation ouptput "+ s1);
//			
//			System.out.println("Getting dashboard amount "+ Totalmoney1);

			Assert.assertEquals(s1, Totalmoney1);

			System.out.println("Test case pass");

		} else {
			System.out.println("User Loss the Dice game ");

			double Balanceamount = (WalletAmount - BetAmount);

			// System.out.println("Dice Game Loss after total Amount in you wallet = " +
			// Balanceamount);

			String s2 = String.format("%.8f", Balanceamount);

			System.out.println("Dice Game Loss after total Amount in your wallet = " + s2);

			WebElement Walletbalance2 = Homepage.WalletBalanceDropdown(driver);

			String Totalmoney2 = Walletbalance2.getAttribute("innerText");

//			System.out.println("Getting calculation ouptput "+ s2);
//			
//			System.out.println("Getting dashboard amount "+ Totalmoney2);

			Assert.assertEquals(s2, Totalmoney2);

			System.out.println("Test case pass");
		}
		
		////VideoRecorder_utlity.stopRecord();

	}

	@Test(enabled = true, priority = 4)
	public void MAximumErrorMessageChecking() throws Exception {
		
		////VideoRecorder_utlity.startRecord("MAximum Error Message Checking");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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
		
		log.info("Login Button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("MaxButton"))));
		
		DiceGamePage.MaxButton(driver).click();

		log.info("Max Button Clicked successfully");

		DiceGamePage.BetButton(driver).click();

		log.info("Bet Button Clicked Successfully");

		WebElement ErrorMessage = DiceGamePage.InsufficientErrorMessage(driver);

		String Message = ErrorMessage.getAttribute("innerText");

		log.info("Getting Error Message Text Successfully");

		System.out.println(Message);

		String str = Message;

		str = str.replaceAll("\\s", "");

		String ActualTitle = str;

		String ExpectedTitle = "ErrorInsufficientbalance.";

		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		////VideoRecorder_utlity.stopRecord();

	}

	@Test(enabled = true, priority = 5)
	public void DiceGameSetting() throws Exception {
		
		////VideoRecorder_utlity.startRecord("Dice Game Setting");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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
		
		log.info("Click on login button");

		page.Login(driver);
		
		log.info("Login Successfully with valid username and valid Password ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.FlushProperty("DiceGameSettingICon"))));

		DiceGamePage.DiceGameSettingICon(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SettingsProperty("SettingsPopup"))));
		
		log.info("Dicegame Settings Popup is Visible Successfully");
		
		////VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 6)
	public void DiceGameRules() throws Exception {
		
		////VideoRecorder_utlity.startRecord("Dice Game Rules");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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
		
		log.info("Click on login button Successfully");

		page.Login(driver);
		
		log.info("Login Successfully with valid username and valid Password ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.FlushProperty("DiceGameRulesICon"))));
		
		DiceGamePage.DiceGameRulesICon(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SettingsProperty("RulesPopup"))));
		
		log.info("Dicegame Rules Page is Visible Successfully");

		////VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 7)
	public void DiceGameLiveStatsButton() throws Exception {
		
		////VideoRecorder_utlity.startRecord("DiceGame Live Status Button");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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
		
		log.info("Login button clicked Successfully");

		page.Login(driver);
		
		log.info("Login Successfully with valid username and valid Password ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.FlushProperty("DiceGameLiveStatusIcon"))));

		DiceGamePage.DiceGameLiveStatusIcon(driver).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SettingsProperty("LiveStatsPopup"))));
		
        log.info("Dicegame Live Status Page is Visible Successfully");
        
        ////VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 8)
	public void DiceGameFairNessbutton() throws Exception {
		
		////VideoRecorder_utlity.startRecord("DiceGame FairNess button");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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
		
		log.info("Login button clicked Successfully");

		page.Login(driver);
		
		log.info("Login Successfully with valid username and valid Password ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.FlushProperty("DiceGameFairnessIcon"))));

		DiceGamePage.DiceGameFairnessIcon(driver).click();

		log.info("Dicegame Fairness Page is Visible Successfully");
		
		////VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 9)
	public void DiceGameAutoButtonTab() throws Exception {
		
		////VideoRecorder_utlity.startRecord("DiceGame Auto Button Tab");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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

		log.info("Login Button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);
		
		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceGameSideBar"))));

		DiceGamePage.DiceGameAutoButton(driver).click();

		log.info("Start Auto Bet Button Clicked Successfully ");

		WebElement Amount = DiceGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default amount successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default amount successfully");

		Amount.sendKeys("0.00001000");

		log.info("Entering some amount successfully");

		Double BetAmount = 0.00001000;

		DiceGamePage.AutoStartButton(driver).click();

		log.info("Start Auto Button Clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceGame5thDice"))));

		log.info("Waiting until 5th dice Announce ");

		DiceGamePage.StopAutoBettButton(driver).click();

		log.info("Stop Auto Bet Button Clicked Successfully");
		
		////VideoRecorder_utlity.stopRecord();

	}
	@Test(enabled = true, priority = 10)
	public void DiceGameAutoHalfAmount() throws Exception {
		
		////VideoRecorder_utlity.startRecord("DiceGame Auto Half Amount");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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
		
		log.info("Login Button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);
		
		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[text()='AUTO']")));

		DiceGamePage.DiceGameAutoButton(driver).click();

		log.info("Auto Bet Tab Clicked Successfully ");

		WebElement Amount = DiceGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default amount successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount successfully");

		Amount.sendKeys("0.00000010");

		log.info("Entering some amount successfully");
		
		DiceGamePage.HalfAmount(driver).click();
		
		log.info("Half Amount Button Clicked Successfully");

		DiceGamePage.AutoStartButton(driver).click();

		log.info("Auto Start Clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceGame5thDice"))));

		log.info("Waiting until 5th dice Announce ");

		DiceGamePage.StopAutoBettButton(driver).click();

		log.info("Stop Button Clicked Successfully");
		
		////VideoRecorder_utlity.stopRecord();
	}
	
	@Test(enabled = true, priority = 11)
	public void DiceGameAutoDoubleAmount() throws Exception {
		
		////VideoRecorder_utlity.startRecord("DiceGame Auto Double Amount");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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
		
		log.info("Login Button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);
		
		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceGameSideBar"))));

		DiceGamePage.DiceGameAutoButton(driver).click();

		log.info("Auto Button Tab Clicked Successfully ");

		WebElement Amount = DiceGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default amount successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default amount successfully");

		Amount.sendKeys("0.00000010");

		log.info("Entering some amount successfully");
		
		DiceGamePage.DoubleAmount(driver).click();
		
		log.info("2X Amount Button Clicked Successfully");

		DiceGamePage.AutoStartButton(driver).click();

		log.info("Auto Start Clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceGame5thDice"))));

		log.info("Waiting until 5 th dice Announce ");

		DiceGamePage.StopAutoBettButton(driver).click();

		log.info("Stop Button Clicked Successfully");
		
		////VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 12)
	public void DiceGameAutoNumberOfBetsThree() throws Exception {
		
		////VideoRecorder_utlity.startRecord("DiceGame Auto Number Of Bets Three");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 100);

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
		
		log.info("Login Button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);
		
		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();
		
		log.info("Dice game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceGameSideBar"))));

		DiceGamePage.DiceGameAutoButton(driver).click();

		log.info("Auto Button Tab Clicked Successfully ");

		WebElement Amount = DiceGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default amount successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default amount successfully");

		Amount.sendKeys("0.00001000");

		log.info("Entering some amount successfully");
		
		DiceGamePage.NoOfBETSButton(driver).sendKeys("3");
		
		log.info("No of Bets passing 3");

		DiceGamePage.AutoStartButton(driver).click();

		log.info("Auto Start Clicked Successfully");
		
		////VideoRecorder_utlity.stopRecord();
	}

	@AfterMethod
	public void EndTest() throws InterruptedException 
	{
		Thread.sleep(2000);
		 driver.close();
		 
		 log.info("Browser closed");
	}
	
}
