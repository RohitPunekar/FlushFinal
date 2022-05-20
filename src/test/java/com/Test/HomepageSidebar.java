package com.Test;
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
import pageObjects.Homepage;
import resources.base;
public class HomepageSidebar extends base
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
    
    @Test(enabled = true,priority=1)
    public void LobbyIcon()
    {
        //VideoRecorder_utlity.startRecord("Sidebar Lobby Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.LobbyIcon(driver).click();
        
        log.info("Lobby Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@class='container']")));
        
        boolean Result = pageObjects.HomepageSidebar.Container(driver).isDisplayed();
        
        if(Result==true)
        {
            System.out.println("Test case Passed");
        }
        else
        {
            System.out.println("Test case Failed");
        }
        
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=2)
    public void FeaturedSlotsIcon()
    {
        //VideoRecorder_utlity.startRecord("Sidebar Featured Slots Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.FeaturedSlotsIcon(driver).click();
        
        log.info("Featured Slots Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Featured Slots']")));
        
        boolean Result = pageObjects.HomepageSidebar.FeaturedSlots(driver).isDisplayed();
        
        if(Result==true)
        {
            System.out.println("Test case Passed");
        }
        else
        {
            System.out.println("Test case Failed");
        }
        
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=3)
    public void LiveCasinoIcon()
    {
        //VideoRecorder_utlity.startRecord("Sidebar Live Casino Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.LiveCasinoIcon(driver).click();
        
        log.info("Live Casino Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Live Casino']")));
        
        boolean Result = pageObjects.HomepageSidebar.LiveCasino(driver).isDisplayed();
        
        if(Result==true)
        {
            System.out.println("Test case Passed");
        }
        else
        {
            System.out.println("Test case Failed");
        }
        
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=4)
    public void FlushOriginalsIcon()
    {
        //VideoRecorder_utlity.startRecord("Sidebar Flush Originals Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.FlushOriginalsIcon(driver).click();
        
        log.info("Flush Originals Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Flush Originals']")));
        
        boolean Result = pageObjects.HomepageSidebar.flushOriginals(driver).isDisplayed();
        
        if(Result==true)
        {
            System.out.println("Test case Passed");
        }
        else
        {
            System.out.println("Test case Failed");
        }
        
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=5)
    public void NewGamesIcon()
    {
        //VideoRecorder_utlity.startRecord("Sidebar New Games Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.NewGamesIcon(driver).click();
        
        log.info("New games Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='New Games']")));
        
        boolean Result = pageObjects.HomepageSidebar.NewGames(driver).isDisplayed();
        
        if(Result==true)
        {
            System.out.println("Test case Passed");
        }
        else
        {
            System.out.println("Test case Failed");
        }
        
        //VideoRecorder_utlity.stopRecord();
        
    }
    @Test(enabled = true,priority=6)
    public void PopularGamesIcon()
    {
        //VideoRecorder_utlity.startRecord("Sidebar Popular Games Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.PopularGamesIcon(driver).click();
        
        log.info("Popular games Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Popular Games']")));
        
        boolean Result = pageObjects.HomepageSidebar.PopularGames(driver).isDisplayed();
        
        if(Result==true)
        {
            System.out.println("Test case Passed");
        }
        else
        {
            System.out.println("Test case Failed");
        }
        
        //VideoRecorder_utlity.stopRecord();
        
    }
    @Test(enabled = true,priority=7)
    public void ProvidersIcon()
    {
        //VideoRecorder_utlity.startRecord("Sidebar Providers Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.ProvidersIcon(driver).click();
        
        log.info("Providers Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='All Providers']")));
        
        boolean Result = pageObjects.HomepageSidebar.AllProvider(driver).isDisplayed();
        
        if(Result==true)
        {
            System.out.println("Test case Passed");
        }
        else
        {
            System.out.println("Test case Failed");
        }
        
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=8)
    public void SidebarVIPIcon()
    {
        //VideoRecorder_utlity.startRecord("Sidebar VIP Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.SidebarVIPIcon(driver).click();
        
        log.info("VIP Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()=' VIP Features']")));
        
        boolean Result = pageObjects.HomepageSidebar.VIPFeatures(driver).isDisplayed();
        
        if(Result==true)
        {
            System.out.println("Test case Passed");
        }
        else
        {
            System.out.println("Test case Failed");
        }
        
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=9)
    public void SidebarBuyCryptoIcon()
    {
        //VideoRecorder_utlity.startRecord("Sidebar Buy Crypto Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.SidebarBuyCryptoIcon(driver).click();
        
        log.info("Buy Crypto Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@class='Snackbar__MessagwWrapper-sc-g1jq3j-3 kXhAsS']")));
        
        String Message = pageObjects.HomepageSidebar.SidebarBuyCryptoMsg(driver).getText();
        
        System.out.println(Message);
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=10)
    public void SidebarLanguageIconEnglish() throws InterruptedException
    {
        //VideoRecorder_utlity.startRecord("Sidebar First Language Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.SidebarLanguageIcon(driver).click();
        
        log.info("Language Icon clicked successfully");
        
        Thread.sleep(2000);
        
         pageObjects.HomepageSidebar.EnglishLanguage(driver).click();
        
         log.info("English Language clicked successfully");
         
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=11)
    public void SidebarLanguageIconSecondLang() throws InterruptedException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Second Language Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.SidebarLanguageIcon(driver).click();
        
        log.info("Language Icon clicked successfully");
        
        Thread.sleep(2000);
        
         pageObjects.HomepageSidebar.SecondLanguage(driver).click();
        
         log.info("Second Language clicked successfully");
         
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=12)
    public void SidebarLanguageIconThirdLang() throws InterruptedException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Third Language Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.SidebarLanguageIcon(driver).click();
        
        log.info("Language Icon clicked successfully");
        
        Thread.sleep(2000);
        
         pageObjects.HomepageSidebar.ThirdLanguage(driver).click();
        
         log.info("Third Language clicked successfully");
         
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=13)
    public void SidebarLanguageIconFourthLang() throws InterruptedException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Fourth Language Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.SidebarLanguageIcon(driver).click();
        
        log.info("Language Icon clicked successfully");
        
        Thread.sleep(2000);
        
         pageObjects.HomepageSidebar.FourthLanguage(driver).click();
        
         log.info("Fourth Language clicked successfully");
         
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    
    @Test(enabled = true,priority=14)
    public void SidebarLiveChatIcon() throws InterruptedException
    {
        //VideoRecorder_utlity.startRecord("Sidebar live Chat Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.SidebarArrowOut(driver).click();
        
        log.info("Sidebar Arrow Out button clicked successfully");
        
        WebElement LiveChat = pageObjects.HomepageSidebar.SidebarLivechatIcon(driver);
        
        Actions action = new Actions(driver);
        
        
        try
        {
            action.moveToElement(LiveChat).click().perform();
        }
        catch(Exception e)
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            
            js.executeScript("arguments[0].click", LiveChat);
            
            //pageObjects.HomepageSidebar.SidebarLivechatIcon(driver).click();
        }
        
        
        
        
//      Thread.sleep(2000);
//      
//      action.moveToElement(LiveChat).click().perform();
        
        log.info("Live Chat Icon clicked successfully");
        
        Thread.sleep(8000);
        
//      String Message = pageObjects.HomepageSidebar.LivechatPopUp(driver).getText();
    
//      System.out.println(Message);
    
    
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=15)
    public void SidebarArrow() throws InterruptedException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Arrow");
        
        wait = new WebDriverWait(driver, 50);
        
        pageObjects.HomepageSidebar.SidebarArrowOut(driver).click();
        
        log.info("Sidebar Arrow Out button clicked successfully");
        
        Thread.sleep(4000);
        
        pageObjects.HomepageSidebar.SidebarArrowIn(driver).click();
        
        log.info("Sidebar Arrow In button clicked successfully");
        
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @AfterMethod
	public void EndTest() {
		
		driver.close();

		log.info("Browser closed");
	}
}
