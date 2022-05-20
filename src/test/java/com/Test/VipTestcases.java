package com.Test;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AccountDropdown;
import pageObjects.DashboardPage;
import pageObjects.DiceGamePage;
import pageObjects.Homepage;
import pageObjects.VIPPage;
import pageObjects.WelcomePopup;
import resources.VideoRecorder_utlity;
import resources.base;

public class VipTestcases extends base {
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

	@Test(enabled = false, priority = 1)
	public void CheckingHeaderLoyalityText() throws Exception {

		VideoRecorder_utlity.startRecord("Checking Header Loyality Text");

		wait = new WebDriverWait(driver, 30);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

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

		log.info("Dropdown button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("VIP"))));

		VIPPage.DropdownVipLink(driver).click();

		log.info("VIP clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Loyality"))));

		log.info("Loyality a Header Text Visible Successfully");

		VideoRecorder_utlity.stopRecord();

	}

	@Test(enabled = false, priority = 2)
	public void CheckingVipPageTabs() throws Exception {

		VideoRecorder_utlity.startRecord("Checking Vip Page Tabs");

		wait = new WebDriverWait(driver, 80);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

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

		log.info("Dropdown button clicked successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("VIP"))));

		VIPPage.DropdownVipLink(driver).click();

		log.info("VIP clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Loyality"))));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement Rewards = VIPPage.Rewards(driver);

		js.executeScript("arguments[0].scrollIntoView();", Rewards);

		log.info("Scrolled to Rewards Text");

		VIPPage.ClaimedRewardstab(driver).click();

		log.info("Clicked on Claim Rewards Tab");

		VIPPage.Rewards(driver).click();

		log.info("Clicked on Rewards Tab");

		VIPPage.ClaimedRewardstab(driver).click();

		log.info("clicked on Claim Rewards tab");

		VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = false, priority = 3)
	public void ClaimRewards() throws Exception {

		VideoRecorder_utlity.startRecord("Claim Rewards");

		wait = new WebDriverWait(driver, 30);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

		log.info("Login button clicked successfully");

		WelcomePopup.Welcomeemail(driver).sendKeys(f.LoginProperty("UserEmail"));

		log.info("Entered valid username");

		WelcomePopup.Welcomepassword(driver).sendKeys(f.LoginProperty("UserPassword"));

		log.info("Entered valid password");

		WelcomePopup.Welcomeplaynow(driver).click();

		log.info("Clicked on Play Now button");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.LoginProperty("Dashboardwallet"))));

		log.info("Wallet Button Visible Successfully on Dashboard Page");

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

		WebElement Amount = DiceGamePage.BetAmountinputField(driver);

		Amount.clear();

		Amount.sendKeys(f.VIPProperty("Amount"));

		DiceGamePage.BetButton(driver).click();

		DashboardPage.Userdropdown(driver).click();

		AccountDropdown.VIP(driver).click();

		WebElement TotalPoints = VIPPage.TotalPointsSection(driver);

		String Points = TotalPoints.getAttribute("innerText");

		System.out.println("Total points " + Points);

		String str = Points;

		String VisiblePoints = StringUtils.remove(str, "TOTAL POINTS");

		String spacesremove = VisiblePoints.replaceAll("\\s", "");

		System.out.println(VisiblePoints);

		int i = Integer.parseInt(spacesremove);

		WebElement s = VIPPage.RewardPoints(driver);

		String Pointss = s.getAttribute("innerText");

		// System.out.println("-------"+Pointss);

		String spacesremov = Pointss.replaceAll("\\s", "");

		String wantedPart = spacesremov.split("/")[1];

		// System.out.println("final value = "+ wantedPart);

		int A = Integer.parseInt(wantedPart);

		if (i <= A) {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement Claimrewards = VIPPage.ClaimedRewardstab(driver);

			js.executeScript("arguments[0].scrollIntoView();", Claimrewards);

			Claimrewards.click();

			WebElement ChooseYourRewardCancelButton = VIPPage.ClaimRewardsChooseYourRewardCancelbutton(driver);

			ChooseYourRewardCancelButton.click();

		} else {

			System.out.println("Less than 500");

		}
		VideoRecorder_utlity.stopRecord();
	}

	@Test(enabled = false, priority = 4)
	public void ChooseYourRewardsRadioButtonOne() throws Exception {

		wait = new WebDriverWait(driver, 50);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

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

		AccountDropdown.VIP(driver).click();

		log.info("VIP clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Loyality"))));

		WebElement TotalPoints = VIPPage.TotalPointsSection(driver);

		String Points = TotalPoints.getAttribute("innerText");

		System.out.println("Total points " + Points);

		String str = Points;

		String VisiblePoints = StringUtils.remove(str, "TOTAL POINTS");

		String spacesremove = VisiblePoints.replaceAll("\\s", "");

		System.out.println(VisiblePoints);

		int i = Integer.parseInt(spacesremove);

		WebElement s = VIPPage.RewardPoints(driver);

		String Pointss = s.getAttribute("innerText");

		// System.out.println("-------"+Pointss);

		String spacesremov = Pointss.replaceAll("\\s", "");

		String wantedPart = spacesremov.split("/")[1];

		// System.out.println("final value = "+ wantedPart);

		int A = Integer.parseInt(wantedPart);

		while (i <= A) {

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

			Thread.sleep(5000);

			WebElement Amount = DiceGamePage.BetAmountinputField(driver);

			Amount.sendKeys(Keys.CONTROL, "a");

			Amount.sendKeys(Keys.DELETE);

			Amount.sendKeys(f.VIPProperty("Amount"));

			DiceGamePage.BetButton(driver).click();

			Thread.sleep(5000);

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/vip");

			Thread.sleep(5000);

			WebElement TotalPoints1 = VIPPage.TotalPointsSection(driver);

			String Points1 = TotalPoints1.getAttribute("innerText");

			// System.out.println("Total points " + Points1);

			String str1 = Points1;

			String VisiblePoints1 = StringUtils.remove(str1, "TOTAL POINTS");

			String spacesremove1 = VisiblePoints1.replaceAll("\\s", "");

			// System.out.println(VisiblePoints1);

			int i1 = Integer.parseInt(spacesremove1);

			// System.out.println("=======" + i1);

			i = i1;

		}
		VIPPage.ClaimRewardsFirstButton(driver).click();

		log.info("Claim Rewards First Button Clicked Successfully");

		VIPPage.ClaimRewardsChooseYourRewardCancelbutton(driver).click();

	}

	@Test(enabled = false, priority = 5)
	public void ChooseYourRewardsRadioButtonTwo() throws Exception {

		VideoRecorder_utlity.startRecord("Choose Your Rewards Second Radio Button");

		wait = new WebDriverWait(driver, 80);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

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

		AccountDropdown.VIP(driver).click();

		log.info("VIP clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Loyality"))));

		WebElement TotalPoints = VIPPage.TotalPointsSection(driver);

		String Points = TotalPoints.getAttribute("innerText");

		System.out.println("Total points " + Points);

		String str = Points;

		String VisiblePoints = StringUtils.remove(str, "TOTAL POINTS");

		String spacesremove = VisiblePoints.replaceAll("\\s", "");

		System.out.println(VisiblePoints);

		int i = Integer.parseInt(spacesremove);

		WebElement s = VIPPage.RewardPoints(driver);

		String Pointss = s.getAttribute("innerText");

		// System.out.println("-------"+Pointss);

		String spacesremov = Pointss.replaceAll("\\s", "");

		String wantedPart = spacesremov.split("/")[1];

		// System.out.println("final value = "+ wantedPart);

		int A = Integer.parseInt(wantedPart);

		while (i <= A) {

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

			Thread.sleep(5000);

			WebElement Amount = DiceGamePage.BetAmountinputField(driver);

			Amount.sendKeys(Keys.CONTROL, "a");

			Amount.sendKeys(Keys.DELETE);

			Amount.sendKeys(f.VIPProperty("Amount"));

			DiceGamePage.BetButton(driver).click();

			Thread.sleep(5000);

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/vip");

			Thread.sleep(5000);

			WebElement TotalPoints1 = VIPPage.TotalPointsSection(driver);

			String Points1 = TotalPoints1.getAttribute("innerText");

			// System.out.println("Total points " + Points1);

			String str1 = Points1;

			String VisiblePoints1 = StringUtils.remove(str1, "TOTAL POINTS");

			String spacesremove1 = VisiblePoints1.replaceAll("\\s", "");

			// System.out.println(VisiblePoints1);

			int i1 = Integer.parseInt(spacesremove1);

			// System.out.println("=======" + i1);

			i = i1;

		}
		VIPPage.ClaimRewardsFirstButton(driver).click();

		log.info("Claim Rewards First Button Clicked Successfully");

		VIPPage.ClaimRewardsChooseYourRewardSecondRadio(driver).click();

		VIPPage.ClaimRewardsChooseYourRewardCancelbutton(driver).click();

		VideoRecorder_utlity.stopRecord();

	}

	@Test(enabled = false, priority = 5)
	public void ChooseYourRewardsRadioButtonThree() throws Exception {

		VideoRecorder_utlity.startRecord("Choose Your Rewards Third Radio Button");

		wait = new WebDriverWait(driver, 80);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

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

		AccountDropdown.VIP(driver).click();

		log.info("VIP clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Loyality"))));

		WebElement TotalPoints = VIPPage.TotalPointsSection(driver);

		String Points = TotalPoints.getAttribute("innerText");

		System.out.println("Total points " + Points);

		String str = Points;

		String VisiblePoints = StringUtils.remove(str, "TOTAL POINTS");

		String spacesremove = VisiblePoints.replaceAll("\\s", "");

		System.out.println(VisiblePoints);

		int i = Integer.parseInt(spacesremove);

		WebElement s = VIPPage.RewardPoints(driver);

		String Pointss = s.getAttribute("innerText");

		// System.out.println("-------"+Pointss);

		String spacesremov = Pointss.replaceAll("\\s", "");

		String wantedPart = spacesremov.split("/")[1];

		// System.out.println("final value = "+ wantedPart);

		int A = Integer.parseInt(wantedPart);

		while (i <= A) {

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

			Thread.sleep(5000);

			WebElement Amount = DiceGamePage.BetAmountinputField(driver);

			Amount.sendKeys(Keys.CONTROL, "a");

			Amount.sendKeys(Keys.DELETE);

			Amount.sendKeys(f.VIPProperty("Amount"));

			DiceGamePage.BetButton(driver).click();

			Thread.sleep(5000);

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/vip");

			Thread.sleep(5000);

			WebElement TotalPoints1 = VIPPage.TotalPointsSection(driver);

			String Points1 = TotalPoints1.getAttribute("innerText");

			// System.out.println("Total points " + Points1);

			String str1 = Points1;

			String VisiblePoints1 = StringUtils.remove(str1, "TOTAL POINTS");

			String spacesremove1 = VisiblePoints1.replaceAll("\\s", "");

			// System.out.println(VisiblePoints1);

			int i1 = Integer.parseInt(spacesremove1);

			// System.out.println("=======" + i1);

			i = i1;

		}
		VIPPage.ClaimRewardsFirstButton(driver).click();

		log.info("Claim Rewards First Button Clicked Successfully");

		VIPPage.ClaimRewardsChooseYourRewardThirdRadio(driver).click();

		VIPPage.ClaimRewardsChooseYourRewardCancelbutton(driver).click();

		VideoRecorder_utlity.stopRecord();

	}

	@Test(enabled = false, priority = 5)
	public void ChooseYourRewardsButtonFourth() throws Exception {

		VideoRecorder_utlity.startRecord("Choose Your Rewards Second Radio Button");

		wait = new WebDriverWait(driver, 80);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

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

		AccountDropdown.VIP(driver).click();

		log.info("VIP clicked Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Loyality"))));

		WebElement TotalPoints = VIPPage.TotalPointsSection(driver);

		String Points = TotalPoints.getAttribute("innerText");

		System.out.println("Total points " + Points);

		String str = Points;

		String VisiblePoints = StringUtils.remove(str, "TOTAL POINTS");

		String spacesremove = VisiblePoints.replaceAll("\\s", "");

		System.out.println(VisiblePoints);

		int i = Integer.parseInt(spacesremove);
		WebElement s = VIPPage.RewardPoints(driver);

		String Pointss = s.getAttribute("innerText");

		// System.out.println("-------"+Pointss);

		String spacesremov = Pointss.replaceAll("\\s", "");

		String wantedPart = spacesremov.split("/")[1];

		// System.out.println("final value = "+ wantedPart);

		int A = Integer.parseInt(wantedPart);

		while (i <= A) {

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

			Thread.sleep(5000);

			WebElement Amount = DiceGamePage.BetAmountinputField(driver);

			Amount.sendKeys(Keys.CONTROL, "a");

			Amount.sendKeys(Keys.DELETE);

			Amount.sendKeys(f.VIPProperty("Amount"));

			DiceGamePage.BetButton(driver).click();

			Thread.sleep(5000);

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/vip");

			Thread.sleep(5000);

			WebElement TotalPoints1 = VIPPage.TotalPointsSection(driver);

			String Points1 = TotalPoints1.getAttribute("innerText");

			// System.out.println("Total points " + Points1);

			String str1 = Points1;

			String VisiblePoints1 = StringUtils.remove(str1, "TOTAL POINTS");

			String spacesremove1 = VisiblePoints1.replaceAll("\\s", "");

			// System.out.println(VisiblePoints1);

			int i1 = Integer.parseInt(spacesremove1);

			// System.out.println("=======" + i1);

			i = i1;

		}
		VIPPage.ClaimRewardsFirstButton(driver).click();

		log.info("Claim Rewards First Button Clicked Successfully");

		VIPPage.ClaimRewardsChooseYourRewardFourthRadio(driver).click();

		VIPPage.ClaimRewardsChooseYourRewardCancelbutton(driver).click();

		VideoRecorder_utlity.stopRecord();

	}

	@Test(enabled = false, priority = 6)
	public void OneFlow() throws Exception {

		VideoRecorder_utlity.startRecord("Rewards Game Flow");

		wait = new WebDriverWait(driver, 80);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

		log.info("Login button clicked successfully");

		log.info("Login button clicked successfully");

		Homepage page = new Homepage(driver);

		page.Login(driver);

		log.info("Login Successful with Valid Username & Password");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='WALLET']")));

		DashboardPage.Userdropdown(driver).click();

		AccountDropdown.VIP(driver).click();

		WebElement TotalPoints = VIPPage.TotalPointsSection(driver);

		String Points = TotalPoints.getAttribute("innerText");

		System.out.println("Total points " + Points);

		String str = Points;

		String VisiblePoints = StringUtils.remove(str, "TOTAL POINTS");

		String spacesremove = VisiblePoints.replaceAll("\\s", "");

		System.out.println(VisiblePoints);

		int i = Integer.parseInt(spacesremove);

		WebElement s = VIPPage.RewardPoints(driver);

		String Pointss = s.getAttribute("innerText");

		// System.out.println("-------"+Pointss);

		String spacesremov = Pointss.replaceAll("\\s", "");

		String wantedPart = spacesremov.split("/")[1];

		// System.out.println("final value = "+ wantedPart);

		int A = Integer.parseInt(wantedPart);

		while (i <= A) {

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

			Thread.sleep(5000);

			WebElement Amount = DiceGamePage.BetAmountinputField(driver);

			Amount.sendKeys(Keys.CONTROL, "a");

			Amount.sendKeys(Keys.DELETE);

			Amount.sendKeys(f.VIPProperty("Amount"));

			DiceGamePage.BetButton(driver).click();

			Thread.sleep(5000);

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/vip");

			Thread.sleep(5000);

			WebElement TotalPoints1 = VIPPage.TotalPointsSection(driver);

			String Points1 = TotalPoints1.getAttribute("innerText");

			System.out.println("Total points " + Points1);

			String str1 = Points1;

			String VisiblePoints1 = StringUtils.remove(str1, "TOTAL POINTS");

			String spacesremove1 = VisiblePoints1.replaceAll("\\s", "");

			System.out.println(VisiblePoints1);

			int i1 = Integer.parseInt(spacesremove1);

			System.out.println("=======" + i1);

			i = i1;

		}

		System.out.println("Final value " + i);

		VIPPage.ClaimRewardsFirstButton(driver).click();

		log.info("Claim Rewards First Button Clicked Successfully");

		WebElement GameName = VIPPage.FirstRadioButtonName(driver);

		String FirstGameName = GameName.getAttribute("innerText");

		log.info("Getting Game Name successfully ");

		System.out.println("GameName=" + FirstGameName);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.VIPProperty("ClaimRewardsChooseYourRewardFirstRadio"))));

		VIPPage.ClaimRewardsChooseYourRewardFirstRadio(driver).click();

		log.info("First Radio Button Clicked Successfully ");

		VIPPage.ClaimRewardsChooseYourRewardClaimSelectedRewards(driver).click();

		log.info("Clicked Confirmation Button Successfully");

		// Close button

		VIPPage.RewardsPopupCloseIcon(driver).click();

		log.info("Close Icon Clicked Successfully ");

		// driver.findElement(By.xpath("//*[@class='VipChooseReward__CrossButton-sc-bwdl93-13
		// jIOIcS']")).click();

		VIPPage.Slotstab(driver).click();

		log.info("Slots Tab Clicked Successfully");

		WebElement search = VIPPage.Slotssearch(driver);

		search.sendKeys(FirstGameName);

		log.info("Searching a Game Successfully");

		VIPPage.DashboardSearchGameGladiator(driver).click();

		log.info("Searching Game Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("SlotsGameRealPlay"))));

		// Thread.sleep(10000);

		VIPPage.SlotsGameRealPlay(driver).click();

		log.info("Clicked Real Game Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Frame"))));

		Thread.sleep(10000);

		driver.switchTo().frame(VIPPage.GameFrame(driver));

		log.info("Switching Frame Successfully");

		// driver.switchTo().frame(driver.findElement(By.xpath("//*[@class='egamings_game_frame']")));

		// driver.switchTo().frame(1);

		Thread.sleep(25000);

		// JavascriptExecutor executor = (JavascriptExecutor) driver;

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"[bgcolor] .udom:nth-of-type(5) .udom:nth-of-type(1) .udom:nth-of-type(1) .udom:nth-of-type(1) .udom:nth-of-type(1) .udom:nth-of-type(1) .udom:nth-of-type(2) .udom")));

		Thread.sleep(5000);

		Actions action = new Actions(driver);

		action.moveToElement(element).click().perform();

		log.info("Clicked on Ok Button Successfully");

		Thread.sleep(5000);

		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"body > span:nth-child(1) > span > span:nth-child(1) > span > span:nth-child(1) > span:nth-child(4) > span:nth-child(1) > span > span > span:nth-child(1) > img")));

		Thread.sleep(5000);

		action.moveToElement(element1).click().perform();

		log.info("Claim Button Clicked Successfully");

		VideoRecorder_utlity.stopRecord();

	}

	@Test(enabled = false, priority = 4)
	public void FourthRadioButtonGameFlow() throws Exception {

		VideoRecorder_utlity.startRecord("Selecting Fourth Radio Button");

		wait = new WebDriverWait(driver, 80);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

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

		AccountDropdown.VIP(driver).click();

		WebElement TotalPoints = VIPPage.TotalPointsSection(driver);

		String Points = TotalPoints.getAttribute("innerText");

		// System.out.println("Total points " + Points);

		String str = Points;

		String VisiblePoints = StringUtils.remove(str, "TOTAL POINTS");

		String spacesremove = VisiblePoints.replaceAll("\\s", "");

		// System.out.println(VisiblePoints);

		int i = Integer.parseInt(spacesremove);

		WebElement s = VIPPage.RewardPoints(driver);

		String Pointss = s.getAttribute("innerText");

		// System.out.println("-------"+Pointss);

		String spacesremov = Pointss.replaceAll("\\s", "");

		String wantedPart = spacesremov.split("/")[1];

		// System.out.println("final value = "+ wantedPart);

		int A = Integer.parseInt(wantedPart);

		while (i <= A) {

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

			Thread.sleep(5000);

			WebElement Amount = DiceGamePage.BetAmountinputField(driver);

			Amount.sendKeys(Keys.CONTROL, "a");

			Amount.sendKeys(Keys.DELETE);

			Amount.sendKeys(f.VIPProperty("Amount"));

			DiceGamePage.BetButton(driver).click();

			Thread.sleep(5000);

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/vip");

			Thread.sleep(5000);

			WebElement TotalPoints1 = VIPPage.TotalPointsSection(driver);

			String Points1 = TotalPoints1.getAttribute("innerText");

			// System.out.println("Total points " + Points1);

			String str1 = Points1;

			String VisiblePoints1 = StringUtils.remove(str1, "TOTAL POINTS");

			String spacesremove1 = VisiblePoints1.replaceAll("\\s", "");

			// System.out.println(VisiblePoints1);

			int i1 = Integer.parseInt(spacesremove1);

			// System.out.println("=======" + i1);

			i = i1;

		}

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		// claim enable button

		VIPPage.ClaimRewardsFirstButton(driver).click();

		log.info("Claim Rewards First Button Clicked Successfully");

		WebElement GameName = VIPPage.FouthRadioButtonName(driver);

		String FirstGameName = GameName.getAttribute("innerText");

		log.info("Getting Game Name successfully ");

		System.out.println("GameName=" + FirstGameName);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.VIPProperty("ClaimRewardsChooseYourRewardFirstRadio"))));

		VIPPage.ClaimRewardsChooseYourRewardFourthRadio(driver).click();

		log.info("Fourth Radio Button Clicked Successfully ");

		VIPPage.ClaimRewardsChooseYourRewardClaimSelectedRewards(driver).click();

		log.info("Clicked Confirmation Button Successfully");

		VIPPage.RewardsPopupCloseIcon(driver).click();

		log.info("Close Icon Clicked Successfully ");

		VIPPage.Slotstab(driver).click();

		log.info("Slots Tab Clicked Successfully");

		WebElement search = VIPPage.Slotssearch(driver);

		search.sendKeys(FirstGameName);

		String name = FirstGameName;

		// System.out.println("++++++++++++" + name);

		log.info("Searching a Game Successfully");

		for (int m = 1; m <= 10; m++) {

			WebElement ele = driver.findElement(
					By.xpath("(//*[@class='GameCard__GameInfoLine1-sc-1djvmxe-7 cCcRwd'])" + "[ " + m + "]"));

			String FirstGameName1 = ele.getAttribute("innerText");

			System.out.println(FirstGameName1);

			if (name.equals(FirstGameName1)) {

				ele.click();

				break;

			}
		}

		log.info("Searching Game Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("SlotsGameRealPlay"))));

		VIPPage.SlotsGameRealPlay(driver).click();

		log.info("Clicked Real Game Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Frame"))));

		// Thread.sleep(10000);

		driver.switchTo().frame(VIPPage.GameFrame(driver));

		log.info("Switching Frame Successfully");

		Actions action = new Actions(driver);

		try {

			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(f.VIPProperty("OK"))));

			action.moveToElement(element).click().perform();

			log.info("Clicked on Ok Button Successfully");

			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(f.VIPProperty("Spin"))));

			action.moveToElement(element1).click().perform();

			log.info("Spin Button Clicked successfully");

			Thread.sleep(5000);
		}

		catch (Exception E) {
			System.out.println("Trying catch block");

			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(f.VIPProperty("Spin"))));

			action.moveToElement(element1).click().perform();

			log.info("Spin Button Clicked Successfully");
		}

		Thread.sleep(19000);

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/");

		WebElement Walletbalance1 = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney1 = Walletbalance1.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount1 = new Double(Totalmoney1);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount1 = BigDecimal.valueOf(WalletAmount1);

		System.out.println("AFTER Spin Total Amount in you wallet =  " + DashboardWalletAmount1);

		VideoRecorder_utlity.stopRecord();

	}

	@Test(enabled = false, priority = 2)
	public void SecondRadioButtonGameFlow() throws Exception {

		VideoRecorder_utlity.startRecord("Selecting Second Radio Button");

		wait = new WebDriverWait(driver, 80);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

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

		AccountDropdown.VIP(driver).click();

		WebElement TotalPoints = VIPPage.TotalPointsSection(driver);

		String Points = TotalPoints.getAttribute("innerText");

		// System.out.println("Total points " + Points);

		String str = Points;

		String VisiblePoints = StringUtils.remove(str, "TOTAL POINTS");

		String spacesremove = VisiblePoints.replaceAll("\\s", "");

		// System.out.println(VisiblePoints);

		int i = Integer.parseInt(spacesremove);

		while (i <= 1000) {

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

			Thread.sleep(5000);

			WebElement Amount = DiceGamePage.BetAmountinputField(driver);

			Amount.sendKeys(Keys.CONTROL, "a");

			Amount.sendKeys(Keys.DELETE);

			Amount.sendKeys(f.VIPProperty("Amount"));

			DiceGamePage.BetButton(driver).click();

			Thread.sleep(5000);

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/vip");

			Thread.sleep(5000);

			WebElement TotalPoints1 = VIPPage.TotalPointsSection(driver);

			String Points1 = TotalPoints1.getAttribute("innerText");

			// System.out.println("Total points " + Points1);

			String str1 = Points1;

			String VisiblePoints1 = StringUtils.remove(str1, "TOTAL POINTS");

			String spacesremove1 = VisiblePoints1.replaceAll("\\s", "");

			// System.out.println(VisiblePoints1);

			int i1 = Integer.parseInt(spacesremove1);

			// System.out.println("=======" + i1);

			i = i1;

		}

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		// claim enable button

		VIPPage.ClaimRewardsFirstButton(driver).click();

		log.info("Claim Rewards First Button Clicked Successfully");

		WebElement GameName = VIPPage.SecondRadioButtonName(driver);

		String FirstGameName = GameName.getAttribute("innerText");

		log.info("Getting Game Name successfully ");

		System.out.println("GameName=" + FirstGameName);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.VIPProperty("ClaimRewardsChooseYourRewardFirstRadio"))));

		VIPPage.ClaimRewardsChooseYourRewardSecondRadio(driver).click();

		log.info("Second Radio Button Clicked Successfully ");

		VIPPage.ClaimRewardsChooseYourRewardClaimSelectedRewards(driver).click();

		log.info("Clicked Confirmation Button Successfully");

		VIPPage.RewardsPopupCloseIcon(driver).click();

		log.info("Close Icon Clicked Successfully ");

		VIPPage.Slotstab(driver).click();

		log.info("Slots Tab Clicked Successfully");

		WebElement search = VIPPage.Slotssearch(driver);

		search.sendKeys(FirstGameName);

		String name = FirstGameName;

		// System.out.println("++++++++++++" + name);

		log.info("Searching a Game Successfully");

		for (int m = 1; m <= 10; m++) {

			WebElement ele = driver.findElement(
					By.xpath("(//*[@class='GameCard__GameInfoLine1-sc-1djvmxe-7 cCcRwd'])" + "[ " + m + "]"));

			String FirstGameName1 = ele.getAttribute("innerText");

			System.out.println(FirstGameName1);

			if (name.equals(FirstGameName1)) {

				ele.click();

				break;

			}
		}

		log.info("Searching Game Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("SlotsGameRealPlay"))));

		VIPPage.SlotsGameRealPlay(driver).click();

		log.info("Clicked Real Game Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Frame"))));

		// Thread.sleep(10000);

		driver.switchTo().frame(VIPPage.GameFrame(driver));

		log.info("Switching Frame Successfully");

		Actions action = new Actions(driver);

		try {

			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(f.VIPProperty("OK"))));

			action.moveToElement(element).click().perform();

			log.info("Clicked on Ok Button Successfully");

			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(f.VIPProperty("Spin"))));

			action.moveToElement(element1).click().perform();

			log.info("Spin Button Clicked successfully");

			Thread.sleep(5000);
		}

		catch (Exception E) {
			System.out.println("Trying catch block");

			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(f.VIPProperty("Spin"))));

			action.moveToElement(element1).click().perform();

			log.info("Spin Button Clicked Successfully");
		}

		Thread.sleep(19000);

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/");

		WebElement Walletbalance1 = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney1 = Walletbalance1.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount1 = new Double(Totalmoney1);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount1 = BigDecimal.valueOf(WalletAmount1);

		System.out.println("AFTER Spin Total Amount in you wallet =  " + DashboardWalletAmount1);

		VideoRecorder_utlity.stopRecord();

	}

	@Test(enabled = false, priority = 3)
	public void ThirdRadioButtonGameFlow() throws Exception {

		VideoRecorder_utlity.startRecord("Selecting Third Radio Button");

		wait = new WebDriverWait(driver, 80);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

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

		AccountDropdown.VIP(driver).click();

		WebElement TotalPoints = VIPPage.TotalPointsSection(driver);

		String Points = TotalPoints.getAttribute("innerText");

		// System.out.println("Total points " + Points);

		String str = Points;

		String VisiblePoints = StringUtils.remove(str, "TOTAL POINTS");

		String spacesremove = VisiblePoints.replaceAll("\\s", "");

		// System.out.println(VisiblePoints);

		int i = Integer.parseInt(spacesremove);

		WebElement s = VIPPage.RewardPoints(driver);

		String Pointss = s.getAttribute("innerText");

		// System.out.println("-------"+Pointss);

		String spacesremov = Pointss.replaceAll("\\s", "");

		String wantedPart = spacesremov.split("/")[1];

		// System.out.println("final value = "+ wantedPart);

		int A = Integer.parseInt(wantedPart);

		while (i <= A) {
			//
			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

			Thread.sleep(5000);

			WebElement Amount = DiceGamePage.BetAmountinputField(driver);

			Amount.sendKeys(Keys.CONTROL, "a");

			Amount.sendKeys(Keys.DELETE);

			Amount.sendKeys(f.VIPProperty("Amount"));

			DiceGamePage.BetButton(driver).click();

			Thread.sleep(5000);

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/vip");

			// Thread.sleep(5000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("TotalPointsSection"))));

			WebElement TotalPoints1 = VIPPage.TotalPointsSection(driver);

			String Points1 = TotalPoints1.getAttribute("innerText");

			// System.out.println("Total points " + Points1);

			String str1 = Points1;

			String VisiblePoints1 = StringUtils.remove(str1, "TOTAL POINTS");

			String spacesremove1 = VisiblePoints1.replaceAll("\\s", "");

			// System.out.println(VisiblePoints1);

			int i1 = Integer.parseInt(spacesremove1);

			// System.out.println("=======" + i1);

			i = i1;

		}

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		// claim enable button

		VIPPage.ClaimRewardsFirstButton(driver).click();

		log.info("Claim Rewards First Button Clicked Successfully");

		WebElement GameName = VIPPage.ThirdRadioButtonName(driver);

		String FirstGameName = GameName.getAttribute("innerText");

		log.info("Getting Game Name successfully ");

		System.out.println("GameName=" + FirstGameName);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.VIPProperty("ClaimRewardsChooseYourRewardFirstRadio"))));

		VIPPage.ClaimRewardsChooseYourRewardThirdRadio(driver).click();

		log.info("Fourth Radio Button Clicked Successfully ");

		VIPPage.ClaimRewardsChooseYourRewardClaimSelectedRewards(driver).click();

		log.info("Clicked Confirmation Button Successfully");

		VIPPage.RewardsPopupCloseIcon(driver).click();

		log.info("Close Icon Clicked Successfully ");

		VIPPage.Slotstab(driver).click();

		log.info("Slots Tab Clicked Successfully");

		WebElement search = VIPPage.Slotssearch(driver);

		search.sendKeys(FirstGameName);

		String name = FirstGameName;

		// System.out.println("++++++++++++" + name);

		log.info("Searching a Game Successfully");

		for (int m = 1; m <= 10; m++) {

			WebElement ele = driver.findElement(
					By.xpath("(//*[@class='GameCard__GameInfoLine1-sc-1djvmxe-7 cCcRwd'])" + "[ " + m + "]"));

			String FirstGameName1 = ele.getAttribute("innerText");

			System.out.println(FirstGameName1);

			if (name.equals(FirstGameName1)) {

				ele.click();

				break;

			}
		}

		log.info("Searching Game Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("SlotsGameRealPlay"))));

		VIPPage.SlotsGameRealPlay(driver).click();

		log.info("Clicked Real Game Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Frame"))));

		// Thread.sleep(10000);

		driver.switchTo().frame(VIPPage.GameFrame(driver));

		log.info("Switching Frame Successfully");

		Actions action = new Actions(driver);

		try {

			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(f.VIPProperty("OK"))));

			action.moveToElement(element).click().perform();

			log.info("Clicked on Ok Button Successfully");

			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(f.VIPProperty("Spin"))));

			action.moveToElement(element1).click().perform();

			log.info("Spin Button Clicked successfully");

			Thread.sleep(5000);
		}

		catch (Exception E) {
			System.out.println("Trying catch block");

			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(f.VIPProperty("Spin"))));

			action.moveToElement(element1).click().perform();

			log.info("Spin Button Clicked Successfully");
		}

		Thread.sleep(19000);

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/");

		WebElement Walletbalance1 = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney1 = Walletbalance1.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount1 = new Double(Totalmoney1);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount1 = BigDecimal.valueOf(WalletAmount1);

		System.out.println("AFTER Spin Total Amount in you wallet =  " + DashboardWalletAmount1);

		VideoRecorder_utlity.stopRecord();

	}

	@Test(enabled = false, priority = 1)
	public void FirstRadioButtonGameFlow() throws Exception {

		Homepage p = new Homepage(driver);

		VideoRecorder_utlity.startRecord("Selecting First Radio Button Game Flow");

		wait = new WebDriverWait(driver, 80);

		driver.get(f.VIPProperty("DeletePoints"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("DeletePointsOk"))));

		driver.get(f.VIPProperty("MainURL"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("LoginButton"))));

		Homepage.Loginbutton(driver).click();

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

		AccountDropdown.VIP(driver).click();

		WebElement TotalPoints = VIPPage.TotalPointsSection(driver);

		String Points = TotalPoints.getAttribute("innerText");

		// System.out.println("Total points " + Points);

		String str = Points;

		String VisiblePoints = StringUtils.remove(str, "TOTAL POINTS");

		String spacesremove = VisiblePoints.replaceAll("\\s", "");

		// System.out.println(VisiblePoints);

		int i = Integer.parseInt(spacesremove);

		WebElement s = VIPPage.RewardPoints(driver);

		String Pointss = s.getAttribute("innerText");

		// System.out.println("-------"+Pointss);

		String spacesremov = Pointss.replaceAll("\\s", "");

		String wantedPart = spacesremov.split("/")[1];

		// System.out.println("final value = "+ wantedPart);

		int A = Integer.parseInt(wantedPart);

		while (i <= A) {

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/games/dice");

			Thread.sleep(5000);

			WebElement Amount = DiceGamePage.BetAmountinputField(driver);

			Amount.sendKeys(Keys.CONTROL, "a");

			Amount.sendKeys(Keys.DELETE);

			Amount.sendKeys(f.VIPProperty("Amount"));

			DiceGamePage.BetButton(driver).click();

			Thread.sleep(5000);

			driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/vip");

			Thread.sleep(5000);

			WebElement TotalPoints1 = VIPPage.TotalPointsSection(driver);

			String Points1 = TotalPoints1.getAttribute("innerText");

			// System.out.println("Total points " + Points1);

			String str1 = Points1;

			String VisiblePoints1 = StringUtils.remove(str1, "TOTAL POINTS");

			String spacesremove1 = VisiblePoints1.replaceAll("\\s", "");

			// System.out.println(VisiblePoints1);

			int i1 = Integer.parseInt(spacesremove1);

			// System.out.println("=======" + i1);

			i = i1;

		}

		WebElement Walletbalance = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney = Walletbalance.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount = new Double(Totalmoney);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount = BigDecimal.valueOf(WalletAmount);

		System.out.println("Total Amount in you wallet =  " + DashboardWalletAmount);

		// claim enable button

		VIPPage.ClaimRewardsFirstButton(driver).click();

		log.info("Claim Rewards First Button Clicked Successfully");

		WebElement GameName = VIPPage.FirstRadioButtonName(driver);

		String FirstGameName = GameName.getAttribute("innerText");

		log.info("Getting Game Name successfully ");

		System.out.println("GameName=" + FirstGameName);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(f.VIPProperty("ClaimRewardsChooseYourRewardFirstRadio"))));

		VIPPage.ClaimRewardsChooseYourRewardFirstRadio(driver).click();

		log.info("First Radio Button Clicked Successfully ");

		VIPPage.ClaimRewardsChooseYourRewardClaimSelectedRewards(driver).click();

		log.info("Clicked Confirmation Button Successfully");

		VIPPage.RewardsPopupCloseIcon(driver).click();

		log.info("Close Icon Clicked Successfully ");

		VIPPage.Slotstab(driver).click();

		log.info("Slots Tab Clicked Successfully");

		WebElement search = VIPPage.Slotssearch(driver);

		search.sendKeys(FirstGameName);

		String name = FirstGameName;

		// System.out.println("++++++++++++" + name);

		log.info("Searching a Game Successfully");

		for (int m = 1; m <= 10; m++) {

			WebElement ele = driver.findElement(
					By.xpath("(//*[@class='GameCard__GameInfoLine1-sc-1djvmxe-7 cCcRwd'])" + "[ " + m + "]"));

			String FirstGameName1 = ele.getAttribute("innerText");

			System.out.println(FirstGameName1);

			if (name.equals(FirstGameName1)) {

				ele.click();

				break;

			}
		}

		log.info("Searching Game Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("SlotsGameRealPlay"))));

		VIPPage.SlotsGameRealPlay(driver).click();

		log.info("Clicked Real Game Successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.VIPProperty("Frame"))));

		// Thread.sleep(10000);

		driver.switchTo().frame(VIPPage.GameFrame(driver));

		log.info("Switching Frame Successfully");

		Actions action = new Actions(driver);

		try {

			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(f.VIPProperty("OK"))));

			action.moveToElement(element).click().perform();

			log.info("Clicked on Ok Button Successfully");

			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(f.VIPProperty("Spin"))));

			action.moveToElement(element1).click().perform();

			log.info("Spin Button Clicked successfully");

			Thread.sleep(5000);
		}

		catch (Exception E) {
			System.out.println("Trying catch block");

			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(f.VIPProperty("Spin"))));

			action.moveToElement(element1).click().perform();

			log.info("Spin Button Clicked Successfully");
		}

		Thread.sleep(19000);

		driver.get("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/");

		WebElement Walletbalance1 = Homepage.WalletBalanceDropdown(driver);

		String Totalmoney1 = Walletbalance1.getAttribute("innerText");

		log.info("Getting Wallet Balance Successfully ");

		double WalletAmount1 = new Double(Totalmoney1);

		log.info("String Value Converting into Decimal");

		BigDecimal DashboardWalletAmount1 = BigDecimal.valueOf(WalletAmount1);

		System.out.println("AFTER Spin Total Amount in you wallet =  " + DashboardWalletAmount1);

		VideoRecorder_utlity.stopRecord();

	}

	@AfterMethod
	public void EndTest() {

		driver.close();

		log.info("Browser closed");
	}

}
