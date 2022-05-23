package com.Test;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
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
import pageObjects.Adminpanel;
import pageObjects.CrashGamePage;
import pageObjects.DashboardPage;
import pageObjects.DiceGamePage;
import pageObjects.Homepage;
import pageObjects.WelcomePopup;
import pageObjects.WheelGamePage;
import resources.base;
import variables.ConfigProperties;

public class HomepageTest extends base {

	public WebDriver driver;

	public Homepage homepage;

	public WebDriverWait wait;

	TestFileinput f = new TestFileinput();

	@BeforeMethod
	public void initialize() throws IOException 
	{
		driver =initializeDriver();

		driver.get(prop.getProperty("url"));

		log.info("Browser invoked");
	}

	@Test(enabled =  true, priority = 1)
	public void LoginAsValidUser() throws Exception {

		//VideoRecorder_utlity.startRecord("Login As Valid User");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 2)
	public void InvalidUser() throws Exception {

		//VideoRecorder_utlity.startRecord("InvalidUser");

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

		WelcomePopup.Welcomeemail(driver).sendKeys("user@rapidinnovation.dev");

		log.info("Entered Invalid username");

		WelcomePopup.Welcomepassword(driver).sendKeys("hello@123");

		log.info("Entered Invalid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Error"))));

		WebElement element = homepage.Error(driver);

		String Expected = element.getAttribute("innerText");

		System.out.println(Expected);

		String actual = "Error\n"
				+ "\n"
				+ "Invalid username or password.";

		Assert.assertEquals(Expected, actual);

		log.info("Invalid username or password error showing successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 3)
	public void UserLogout() throws Exception {

		//VideoRecorder_utlity.startRecord("User Logout");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on user dropdown");

		DashboardPage.Logout(driver).click();

		log.info("Clicked on logout button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

		log.info("Log in button visible successfully on landing page");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 4)
	public void LoginWelcomeForgot() throws Exception {

		//VideoRecorder_utlity.startRecord("Login Welcome Forgot");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeForgotPassword"))));

		WelcomePopup.WelcomeForgotPassword(driver).click();

		log.info("Clicked on forgot password link");

		WelcomePopup.RecoveryEmailInputbox(driver).sendKeys(f.LoginProperty("GmailGoogleLogin"));

		log.info("Entered recovery email");

		WelcomePopup.PasswordRecoverySendButton(driver).click();

		log.info("Clicked on send button");

		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(f.LoginProperty("PasswordRequestSentToEmailText"))));

			WebElement forgtorpasswordmessage = WelcomePopup.PasswordRequestSentToEmailText(driver);

			String Expected = forgtorpasswordmessage.getAttribute("innerText");

			System.out.println(Expected);

		} catch (Exception e) {

			WebElement forgtorpasswordmessage = WelcomePopup.PasswordRequestSentToEmailText(driver);

			String Expected = forgtorpasswordmessage.getAttribute("innerText");

			System.out.println(Expected);

		}

		log.info("Password Request Sent to Email text visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 5)
	public void RecoveryPasswordBackToLogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Recovery Password Back To Login");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeForgotPassword"))));

		WelcomePopup.WelcomeForgotPassword(driver).click();

		log.info("Clicked on forgot password link");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("PasswordRecoveryBackToLogin"))));

		WelcomePopup.PasswordRecoveryBackToLogin(driver).click();

		log.info("Clicked on Back to login button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeForgotPassword"))));

		log.info("Redirected to login page successfully");

		//VideoRecorder_utlity.stopRecord();
	}


	@Test(enabled =  true, priority = 6)
	public void LoginWelcomeRegistration() throws Exception {

		//VideoRecorder_utlity.startRecord("Login Welcome Registration");

		String name = "user";

		wait = new WebDriverWait(driver, 50);

		Random rand = new Random();

		int rand_int1 = rand.nextInt(1000);

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

		WelcomePopup.Registration(driver).click();	

		log.info("Register button clicked successfully");

		WelcomePopup.RegisterUserName(driver).sendKeys(name + rand_int1);

		log.info("Entered username");

		WelcomePopup.RegisterEmailid(driver).sendKeys(name + rand_int1 + "@gmail.com");

		log.info("Entered Email id");

		WelcomePopup.RegisterPassword(driver).sendKeys("User@435");

		log.info("Entered password");

		WelcomePopup.TermsAndConditionsCheckbox(driver).click();

		log.info("Clicked on Terms&Conditions checkbox");

		WebElement PlayNowBtn=WelcomePopup.PlayNowbutton(driver);

		Actions action = new Actions(driver);

		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {

			action.moveToElement(PlayNowBtn).click().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		} catch(Exception e) {

			j.executeScript("arguments[0].click();", PlayNowBtn);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		} 

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		//VideoRecorder_utlity.stopRecord();
	}


	@Test(enabled = true, priority = 7)
	public void LoginWelcomeGoogleIcon() throws Exception {

		//VideoRecorder_utlity.startRecord("Login Welcome Google");

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

		Thread.sleep(25000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeGoogleIcon"))));

		Actions action = new Actions(driver);

		WebElement Google = WelcomePopup.WelcomeGoogleIcon(driver);

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeGoogleIcon"))));

			Google.click();
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeGoogleIcon"))));

			action.moveToElement(Google).click().perform();
		}

		log.info("Clicked on google icon");

		Set<String> windows = driver.getWindowHandles();   //[parent id,child id]

		Iterator<String> it = windows.iterator();

		String parentID = it.next();

		String childID = it.next();

		driver.switchTo().window(childID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("GmailEmail"))));

		WelcomePopup.GmailEmail(driver).sendKeys(f.LoginProperty("GmailGoogleLogin"));

		log.info("Entered gmail id");

		WelcomePopup.EmailNext(driver).click();

		log.info("Clicked on next button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("GmailPassword"))));

		WelcomePopup.GmailPassword(driver).sendKeys(f.LoginProperty("GmailGooglePassword"));

		log.info("Entered gmail password");

		WelcomePopup.PasswordNext(driver).click();

		log.info("Clicked on next button");

		driver.switchTo().window(parentID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Userdropdown"))));

		log.info("User dropdown visible successfully on Dashboard page");

		WelcomePopup.Userdropdown(driver).click();

		log.info("Clicked on User Dropdown successfully");

		WelcomePopup.Logout(driver).click();

		log.info("User logged out successfully");

		//VideoRecorder_utlity.stopRecord();
	}


	@Test(enabled =  true, priority = 8)
	public void SignupLogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Signup Login");

		ConfigProperties.LoginPropertiesFile();

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Signup"))));

		WelcomePopup.Signup(driver).click();

		log.info("Clicked on signup button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

		WelcomePopup.Login(driver).click();

		log.info("Clicked on login button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Welcomeemail"))));

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid email");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WebElement PlayNowBtn=WelcomePopup.PlayNowbutton(driver);

		Actions action = new Actions(driver);

		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {

			action.moveToElement(PlayNowBtn).click().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		} catch(Exception e) {

			j.executeScript("arguments[0].click();", PlayNowBtn);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		} 

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 9)
	public void Signup() throws Exception {

		//VideoRecorder_utlity.startRecord("Signup Login");

		String name = "rohit";

		wait = new WebDriverWait(driver, 50);

		Random rand = new Random();

		int rand_int1 = rand.nextInt(1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Signup"))));

		WelcomePopup.Signup(driver).click();

		log.info("Register button clicked successfully");

		WelcomePopup.RegisterUserName(driver).sendKeys(name + rand_int1);

		log.info("Entered username");

		WelcomePopup.RegisterEmailid(driver).sendKeys(name + rand_int1 + "@gmail.com");

		log.info("Entered Email id");

		WelcomePopup.RegisterPassword(driver).sendKeys("User@435");

		log.info("Entered password");

		WelcomePopup.TermsAndConditionsCheckbox(driver).click();

		log.info("Clicked on Terms&Conditions checkbox");

		WebElement PlayNowBtn=WelcomePopup.PlayNowbutton(driver);

		Actions action = new Actions(driver);

		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {

			action.moveToElement(PlayNowBtn).click().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		} catch(Exception e) {

			j.executeScript("arguments[0].click();", PlayNowBtn);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		} 

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 10)
	public void SignupGoogleLogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Signup Google Login");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Signup"))));

		WelcomePopup.Signup(driver).click();

		log.info("Signup button clicked successfully");

		Thread.sleep(25000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeGoogleIcon"))));

		Actions action = new Actions(driver);

		WebElement Google = WelcomePopup.WelcomeGoogleIcon(driver);

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeGoogleIcon"))));

			Google.click();
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeGoogleIcon"))));

			action.moveToElement(Google).click().perform();
		}

		log.info("Clicked on google icon");

		Set<String> windows = driver.getWindowHandles();   //[parent id,child id]

		Iterator<String> it = windows.iterator();

		String parentID = it.next();

		String childID = it.next();

		driver.switchTo().window(childID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("GmailEmail"))));

		WelcomePopup.GmailEmail(driver).sendKeys(f.LoginProperty("GmailGoogleLogin"));

		log.info("Entered gmail id");

		WelcomePopup.EmailNext(driver).click();

		log.info("Clicked on next button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("GmailPassword"))));

		WelcomePopup.GmailPassword(driver).sendKeys(f.LoginProperty("GmailGooglePassword"));

		log.info("Entered gmail password");

		WelcomePopup.PasswordNext(driver).click();

		log.info("Clicked on next button");

		driver.switchTo().window(parentID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Userdropdown"))));

		log.info("User dropdown visible successfully on Dashboard page");

		WelcomePopup.Userdropdown(driver).click();

		log.info("Clicked on User Dropdown successfully");

		WelcomePopup.Logout(driver).click();

		log.info("User logged out successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 11)
	public void JoinWithYourEmail() throws Exception {

		//VideoRecorder_utlity.startRecord("Join With Your Email");

		Random rand = new Random();

		String name = "user";

		int rand_int1 = rand.nextInt(1000);

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("slider1"))));

		Homepage.Slider1(driver).click();

		Homepage.JoinWithYouEmailButton(driver).click();

		log.info("Clicked on Join with your email");

		WelcomePopup.RegisterUserName(driver).sendKeys(name + rand_int1);

		log.info("Entered username");

		WelcomePopup.RegisterEmailid(driver).sendKeys(name + rand_int1 + "@gmail.com");

		log.info("Entered Email id");

		WelcomePopup.RegisterPassword(driver).sendKeys("User@435");

		log.info("Entered password");

		WelcomePopup.TermsAndConditionsCheckbox(driver).click();

		log.info("Clicked on Terms&Conditions checkbox");

		WebElement PlayNowBtn=WelcomePopup.PlayNowbutton(driver);

		Actions action = new Actions(driver);

		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {

			action.moveToElement(PlayNowBtn).click().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		} catch(Exception e) {

			j.executeScript("arguments[0].click();", PlayNowBtn);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		} 

		log.info("Wallet Button Visible Successfully on Dashboard Page");



		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 12)
	public void JoinEmailLogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Join Email Login");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("slider1"))));

		Homepage.Slider1(driver).click();

		Homepage.JoinWithYouEmailButton(driver).click();

		log.info("Clicked on Join with your email");

		WelcomePopup.Login(driver).click();

		log.info("Cliked on login button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Welcomeemail"))));

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WebElement PlayNowBtn=WelcomePopup.PlayNowbutton(driver);

		Actions action = new Actions(driver);

		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {

			action.moveToElement(PlayNowBtn).click().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		} catch(Exception e) {

			j.executeScript("arguments[0].click();", PlayNowBtn);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		} 

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 13)
	public void JoinEmailGoogleLogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Join Email Google Login");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("JoinWithYourEmailButton"))));

		WebElement email = driver.findElement(By.xpath(f.LoginProperty("JoinWithYourEmailButton")));

		Actions action = new Actions(driver);

		action.moveToElement(email).perform();

		email.click();

		log.info("Clicked on Join with your email");

		Thread.sleep(25000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeGoogleIcon"))));

		WebElement Google = WelcomePopup.WelcomeGoogleIcon(driver);

		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeGoogleIcon"))));

			Google.click();
		}
		catch(Exception e)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WelcomeGoogleIcon"))));

			action.moveToElement(Google).click().perform();
		}

		log.info("Clicked on google icon");

		Set<String> windows = driver.getWindowHandles();   //[parent id,child id]

		Iterator<String> it = windows.iterator();

		String parentID = it.next();

		String childID = it.next();

		driver.switchTo().window(childID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("GmailEmail"))));

		WelcomePopup.GmailEmail(driver).sendKeys(f.LoginProperty("GmailGoogleLogin"));

		log.info("Entered gmail id");

		WelcomePopup.EmailNext(driver).click();

		log.info("Clicked on next button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("GmailPassword"))));

		WelcomePopup.GmailPassword(driver).sendKeys(f.LoginProperty("GmailGooglePassword"));

		log.info("Entered gmail password");

		WelcomePopup.PasswordNext(driver).click();

		log.info("Clicked on next button");

		driver.switchTo().window(parentID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Userdropdown"))));

		log.info("User dropdown visible successfully on Dashboard page");

		WelcomePopup.Userdropdown(driver).click();

		log.info("Clicked on User Dropdown successfully");

		WelcomePopup.Logout(driver).click();

		log.info("User logged out successfully");

		//VideoRecorder_utlity.stopRecord();
	}















	@Test(enabled =  true, priority = 14)
	public void Adminpanel() throws Exception {

		//VideoRecorder_utlity.startRecord("Admin panel");

		wait = new WebDriverWait(driver, 50);

		driver.get("http://3.236.10.147/login");

		log.info("Redirceted to admin Url");

		Adminpanel.AdminUsername(driver).sendKeys(f.LoginProperty("AdminUsername"));

		log.info("Entered admin username");

		Adminpanel.AdminPassword(driver).sendKeys(f.LoginProperty("AdminPassword"));

		log.info("Entered admin password");

		Adminpanel.AdminPanelLogin(driver).click();

		log.info("Clicked on login button on admin panel");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Logout"))));

		log.info("Logout Button Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 15)
	public void Dicegame() throws Exception {

		//VideoRecorder_utlity.startRecord("Dice game");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("FlushOriginalsHeader"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();

		log.info("Dice game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("BetButton"))));

		DashboardPage.BetButton(driver).click();

		log.info("Clicked on Bet button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Login"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Registration"))));

		log.info("User Login Page is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 16)
	public void DicegameLogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Dice game Login");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("FlushOriginalsHeader"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.LoginProperty("DiceLink"))));

		DiceGamePage.diceLink(driver).click();

		log.info("Dice game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("BetButton"))));

		DashboardPage.BetButton(driver).click();

		log.info("Clicked on Bet button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Login"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Welcomeemail"))));

		log.info("Login Page is Visible Successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username or email");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on play now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button is Visible Successfully");	

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 17)
	public void Crashgame() throws Exception {

		//VideoRecorder_utlity.startRecord("Crashgame");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("FlushOriginalsHeader"))));

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("BetNextRoundBtn"))));

		CrashGamePage.BetNextRoundBtn(driver).click();

		log.info("Clicked on Bet button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Login"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Registration"))));

		log.info("Login page is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 18)
	public void CrashgameLogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Crash game Login");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("FlushOriginalsHeader"))));

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("BetNextRoundBtn"))));

		CrashGamePage.BetNextRoundBtn(driver).click();

		log.info("Clicked on Bet button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Login"))));

		log.info("Login page is opened");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username or email");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WebElement PlayNowBtn=WelcomePopup.PlayNowbutton(driver);

		Actions action = new Actions(driver);

		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {

			action.moveToElement(PlayNowBtn).click().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		} catch(Exception e) {

			j.executeScript("arguments[0].click();", PlayNowBtn);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		} 

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 19)
	public void Minesgame() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines game");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("FlushOriginalsHeader"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.FlushProperty("MinesGameLink"))));

		DashboardPage.MinesGameLink(driver).click();

		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("BetButton"))));

		DashboardPage.BetButton(driver).click();

		log.info("Clicked on Bet button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Login"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Registration"))));

		log.info("Login Popup is Visible Sucessfully ");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 20)
	public void Minesgamelogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Mines game login");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("FlushOriginalsHeader"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.FlushProperty("MinesGameLink"))));

		DashboardPage.MinesGameLink(driver).click();

		log.info("Mines game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("BetButton"))));

		DashboardPage.BetButton(driver).click();

		log.info("Clicked on Bet button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Login"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Welcomeemail"))));

		log.info("Login Popup is displayed");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username or email");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on play now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 21)
	public void Wheelgame() throws Exception {

		//VideoRecorder_utlity.startRecord("Wheel game");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("FlushOriginalsHeader"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("BetButton"))));

		DashboardPage.BetButton(driver).click();

		log.info("Clicked on Bet button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Login"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Registration"))));

		log.info("Login Popup is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 22)
	public void Wheelgamelogin() throws Exception {

		//VideoRecorder_utlity.startRecord("Wheel game login");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("FlushOriginalsHeader"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement OriginalsHeader = Homepage.FlushOriginalsHeader(driver);

		js.executeScript("arguments[0].scrollIntoView();", OriginalsHeader);

		log.info("Scrolling up to originals header");

		Thread.sleep(4000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.FlushProperty("WheelLink"))));

		WheelGamePage.WheelLink(driver).click();

		log.info("Wheel game link clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("BetButton"))));

		DashboardPage.BetButton(driver).click();

		log.info("Clicked on Bet button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Login"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Welcomeemail"))));

		log.info("Login Popup is displayed");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username or email");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on play now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}























	/*

	@Test(enabled =  true, priority = 23)
	public void Cashier() throws Exception {

		//VideoRecorder_utlity.startRecord("Cashier");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

		Homepage.Loginbutton(driver).click();

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on User Dropdown Menu");

		DashboardPage.Cashier(driver).click();

		log.info("Click on Cashier");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("Cashierpopupdropdown"))));

		log.info("Cashier Popup Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	 */

	@Test(enabled =  true, priority = 24)
	public void VIP() throws Exception {

		//VideoRecorder_utlity.startRecord("VIP");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on user dropdown menu");

		DashboardPage.VIP(driver).click();

		log.info("Clicked on VIP");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("VIPclub"))));

		log.info("VIP Page is Visible Successfully");	

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 25)
	public void Transaction() throws Exception {

		//VideoRecorder_utlity.startRecord("Transaction");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on user dropdown menu");

		DashboardPage.Transaction(driver).click();

		log.info("Clicked on transaction option");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("Transactionpageheader"))));

		log.info("Transaction page is Visible successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 26)
	public void TransactionPageTabsChecking() throws Exception {

		//VideoRecorder_utlity.startRecord("Transaction Page Tabs Checking");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on user dropdown menu");

		DashboardPage.Transaction(driver).click();

		log.info("Clicked on transaction option");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("Transactionpageheader"))));

		log.info("Transaction page is Visible successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("TransactionDepositTab"))));

		DashboardPage.TransactionDepositTab(driver).click();

		log.info("Clicked on DEPOSITS tab");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("TransactionDepositTab"))));

		log.info("Transactions Deposits Section Visible Successfully");

		DashboardPage.TransactionWithdrawTab(driver).click();

		log.info("Clicked on WITHDRAWLS  tab");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("withdrawls"))));

		log.info("Transactions WITHDRAWLS Section Visible Successfully");

		DashboardPage.TransactionRewardsTab(driver).click();

		log.info("Transactions REWARDS section Visible Successfully");

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("TRnoRewards"))));

		DashboardPage.TransactionBetsTab(driver).click();

		log.info("Clicked on BETS tab");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("Transactionpageheader"))));

		log.info("Transactions BETS section is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 27)
	public void Statistics() throws Exception {

		//VideoRecorder_utlity.startRecord("Statistics");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on User Dropdown Menu");

		DashboardPage.Statistics(driver).click();

		log.info("Clicked on Statistics");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("StatisticsOverAll"))));

		log.info("Statistics Overall Tab is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 28)
	public void StatisticsPageChecking() throws Exception {

		//VideoRecorder_utlity.startRecord("Statistics Page Checking");

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

		log.info("Login button clicked Successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid Username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid Password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login Successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on User Dropdown Menu");

		DashboardPage.Statistics(driver).click();

		log.info("Clicked on statistics");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("StatisticsBreakDownTab"))));

		log.info("Statistics breakdown section is Visible successfully");

		DashboardPage.StatisticsBreakDownTab(driver).click();

		log.info("Clicked on Breakdown Section");

		DashboardPage.Statisticsoveralltab(driver).click();

		log.info("Clicked on Overall tab");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("StatisticsOverAllWinsSection"))));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.FlushProperty("StatisticsOverAllLossesSection"))));

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("StatisticsOverAllBetsSection"))));

		log.info("Overall wins/losses/Bets statistics Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 29)
	public void Settings() throws Exception {

		//VideoRecorder_utlity.startRecord("Settings");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on user dropdown menu");

		DashboardPage.Settings(driver).click();

		log.info("Clicked on settings");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("Settingschangepasswordtext"))));

		log.info("Settings page is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 30)
	public void ChangePassword() throws Exception {

		//VideoRecorder_utlity.startRecord("Change Password");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on user dropdown menu");

		DashboardPage.Settings(driver).click();

		log.info("Clicked on settings");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("Settingschangepasswordtext"))));

		log.info("Settings page is Visible Successfully");

		DashboardPage.changepasswordtext(driver).click();

		log.info("Clicked on change password button");

		DashboardPage.Oldpassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered old password");

		DashboardPage.Newpassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered new password");

		DashboardPage.ConfirmNewpassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered confirm password");

		DashboardPage.Savechanges(driver).click();

		log.info("Clicked on Save changes");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("Successfulmessage"))));

		WebElement Successmessage = driver.findElement(By.xpath(f.SettingsProperty("Successfulmessage")));

		String Message = Successmessage.getAttribute("innerText");

		System.out.println(Message);

		String str = Message;

		str = str.replaceAll("\\s", "");

		String ActualTitle = str;

		String ExpectedTitle = "SuccessYourpasswordwasupdatedsuccessfully!";

		Assert.assertEquals(ExpectedTitle, ActualTitle);

		log.info("Password updated successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 31)
	public void PasswordCancel() throws Exception {

		//VideoRecorder_utlity.startRecord("Password Cancel");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on user dropdown menu");

		DashboardPage.Settings(driver).click();

		log.info("Clicked on settings");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("Settingschangepasswordtext"))));

		log.info("Settings page is Visible Successfully");

		DashboardPage.changepasswordtext(driver).click();

		log.info("Clicked on change password button");

		DashboardPage.Oldpassword(driver).sendKeys("Satvik@123");

		log.info("Entered old password");

		DashboardPage.Newpassword(driver).sendKeys("Satvik@123");

		log.info("Entered new password");

		DashboardPage.ConfirmNewpassword(driver).sendKeys("Satvik@123");

		log.info("Entered confirm password");

		DashboardPage.Cancel(driver).click();

		log.info("Clicked on cancel button");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("Settingschangepasswordtext"))));

		log.info("Back to Settings Page is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 32)
	public void OldPasswordInvalid() throws Exception {

		//VideoRecorder_utlity.startRecord("Old Password Invalid");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on user dropdown menu");

		DashboardPage.Settings(driver).click();

		log.info("Clicked on settings");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("Settingschangepasswordtext"))));

		log.info("Settings page is opened");

		DashboardPage.changepasswordtext(driver).click();

		log.info("Clicked on change password button");

		DashboardPage.Oldpassword(driver).sendKeys("Satvik@1");

		log.info("Entered Incorrect old password");

		DashboardPage.Newpassword(driver).sendKeys("Satvik@123");

		log.info("Entered new password");

		DashboardPage.ConfirmNewpassword(driver).sendKeys("Satvik@123");

		log.info("Entered confirm password");

		DashboardPage.Savechanges(driver).click();

		log.info("Clicked on Save changes");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("Successfulmessage"))));

		WebElement Successmessage = driver.findElement(By.xpath(f.SettingsProperty("Successfulmessage")));

		String Message = Successmessage.getAttribute("innerText");

		System.out.println(Message);

		String str = Message;

		str = str.replaceAll("\\s", "");

		String ActualTitle = str;

		String ExpectedTitle = "ErrorOldpasswordisincorrect.";

		Assert.assertEquals(ExpectedTitle, ActualTitle);

		log.info("'ErrorOldpasswordisincorrect.' error is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 33)
	public void PasswordNotMatch() throws Exception {

		//VideoRecorder_utlity.startRecord("Password Not Match");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on user dropdown menu");

		DashboardPage.Settings(driver).click();

		log.info("Clicked on settings");

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("Settingschangepasswordtext"))));

		log.info("Settings page is Visible Successfully");

		DashboardPage.changepasswordtext(driver).click();

		log.info("Clicked on change password button");

		DashboardPage.Oldpassword(driver).sendKeys("Satvik@123");

		log.info("Entered old password");

		DashboardPage.Newpassword(driver).sendKeys("Satvik@12");

		log.info("Entered new password");

		DashboardPage.ConfirmNewpassword(driver).sendKeys("User@12");

		log.info("Entered confirm password");

		DashboardPage.Savechanges(driver).click();

		log.info("Clicked on Save changes");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("PasswordDontMatchError"))));

		WebElement Successmessage = driver.findElement(By.xpath(f.SettingsProperty("PasswordDontMatchError")));

		String Message = Successmessage.getAttribute("innerText");

		System.out.println(Message);

		String str = Message;

		str = str.replaceAll("\\s", "");

		String ActualTitle = str;

		String ExpectedTitle = "Passwordsdontmatch!";

		Assert.assertEquals(ExpectedTitle, ActualTitle);

		log.info("'Passwordsdontmatch!' error is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 34)
	public void WalletBalaceList() throws Exception {

		//VideoRecorder_utlity.startRecord("Wallet Balace List");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login Successful with valid username & password");

		DashboardPage.Walletbalance(driver).click();

		log.info("Clicked on Wallet Balance Dropdown");

		DashboardPage.ETH(driver).click();

		log.info("Clicked on ETH wallet");

		DashboardPage.Walletbalance(driver).click();

		log.info("Clicked on wallet balance dropdown");

		DashboardPage.LTC(driver).click();

		log.info("Clicked on LTC wallet");

		DashboardPage.Walletbalance(driver).click();

		log.info("Clicked on wallet balance dropdown");

		DashboardPage.DOGE(driver).click();

		log.info("Clicked on DOGE wallet");

		DashboardPage.Walletbalance(driver).click();

		log.info("Clicked on wallet balance dropdown");

		DashboardPage.MATIC(driver).click();

		log.info("Clicked on MATIC wallet");

		DashboardPage.Walletbalance(driver).click();

		log.info("Clicked on wallet balance dropdown");

		DashboardPage.BNB(driver).click();

		log.info("Clicked on BNB wallet");

		//VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled =  true, priority = 35)
	public void ChangingUsername() throws Exception {

		//VideoRecorder_utlity.startRecord("Changing Username");

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

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("User login successful with valid username & password");

		DashboardPage.Userdropdown(driver).click();

		log.info("Clicked on user dropdown menu");

		DashboardPage.Settings(driver).click();

		log.info("Clicked on settings");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("UserNameEditicon"))));

		DashboardPage.UserNameEditicon(driver).click();

		log.info("Clicked on user name edition");

		WebElement inputbox = driver.findElement(By.xpath("//*[@type='text']"));

		inputbox.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

		DashboardPage.UserNameInputBox(driver).clear();

		log.info("User name input box cleared");

		Random rand = new Random();

		int rand_int1 = rand.nextInt(1000);

		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Msdhoni" + rand_int1);

		log.info("Entered Username in Username Textbox");

		DashboardPage.UserNameUpdateButton(driver).click();

		log.info("Clicked on Username Update Button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.SettingsProperty("Successfulmessage"))));

		WebElement Successmessage = driver.findElement(By.xpath(f.SettingsProperty("Successfulmessage")));

		String Message = Successmessage.getAttribute("innerText");

		System.out.println(Message);

		String str = Message;

		str = str.replaceAll("\\s", "");

		String ActualTitle = str;

		String ExpectedTitle = "SuccessYourusernamewasupdatedsuccessfully!";

		Assert.assertEquals(ExpectedTitle, ActualTitle);

		log.info("'Yourusernamewasupdatedsuccessfully!' Message is Visible Successfully");

		//VideoRecorder_utlity.stopRecord();
	}

	@AfterMethod
	public void EndTest() 
	{
		driver.close();

		log.info("Browser closed");
	}

}
