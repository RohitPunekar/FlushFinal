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
import pageObjects.Homepage;
import pageObjects.PlinkoGamePage;
import pageObjects.WheelGamePage;
import resources.base;

public class WheelGameTestCases extends base {

	public WebDriver driver;

	public Homepage homepage;

	public WebDriverWait wait;

	TestFileinput f = new TestFileinput();

	@BeforeMethod
	public void Initialization() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		log.info("Browser invoked");
	}

	@Test(enabled = true, priority = 1)
	public void WheelGameBetWithLowRisk() throws Exception {
		// VideoRecorder_utlity.startRecord("Wheel Game Bet With Low Risk");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		System.out.println("TotalBalance =" + Totalmoney);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.00000002");

		log.info("Entering some Amount Successfully");

		Double BetAmount = 0.00000002;

		WheelGamePage.RiskDropdown(driver).click();

		log.info("Clicked on RISK dropdown Successfully");

		WheelGamePage.LowRisk(driver).click();

		log.info("Clicked on Low Risk");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelGameResult"))));

		WebElement Statistics = WheelGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		WheelGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = WheelGamePage.PayoutWheelGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt);

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" + PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		// System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if (WalletAmountAfterBET > WalletAmount) {
			System.out.println("User is in profit");
		} else if (TotalBalanceAfterBET.equals(Totalmoney)) {
			System.out.println("No Profit No Loss");
		} else {
			System.out.println("User is in Loss");
		}

		System.out.println("Test case passed");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 2)
	public void WheelGameBetWithMediumRisk() throws Exception {
		// VideoRecorder_utlity.startRecord("Wheel Game Bet With Medium Risk");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.00000002");

		log.info("Entering some Amount Successfully");

		WheelGamePage.RiskDropdown(driver).click();

		log.info("Clicked on RISK dropdown Successfully");

		WheelGamePage.MediumRisk(driver).click();

		log.info("Clicked on Medium Risk");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelGameResult"))));

		WebElement Statistics = WheelGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		WheelGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = WheelGamePage.PayoutWheelGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt);

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" + PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		// System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if (WalletAmountAfterBET > WalletAmount) {
			System.out.println("User is in profit");
		} else if (TotalBalanceAfterBET.equals(Totalmoney)) {
			System.out.println("No Profit No Loss");
		} else {
			System.out.println("User is in Loss");
		}

		System.out.println("Test case passed");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 3)
	public void WheelGameBetWithHighRisk() throws Exception {
		// VideoRecorder_utlity.startRecord("Wheel Game Bet With High Risk");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.00000002");

		log.info("Entering some Amount Successfully");

		WheelGamePage.RiskDropdown(driver).click();

		log.info("Clicked on RISK dropdown Successfully");

		WheelGamePage.HighRisk(driver).click();

		log.info("Clicked on High Risk");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelGameResult"))));

		WebElement Statistics = WheelGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		WheelGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = WheelGamePage.PayoutWheelGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt);

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" + PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		// System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if (WalletAmountAfterBET > WalletAmount) {
			System.out.println("User is in profit");
		} else if (TotalBalanceAfterBET.equals(Totalmoney)) {
			System.out.println("No Profit No Loss");
		} else {
			System.out.println("User is in Loss");
		}

		System.out.println("Test case passed");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 4)
	public void WheelGameBetWithAllSegments() throws Exception {
		// VideoRecorder_utlity.startRecord("Wheel Game Bet With All Segments");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.00000002");

		log.info("Entering some Amount Successfully");

		Double BetAmount = 0.00000002;

		WheelGamePage.SegmentsDropdown(driver).click();

		log.info("Clicked on Segment dropdown");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("Segment10"))));

		WheelGamePage.Segment10(driver).click();

		log.info("Clicked on 10 Segment");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelGameScore1"))));

		log.info("Wheel Result for 10 Segment is Visible Successfully");

		WheelGamePage.SegmentsDropdown(driver).click();

		log.info("Clicked on Segment dropdown");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("Segment20"))));

		WheelGamePage.Segment20(driver).click();

		log.info("Clicked on 20 Segment");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelGameScore2"))));

		log.info("Wheel Result for 20 Segment is Visible Successfully");

		WheelGamePage.SegmentsDropdown(driver).click();

		log.info("Clicked on Segment dropdown");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("Segment30"))));

		WheelGamePage.Segment30(driver).click();

		log.info("Clicked on 30 Segment");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelGameScore3"))));

		log.info("Wheel Result for 30 Segment is Visible Successfully");

		WheelGamePage.SegmentsDropdown(driver).click();

		log.info("Clicked on Segment dropdown");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("Segment40"))));

		WheelGamePage.Segment40(driver).click();

		log.info("Clicked on 40 Segment");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelGameScore4"))));

		log.info("Wheel Result for 40 Segment is Visible Successfully");

		WheelGamePage.SegmentsDropdown(driver).click();

		log.info("Clicked on Segment dropdown");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("Segment50"))));

		WheelGamePage.Segment50(driver).click();

		log.info("Clicked on 50 Segment");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelGameScore5"))));

		log.info("Wheel Result for 50 Segment is Visible Successfully");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 5)
	public void WheelGameBetWithHalfAmount() throws Exception {
		// VideoRecorder_utlity.startRecord("Wheel Game Bet With Half Amount");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.00000004");

		log.info("Entering some Amount Successfully");

		WheelGamePage.HalfAmount(driver).click();

		log.info("Click on 1/2 Button Successfully");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelGameResult"))));

		WebElement Statistics = WheelGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		WheelGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = WheelGamePage.PayoutWheelGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt);

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" + PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		// System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if (WalletAmountAfterBET > WalletAmount) {
			System.out.println("User is in profit");
		} else if (TotalBalanceAfterBET.equals(Totalmoney)) {
			System.out.println("No Profit No Loss");
		} else {
			System.out.println("User is in Loss");
		}

		System.out.println("Test case passed");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 6)
	public void WheelGameBetWithDoubleAmount() throws Exception {
		// VideoRecorder_utlity.startRecord("Wheel Game Bet With Double Amount");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default Amount Successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default Amount Successfully");

		Amount.sendKeys("0.00000002");

		log.info("Entering some Amount Successfully");

		WheelGamePage.DoubleAmount(driver).click();

		log.info("Click on 2x Button Successfully");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelGameResult"))));

		WebElement Statistics = WheelGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		WheelGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = WheelGamePage.PayoutWheelGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt);

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" + PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		// System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if (WalletAmountAfterBET > WalletAmount) {
			System.out.println("User is in profit");
		} else if (TotalBalanceAfterBET.equals(Totalmoney)) {
			System.out.println("No Profit No Loss");
		} else {
			System.out.println("User is in Loss");
		}

		System.out.println("Test case passed");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 7)
	public void WheelGameBetWithMaximumAmount() throws Exception {
		// VideoRecorder_utlity.startRecord("Wheel Game Bet With Maximum Amount");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("90.00000100");

		log.info("Entering some Amount Successfully");

		String MaxAmountExceed = WheelGamePage.WheelGameMaxBalanceError(driver).getText();

		Assert.assertEquals(MaxAmountExceed, "You can't bet more than your balance!");

		log.info("Maximum balance warning message is visible successfully");

		System.out.println(MaxAmountExceed);

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 8)
	public void WheelGameSetting() throws Exception {
		// VideoRecorder_utlity.startRecord("Wheel Game Setting");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WheelGamePage.WheelGameSettingICon(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("SettingsPopup"))));

		log.info("Wheelgame Settings Popup is Visible Successfully");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 9)
	public void WheelGameRules() throws Exception {
		// VideoRecorder_utlity.startRecord("Wheel Game Rules");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WheelGamePage.WheelGameRulesICon(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("RulesPopup"))));

		log.info("Wheelgame Rules Popup is Visible Successfully");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 10)
	public void WheelGameLiveStatsButton() throws Exception {
		// VideoRecorder_utlity.startRecord("WheelGame Live Stats Button");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WheelGamePage.WheelGameLiveStatusIcon(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("LiveStatsPopup"))));

		log.info("Wheelgame Live Stats Popup is Visible Successfully");

		// VideoRecorder_utlity.stopRecord();
	}

	
	
	@Test(enabled = true, priority = 11)
	public void WheelGameLiveStatsChecking() throws Exception {
		
		// VideoRecorder_utlity.startRecord("WheelGame Live Stats Button");
		
		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));
		
		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");

		log.info("Entering some Amount Successfully");

		WheelGamePage.WheelGameLiveStatusIcon(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("LiveStatsPopup"))));

		log.info("Wheelgame Live Stats Popup is Visible Successfully");
		
		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelGameResult"))));
		
		Thread.sleep(3000);
		
        String ActText = WheelGamePage.WheelGameLiveStatsPopUp(driver).getText();
		
		System.out.println(ActText);
		
		log.info("Wheelgame Live Stats Popup text is getting Successfully");
		
		// VideoRecorder_utlity.stopRecord();
		
	}
	
	@Test(enabled = true, priority = 12)
	public void WheelGameFairnessButton() throws Exception {
		// VideoRecorder_utlity.startRecord("WheelGame Fairness Button");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));
		
		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		Amount.sendKeys(Keys.DELETE);

		Amount.sendKeys("0.00000002");

		log.info("Entering some Amount Successfully");

		WheelGamePage.RiskDropdown(driver).click();

		log.info("Clicked on RISK dropdown Successfully");

		WheelGamePage.LowRisk(driver).click();

		log.info("Clicked on Low Risk");

		WheelGamePage.BetButton(driver).click();

		log.info("Bet button clicked successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelGameResult"))));

		WheelGamePage.WheelGameFairnessIcon(driver).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("FairnessPopup"))));

		log.info("Wheelgame FAIRNESS Popup is Visible Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WheelProperty("Change"))));

		WheelGamePage.FAIRNESSChangeButton(driver).click();

		log.info("Wheelgame Fairness PopUp 'CHANGE' Button Clicked Successfully");

		WebElement ServerSeed = WheelGamePage.WheelGameFairnessServerSeed(driver);

		WebElement ServerSeedHashed = WheelGamePage.WheelGameFairnessServerSeedHashed(driver);

		WheelGamePage.WheelGameFairnessGoToTransaction(driver).click();

		log.info("Wheelgame Fairness PopUp 'Go to Transaction Link' Clicked Successfully");

		WheelGamePage.WheelGameFairnessTransactionsRow(driver).click();

		WheelGamePage.WheelGameFairnessVerifyBet(driver).click();

		log.info("Wheelgame Fairness PopUp Verify Bet button Clicked Successfully");

		String GameName = WheelGamePage.WheelGameFairnessGameTab(driver).getText();

		System.out.println(GameName);

		log.info("Wheelgame Fairness PopUp Game Name get Successfully");

		String Risk = WheelGamePage.WheelGameFairnessRiskTab(driver).getText();

		System.out.println(Risk);

		log.info("Wheelgame Fairness PopUp Risk Tab text get Successfully");

		String Rows = WheelGamePage.WheelGameFairnessRowsTab(driver).getText();

		System.out.println(Rows);

		log.info("Wheelgame Fairness PopUp Rows Tab Text get Successfully");

		Assert.assertNotEquals(ServerSeed, ServerSeedHashed, "Failed :Both results are same");

		System.out.println("Test case passed");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 13)
	public void WheelGameAutoBetTab() throws Exception {

		// VideoRecorder_utlity.startRecord("WheelGame AutoBet Tab");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("AUTO"))));

		WheelGamePage.WheelGameAutoButton(driver).click();

		log.info("AUTO Button Clicked Successfully ");

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default amount successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default amount successfully");

		Amount.sendKeys("0.00000002");

		log.info("Entering some amount successfully");

		WheelGamePage.AutoStartButton(driver).click();

		log.info("Start Auto Button Clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelGameScore2"))));

		WheelGamePage.StopAutoBettButton(driver).click();

		log.info("Clicked on Stop Auto bet button");

		WebElement Statistics = WheelGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		WheelGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = WheelGamePage.PayoutWheelGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt);

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" + PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		// System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if (WalletAmountAfterBET > WalletAmount) {
			System.out.println("User is in profit");
		} else if (TotalBalanceAfterBET.equals(Totalmoney)) {
			System.out.println("No Profit No Loss");
		} else {
			System.out.println("User is in Loss");
		}

		System.out.println("Test case passed");
		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 14)
	public void WheelGameAutoHalfAmount() throws Exception {

		// VideoRecorder_utlity.startRecord("Wheel Game Auto Half Amount");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("AUTO"))));

		WheelGamePage.WheelGameAutoButton(driver).click();

		log.info("AUTO Button Clicked Successfully ");

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default amount successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default amount successfully");

		Amount.sendKeys("0.00000002");

		log.info("Entering some amount successfully");

		Double BetAmount = 0.00000002;

		WheelGamePage.HalfAmount(driver).click();

		log.info("Clicked on 1/2 button Successfully");

		WheelGamePage.AutoStartButton(driver).click();

		log.info("Start Auto Button Clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelGameScore2"))));

		log.info("Waiting until 2nd Wheel Score Announce ");

		WheelGamePage.StopAutoBettButton(driver).click();

		log.info("Stop Auto Bet Button Clicked Successfully");

		WebElement Statistics = WheelGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		WheelGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = WheelGamePage.PayoutWheelGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt);

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" + PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		// System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if (WalletAmountAfterBET > WalletAmount) {
			System.out.println("User is in profit");
		} else if (TotalBalanceAfterBET.equals(Totalmoney)) {
			System.out.println("No Profit No Loss");
		} else {
			System.out.println("User is in Loss");
		}

		System.out.println("Test case passed");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 15)
	public void WheelGameAutoDoubleAmount() throws Exception {

		// VideoRecorder_utlity.startRecord("WheelGame Auto Double Amount");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("AUTO"))));

		WheelGamePage.WheelGameAutoButton(driver).click();

		log.info("AUTO Button Clicked Successfully ");

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default amount successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default amount successfully");

		Amount.sendKeys("0.00000002");

		log.info("Entering some amount successfully");

		WheelGamePage.DoubleAmount(driver).click();

		log.info("Clicked on 2x button Successfully");

		WheelGamePage.AutoStartButton(driver).click();

		log.info("Start Auto Button Clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelGameScore2"))));

		log.info("Waiting until 2nd Wheel Score Announce ");

		WheelGamePage.StopAutoBettButton(driver).click();

		log.info("Stop Auto Bet Button Clicked Successfully");

		WebElement Statistics = WheelGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		WheelGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = WheelGamePage.PayoutWheelGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt);

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" + PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		// System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if (WalletAmountAfterBET > WalletAmount) {
			System.out.println("User is in profit");
		} else if (TotalBalanceAfterBET.equals(Totalmoney)) {
			System.out.println("No Profit No Loss");
		} else {
			System.out.println("User is in Loss");
		}

		System.out.println("Test case passed");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 16)
	public void WheelGameAutoNumberOfBetsTwo() throws Exception {

		// VideoRecorder_utlity.startRecord("WheelGame Auto Number Of Bets Two");

		Homepage page = new Homepage(driver);

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		page.Login(driver);

		log.info("Login Successfully with valid username and valid Password ");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("AUTO"))));

		WheelGamePage.WheelGameAutoButton(driver).click();

		log.info("AUTO Button Clicked Successfully ");

		WebElement Amount = WheelGamePage.BetAmountinputField(driver);

		Amount.sendKeys(Keys.CONTROL, "a");

		log.info("Selecting all default amount successfully");

		Amount.sendKeys(Keys.DELETE);

		log.info("Deleted default amount successfully");

		Amount.sendKeys("0.00000002");

		log.info("Entering some amount successfully");

		Double BetAmount = 0.00000002;

		WheelGamePage.NoOfBETSButton(driver).sendKeys("2");

		log.info("2 Number of Bets Entered Successfully");

		WheelGamePage.AutoStartButton(driver).click();

		log.info("Start Auto Button Clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("WheelGameScore2"))));

		log.info("Verifying two Wheel Scores are Visible Successfully");

		WebElement Statistics = WheelGamePage.MyBets(driver);

		js.executeScript("arguments[0].scrollIntoView();", Statistics);

		WheelGamePage.MyBets(driver).click();

		Thread.sleep(4000);

		WebElement Payout = WheelGamePage.PayoutWheelGame(driver);

		String PayoutAmt = Payout.getAttribute("innerText");

		log.info("Getting Payout Successfully through string format");

		System.out.println("Payout  =" + PayoutAmt);

		double PayoutAmount = Double.parseDouble(PayoutAmt);

		System.out.println("PayoutAmount =" + PayoutAmount);

		WebElement walletBalanceAfterBET = Homepage.WalletBalanceDropdown(driver);

		String TotalBalanceAfterBET = walletBalanceAfterBET.getAttribute("innerText");

		// System.out.println("TotalBalance ="+TotalBalanceAfterBET);

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmountAfterBET = new Double(TotalBalanceAfterBET);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmountAfterBET = BigDecimal.valueOf(WalletAmountAfterBET);

		System.out.println("Total Amount in you wallet After BET=  " + DashboardWalletAmountAfterBET);

		log.info("Converting string Payout Amount into number successfully");

		System.out.println("-------------------------------------------");

		if (WalletAmountAfterBET > WalletAmount) {
			System.out.println("User is in profit");
		} else if (TotalBalanceAfterBET.equals(Totalmoney)) {
			System.out.println("No Profit No Loss");
		} else {
			System.out.println("User is in Loss");
		}

		System.out.println("Test case passed");

		// VideoRecorder_utlity.stopRecord();
	}

	@AfterMethod
	public void EndTest() {
		driver.close();

		log.info("Browser closed");
	}

}
