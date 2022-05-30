package com.Test;

import java.beans.Visibility;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.Homepage;
import pageObjects.WelcomePopup;
import resources.base;

public class DashBoardpageTestCases extends base {

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
	public void ValidateFlushOriginalsSection() throws Exception {

		// VideoRecorder_utlity.startRecord("Login As Valid User");

		wait = new WebDriverWait(driver, 50);

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

			Homepage.Loginbutton(driver).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Relogin"))));

			Homepage.ReLoginbutton(driver).click();
		}

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WebElement PlayNowBtn = WelcomePopup.PlayNowbutton(driver);

		Actions action = new Actions(driver);

		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {

			action.moveToElement(PlayNowBtn).click().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		} catch (Exception e) {

			j.executeScript("arguments[0].click();", PlayNowBtn);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		}

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		DashboardPage.OriginalsHeader(driver).click();

		log.info("Clicked on ORIGINALS section");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("FlushOriginalText"))));

		log.info("Flush Originals Title is Visible Successfully");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 2)
	public void ValidateLiveCasinoSection() throws Exception {

		// VideoRecorder_utlity.startRecord("Login As Valid User");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

		Homepage.Loginbutton(driver).click();

		log.info("Login button clicked Successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WebElement PlayNowBtn = WelcomePopup.PlayNowbutton(driver);

		Actions action = new Actions(driver);

		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {

			action.moveToElement(PlayNowBtn).click().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		} catch (Exception e) {

			j.executeScript("arguments[0].click();", PlayNowBtn);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		}

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		DashboardPage.LiveCasinoHeader(driver).click();

		log.info("Clicked on LIVE CASINO section");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("LiveCasinoText"))));

		log.info("Live Casino Title is Visible Successfully");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 3)
	public void ValidateSlotsSection() throws Exception {

		// VideoRecorder_utlity.startRecord("Login As Valid User");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

		Homepage.Loginbutton(driver).click();

		log.info("Login button clicked Successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WebElement PlayNowBtn = WelcomePopup.PlayNowbutton(driver);

		Actions action = new Actions(driver);

		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {

			action.moveToElement(PlayNowBtn).click().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		} catch (Exception e) {

			j.executeScript("arguments[0].click();", PlayNowBtn);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		}

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		DashboardPage.SlotsHeader(driver).click();

		log.info("Clicked on SLOTS section");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FlushProperty("FeaturedSlotsText"))));

		log.info("Featured Slots Title Visible Successfully");

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 4)
	public void ValidateAllGameLinks() throws Exception {

		// VideoRecorder_utlity.startRecord("Login As Valid User");

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Loginbutton"))));

		Homepage.Loginbutton(driver).click();

		log.info("Login button clicked Successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WebElement PlayNowBtn = WelcomePopup.PlayNowbutton(driver);

		Actions action = new Actions(driver);

		JavascriptExecutor j = (JavascriptExecutor) driver;

		try {

			action.moveToElement(PlayNowBtn).click().perform();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		} catch (Exception e) {

			j.executeScript("arguments[0].click();", PlayNowBtn);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));
		}

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

		log.info("Redirected to dice game page");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("DiceImage"))));

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/crash");

		log.info("Redirected to crash game page");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.CrashProperty("CrashCanvas"))));

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/mines");

		log.info("Redirected to mines game page");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("MinesGrid"))));

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/wheel");

		log.info("Redirected to wheel game page");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("WheelCanvas"))));

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/plinko");

		log.info("Redirected to plinko game page");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.PlinkoProperty("PlinkoCanvas"))));

		// VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = true, priority = 5)
	public void ChatboxIcon() throws IOException {
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("ChatboxIcon"))));

		DashboardPage.ChatboxIcon(driver).click();

		log.info("Clicked on Chatbox icon");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("ChatboxLanguageIcon"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("ChatboxEnterMsg"))));

		log.info("Chatbox window is visible successfully");

		DashboardPage.CloseChatboxIcon(driver).click();

		log.info("Chatbox window is closed successfully");
	}

	@Test(enabled = true, priority = 6)
	public void changeLanguage() throws IOException {

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("ChatboxIcon"))));

		DashboardPage.ChatboxIcon(driver).click();

		log.info("Clicked on Chatbox icon");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("ChatboxLanguageIcon"))));

		DashboardPage.ChatboxLanguageIcon(driver).click();

		log.info("Clicked on Language button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("language2"))));

		DashboardPage.language2(driver).click();

		log.info("Clicked on Second language");

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("language2Text"))));

//		log.info("Language changed to second language successfully");

		DashboardPage.ChatboxLanguageIcon(driver).click();

		log.info("Clicked on Language button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("language3"))));

		DashboardPage.language3(driver).click();

		log.info("Clicked on third language");

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("language3Text"))));

//		log.info("Language changed to third language successfully");

		DashboardPage.ChatboxLanguageIcon(driver).click();

		log.info("Clicked on Language button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("language4"))));

		DashboardPage.language4(driver).click();

		log.info("Clicked on fourth language");

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("language4Text"))));

//		log.info("Language changed to fourth language successfully");

		DashboardPage.ChatboxLanguageIcon(driver).click();

		log.info("Clicked on Language button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("language1"))));

		DashboardPage.language1(driver).click();

		log.info("Clicked on first language");

//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("language1Text"))));

		log.info("Language change is visible successfully");

	}

	@AfterMethod
	public void EndTest() {
		driver.close();

		log.info("Browser closed");
	}
}
