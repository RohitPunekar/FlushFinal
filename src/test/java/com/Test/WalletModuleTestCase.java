package com.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.WalletModule;
import pageObjects.WelcomePopup;
import resources.base;

public class WalletModuleTestCase extends base
{
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
	public void WalletModuleFlow() throws IOException
	{
		//VideoRecorder_utlity.startRecord("Wallet Module Flow checking");

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
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WalletProperty("UserName"))));
				
				WalletModule.WalletIcon(driver).click();
				
				log.info("Clicked Walletn button");
				
				//VideoRecorder_utlity.stopRecord();
				
	}		
						
		@Test(enabled = true, priority = 2)
	     public void WalletDepositSectionBTC() throws IOException, InterruptedException
		{
			//VideoRecorder_utlity.startRecord("Wallet BTC Deposit section");

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
							
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WalletProperty("UserName"))));
							
			WalletModule.WalletIcon(driver).click();
							
		    log.info("Clicked Walletn button");
		    
		   WalletModule.Deposit(driver).click();
			
			log.info("Clicked Deposit button");
			
			WalletModule.DepositCurrency(driver).click();
			
			log.info("Clicked on Deposit currency Successfully");
			
			WalletModule.DepositDOGE(driver).click();
			
			WalletModule.DepositCurrency(driver).click();
			
			WalletModule.DepositCurrencyBTC(driver).click();
			
			log.info("Clicked Deposit BTC currency Successfully");
			
			String Address = WalletModule.DepositCurrencyAddress(driver).getAttribute("value");

			System.out.println("Deposite Address = "+ Address);
			
			log.info("Getting BTC  Deposit Address Successfully");
			
			//VideoRecorder_utlity.stopRecord();
		    							
	}	
		@Test(enabled = true, priority = 3)
	     public void WalletDepositSectionDOGE() throws IOException
		{
			//VideoRecorder_utlity.startRecord("Wallet DOGE Deposit section");

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
							
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WalletProperty("UserName"))));
							
			WalletModule.WalletIcon(driver).click();
							
		    log.info("Clicked Walletn button");
		    
		    WalletModule.Deposit(driver).click();
			
			log.info("Clicked Deposit button");
			
			WalletModule.DepositCurrency(driver).click();
			
			log.info("Clicked on Deposit currency Successfully");
			
			WalletModule.DepositDOGE(driver).click();
			
			log.info("Clicked Deposit DOGE currency Successfully");
			
			String Address = WalletModule.DepositCurrencyAddress(driver).getAttribute("value");

			System.out.println("Deposit Address = "+ Address);
			
			log.info("Getting DOGE Deposit Address Successfully");
			
			//VideoRecorder_utlity.stopRecord();
		    							
	}	
		@Test(enabled = true, priority = 4)
	     public void WalletDepositSectionLTC() throws IOException
		{
			//VideoRecorder_utlity.startRecord("Wallet LTC Deposit section");

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
							
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WalletProperty("UserName"))));
							
			WalletModule.WalletIcon(driver).click();
							
		    log.info("Clicked Walletn button");
		    
		    WalletModule.Deposit(driver).click();
			
			log.info("Clicked Deposit button");
			
			WalletModule.DepositCurrency(driver).click();
			
			log.info("Clicked on Deposit currency Successfully");
			
			WalletModule.DepositLTC(driver).click();
			
			log.info("Clicked Deposit LTC currency Successfully");
			
			String Address = WalletModule.DepositCurrencyAddress(driver).getAttribute("value");

			System.out.println("Deposit Address = "+ Address);
			
			log.info("Getting LTC Deposit Address Successfully");
			
			//VideoRecorder_utlity.stopRecord();
		    							
	}	
		@Test(enabled = true, priority = 5)
	     public void WalletDepositSectionETH() throws IOException
		{
			//VideoRecorder_utlity.startRecord("Wallet ETH Deposit section");

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
							
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WalletProperty("UserName"))));
							
			WalletModule.WalletIcon(driver).click();
							
		    log.info("Clicked Walletn button");
		    
		    WalletModule.Deposit(driver).click();
			
			log.info("Clicked Deposit button");
			
			WalletModule.DepositCurrency(driver).click();
			
			log.info("Clicked on Deposit currency Successfully");
			
			WalletModule.DepositETH(driver).click();
			
			log.info("Clicked Deposit ETH currency Successfully");
			
			String Address = WalletModule.DepositCurrencyAddress(driver).getAttribute("value");

			System.out.println("Deposit Address = "+ Address);
			
			log.info("Getting ETH Deposit Address Successfully");
			
			//VideoRecorder_utlity.stopRecord();
		    							
	}	
		@Test(enabled = true, priority = 6)
	     public void WalletDepositSectionMATIC() throws IOException
		{
			//VideoRecorder_utlity.startRecord("Wallet MATIC Deposit section");

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
							
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WalletProperty("UserName"))));
							
			WalletModule.WalletIcon(driver).click();
							
		    log.info("Clicked Walletn button");
		    
		    WalletModule.Deposit(driver).click();
			
			log.info("Clicked Deposit button");
			
			WalletModule.DepositCurrency(driver).click();
			
			log.info("Clicked on Deposit currency Successfully");
			
			WalletModule.DepositMATIC(driver).click();
			
			log.info("Clicked Deposit MATIC currency Successfully");
			
			String Address = WalletModule.DepositCurrencyAddress(driver).getAttribute("value");

			System.out.println("Deposit Address = "+ Address);
			
			log.info("Getting MATIC Deposit Address Successfully");
			
			//VideoRecorder_utlity.stopRecord();
		    							
	}	
		@Test(enabled = true, priority = 7)
	     public void WalletDepositSectionBNB() throws IOException
		{
			//VideoRecorder_utlity.startRecord("Wallet BNB Deposit section");

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
							
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WalletProperty("UserName"))));
							
			WalletModule.WalletIcon(driver).click();
							
		    log.info("Clicked Walletn button");
		    
		    WalletModule.Deposit(driver).click();
			
			log.info("Clicked Deposit button");
			
			WalletModule.DepositCurrency(driver).click();
			
			log.info("Clicked on Deposit currency Successfully");
			
			WalletModule.DepositBNB(driver).click();
			
			log.info("Clicked Deposit BNB currency Successfully");
			
			String Address = WalletModule.DepositCurrencyAddress(driver).getAttribute("value");

			System.out.println("Deposit Address = "+ Address);
			
			log.info("Getting BNB Deposit Address Successfully");
			
			//VideoRecorder_utlity.stopRecord();
		    							
	}	
	
		@Test(enabled = true, priority = 8)
	     public void WalletWithdrawSection() throws IOException
		{
			//VideoRecorder_utlity.startRecord("Wallet withdraw Section");

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
							
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WalletProperty("UserName"))));
							
			WalletModule.WalletIcon(driver).click();
							
		    log.info("Clicked Walletn button");
		
		    WalletModule.Withdraw(driver).click();
			
			log.info("Clicking on Withdraw Successfully");
			
			String YourBalance = WalletModule.YourBalance(driver).getText();
			
			System.out.println("Your Balance = "+YourBalance);
			
			double Balance = Double.parseDouble(YourBalance);
			
			WalletModule.WithdrawalAddress(driver).sendKeys(f.WalletProperty("WithdrawalAddress"));
			
			log.info("Withdraw address sent Successfully");
			
			WebElement WithdrawAmount = WalletModule.WithdrawAmount(driver);
			
			WithdrawAmount.sendKeys("1.00050000");
			
			log.info("Withdraw Amount sent Successfully");
			
			String WithdrawAmt = WithdrawAmount.getAttribute("value");
			
			System.out.println("Withdraw Amount = "+WithdrawAmt);
			
			double WAmount = Double.parseDouble(WithdrawAmt);
			
			if(Balance > WAmount)
				{
				WalletModule.WithdrawAmountButton(driver).click();
			
				log.info("Clicking on Withdraw Amount Successfully");
			
				String SuccessMessage = WalletModule.WithdrawSuccessMessage(driver).getText();
				
				System.out.println("Withdrawal Message = "+SuccessMessage);
				}
			else
				{
				System.out.println("You don't have sufficient balance to withdraw");
				}
			
			//VideoRecorder_utlity.stopRecord();		
	}	
		
		@Test(enabled = true, priority = 9)
	     public void WalletWithdrawMaxAmount() throws IOException, InterruptedException
		{
			//VideoRecorder_utlity.startRecord("Wallet Module withdraw maximum amount");

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
							
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WalletProperty("UserName"))));
							
			WalletModule.WalletIcon(driver).click();
							
		    log.info("Clicked Walletn button");
		
		   WalletModule.Withdraw(driver).click();
			
			log.info("Clicking on Withdraw Successfully");
			
			String YourBalance = WalletModule.YourBalance(driver).getText();
			
			System.out.println("Your Balance = "+YourBalance);
			
			WalletModule.WithdrawalAddress(driver).sendKeys(f.WalletProperty("WithdrawalAddress"));     
			
			log.info("Withdrawal address sent Successfully");
			
			WalletModule.WithdrawmaxButton(driver).click();
			
			log.info("Clicking on Max button Successfully");
			
		    WebElement WithdrawAmount = WalletModule.WithdrawAmount(driver); 
		     
		    String Amount = WithdrawAmount.getAttribute("value");

			System.out.println("Max Amount = "+Amount);
			
			Assert.assertEquals(YourBalance, Amount,"Failed: both results are different");
			
			//VideoRecorder_utlity.stopRecord();		
	}

		@Test(enabled = true, priority = 10)
	     public void WalletWithdrawMinAmount() throws IOException, InterruptedException
		{
			//VideoRecorder_utlity.startRecord("Wallet Module withdraw Minimum amount");

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
							
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.WalletProperty("UserName"))));
							
			WalletModule.WalletIcon(driver).click();
							
		    log.info("Clicked Walletn button");
		
		    WalletModule.Withdraw(driver).click();
			
			log.info("Clicking on Withdraw Successfully");
			
			String YourBalance = WalletModule.YourBalance(driver).getText();
			
			System.out.println("Your Balance = "+YourBalance);
			
			WalletModule.WithdrawalAddress(driver).sendKeys(f.WalletProperty("WithdrawalAddress"));     
			
			log.info("Withdrawal address sent Successfully");
			
			String ActualText = WalletModule.WithdrawMinAmount(driver).getText();
			
			System.out.println(ActualText);
			
			String MinAmount = ActualText.replaceAll("[^0.0-9]","" );
			
			System.out.println("Min Amount = "+MinAmount);
			
			WebElement WithdrawAmount = WalletModule.WithdrawAmount(driver);
			
			WithdrawAmount.sendKeys(MinAmount);
			
			WalletModule.WithdrawAmountButton(driver).click();
			
			log.info("Withdraw Amount Button clicked Successfully");
			
			String SuccessMessage = WalletModule.WithdrawSuccessMessage(driver).getText();
			
			System.out.println("Withdrawal Message = "+SuccessMessage);
			
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