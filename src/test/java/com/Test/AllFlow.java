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
import pageObjects.WelcomePopup;
import resources.base;

public class AllFlow extends base {
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

		//VideoRecorder_utlity.startRecord("Login User ");

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

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User Login Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 2)
	public void DiceGame() throws Exception {

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

//			wait.until(ExpectedConditions.visibilityOfElementLocated(
//					By.xpath(f.FlushProperty("PanelDicenumber"))));

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

//				System.out.println("Getting calculation ouptput "+ s1);
//				
//				System.out.println("Getting dashboard amount "+ Totalmoney1);

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

//				System.out.println("Getting calculation ouptput "+ s2);
//				
//				System.out.println("Getting dashboard amount "+ Totalmoney2);

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
	
	@AfterMethod
	public void EndTest() 
	{
		 driver.close();
		 
		 log.info("Browser closed");
	}

}
