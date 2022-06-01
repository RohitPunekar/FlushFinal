package com.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.homepageFooter;
import resources.base;

public class HomepageFooter extends base {

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
	public void provablyFair() throws Exception {

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("ProvablyFairLink"))));

		log.info("Provably Fair link is visible successfully");

		homepageFooter.ProvablyFairLink(driver).click();

		log.info("Clicked on Provably Fair link");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("ImplementationTab"))));

		log.info("Provably Fair page is visible successfully");

		homepageFooter.ImplementationTab(driver).click();

		log.info("Clicked on Implementation tab");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("ImplementationTabText"))));

		log.info("Implementation section page is visible successfully");

		homepageFooter.OverviewTab(driver).click();

		log.info("Clicked on Overview Tab");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("OverviewTabText"))));

		log.info("Overview section page is visible successfully");
	}

	@Test(enabled = true, priority = 2)
	public void gambleAware() throws IOException {
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("GambleAwareLink"))));

		log.info("Gamble Aware link is visible successfully");

		homepageFooter.GambleAwareLink(driver).click();

		log.info("Clicked on Gamble Aware Link");

		Set<String> windows = driver.getWindowHandles(); // [parent id,child id]

		Iterator<String> it = windows.iterator();

		String parentID = it.next();

		String childID = it.next();

		driver.switchTo().window(childID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("GamCareLogo"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("GamCarePageText"))));

		log.info("GamCare page is visible successfully");

		driver.switchTo().window(parentID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("GambleAwareLink"))));
	}

	@Test(enabled = true, priority = 3)
	public void HomeButton() throws IOException {

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("HomeButtonLink"))));

		log.info("Home Button link is visible successfully");

		homepageFooter.ProvablyFairLink(driver).click();

		log.info("Clicked on Provably Fair link");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("ImplementationTab"))));

		log.info("Provably Fair page is visible successfully");

		homepageFooter.HomeButtonLink(driver).click();

		log.info("Clicked on home button link available on the footer");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FeaturedSlotsText"))));

		log.info("Redirected to home page successfully");
	}

	@Test(enabled = true, priority = 4)
	public void AMLPolicy() throws IOException {

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("AMLPolicyLink"))));

		homepageFooter.AMLPolicyLink(driver).click();

		log.info("Clicked on AML Policy link successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("AMLPolicyText"))));

		log.info("AML Policy page is visible successfully");
	}

	@Test(enabled = true, priority = 5)
	public void PrivacyPolicy() throws IOException {

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("PrivacyPolicyLink"))));

		homepageFooter.PrivacyPolicyLink(driver).click();

		log.info("Clicked on Privacy Policy link successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("PrivacyPolicyText"))));

		log.info("Privacy Policy page is visible successfully");
	}

	@Test(enabled = true, priority = 6)
	public void KYCPolicy() throws IOException {

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("KYCPolicyLink"))));

		homepageFooter.KYCPolicyLink(driver).click();

		log.info("Clicked on KYC Policy link successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("KYCPolicyText"))));

		log.info("KYC Policy page is visible successfully");
	}

	@Test(enabled = true, priority = 7)
	public void ResponsibleGaming() throws IOException {

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("ResponsibleGamingLink"))));

		homepageFooter.ResponsibleGamingLink(driver).click();

		log.info("Clicked on Responsible Gaming link successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("ResponsibleGamingText"))));

		log.info("Responsible Gaming page is visible successfully");
	}

	@Test(enabled = true, priority = 8)
	public void TermsofService() throws IOException {

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("TermsOfServiceLink"))));

		homepageFooter.TermsOfServiceLink(driver).click();

		log.info("Clicked on Terms of Service link successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("TermsOfServiceText"))));

		log.info("Terms of Service page is visible successfully");
	}

	@Test(enabled = true, priority = 9)
	public void FooterLanguageIcon() throws IOException {

		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FooterLanguageChange"))));

		homepageFooter.FooterLanguageChange(driver).click();

		log.info("Clicked on Language button successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("language1"))));

		homepageFooter.language1(driver).click();

		log.info("Clicked on language 1");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("language1Text"))));

		log.info("Language changed to English language successfully");

	}
	
	@Test(enabled = true, priority = 10)
	public void FooterLanguageIconSecondLang() throws IOException {
		
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FooterLanguageChange"))));

		homepageFooter.FooterLanguageChange(driver).click();

		log.info("Clicked on Language button successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("language2"))));

		homepageFooter.language2(driver).click();

		log.info("Clicked on language 2");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("language2Text"))));

		log.info("Language changed to second language successfully");
	}
	
	@Test(enabled = true, priority = 11)
	public void FooterLanguageIconThirdLang() throws IOException {
		
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FooterLanguageChange"))));

		homepageFooter.FooterLanguageChange(driver).click();

		log.info("Clicked on Language button successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("language3"))));

		homepageFooter.language3(driver).click();

		log.info("Clicked on language 3");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("language3Text"))));

		log.info("Language changed to third language successfully");
	}
	
	@Test(enabled = true, priority = 12)
	public void FooterLanguageIconFourthLang() throws IOException {
		
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FooterLanguageChange"))));

		homepageFooter.FooterLanguageChange(driver).click();

		log.info("Clicked on Language button successfully");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("language4"))));

		homepageFooter.language4(driver).click();

		log.info("Clicked on language 4");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("language4Text"))));

		log.info("Language changed to fourth language successfully");
	}
	
	@Test(enabled = true, priority = 13)
	public void FooterFacebookIcon() throws IOException {
		
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterFacebookIcon"))));
		
		homepageFooter.FlushFooterFacebookIcon(driver).click();
		
		log.info("Clicked on Facebook icon available on footer");
		
		Set<String> windows = driver.getWindowHandles(); // [parent id,child id]

		Iterator<String> it = windows.iterator();

		String parentID = it.next();

		String childID = it.next();

		driver.switchTo().window(childID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterFacebookImage"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterFacebookText"))));

		log.info("Flush Facebook Home page is visible successfully");

		driver.switchTo().window(parentID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterFacebookIcon"))));
		
	}
	
	@Test(enabled = true, priority = 14)
	public void FooterTwitterIcon() throws IOException {
		
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterTwitterIcon"))));
		
		homepageFooter.FlushFooterTwitterIcon(driver).click();
		
		log.info("Clicked on Twitter icon available on footer");
		
		Set<String> windows = driver.getWindowHandles(); // [parent id,child id]

		Iterator<String> it = windows.iterator();

		String parentID = it.next();

		String childID = it.next();

		driver.switchTo().window(childID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterTwitterImage"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterTwitterText"))));

		log.info("Flush Twitter Home page is visible successfully");

		driver.switchTo().window(parentID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterTwitterIcon"))));
		
	}
	
	@Test(enabled = true, priority = 15)
	public void FooterInstagramIcon() throws IOException {
		
		wait = new WebDriverWait(driver, 50);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterInstagramIcon"))));
		
		homepageFooter.FlushFooterInstagramIcon(driver).click();
		
		log.info("Clicked on Instagram icon available on footer");
		
		Set<String> windows = driver.getWindowHandles(); // [parent id,child id]

		Iterator<String> it = windows.iterator();

		String parentID = it.next();

		String childID = it.next();

		driver.switchTo().window(childID);
		
		try {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterInstagramImage"))));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterInstagramText"))));

		log.info("Flush Instagram Home page is visible successfully");
		
		}catch(Exception e) {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterInstagramLogin"))));

			log.info("Flush Instagram login page is visible successfully");
		}

		driver.switchTo().window(parentID);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(f.FooterProperty("FlushFooterInstagramIcon"))));
		
	}
	
	@AfterMethod
	public void EndTest() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.quit();

		log.info("Browser closed");
	}
}
