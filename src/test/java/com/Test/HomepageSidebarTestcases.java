package com.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import pageObjects.HomepageSidebar;
import resources.base;
public class HomepageSidebarTestcases extends base
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
    public void LobbyIcon() throws InterruptedException, IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Lobby Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        //Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("LobbyIcon"))));
        
        HomepageSidebar.LobbyIcon(driver).click();
        
        log.info("Lobby Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@class='container']")));
        
        boolean Result = HomepageSidebar.Container(driver).isDisplayed();
        
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
    public void FeaturedSlotsIcon() throws IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Featured Slots Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("FeaturedSlotsIcon"))));
        
        HomepageSidebar.FeaturedSlotsIcon(driver).click();
        
        log.info("Featured Slots Icon clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Featured Slots']")));
        
        boolean Result = HomepageSidebar.FeaturedSlots(driver).isDisplayed();
        
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
    public void LiveCasinoIcon() throws IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Live Casino Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("LiveCasinoIcon")))); 
        
        HomepageSidebar.LiveCasinoIcon(driver).click();
        
        log.info("Live Casino Icon clicked successfully"); 
       
        boolean Result = HomepageSidebar.LiveCasino(driver).isDisplayed();
        
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
    public void FlushOriginalsIcon() throws IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Flush Originals Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("FlushOriginalsIcon"))));
        
        HomepageSidebar.FlushOriginalsIcon(driver).click();
        
        log.info("Flush Originals Icon clicked successfully");
        
        boolean Result = HomepageSidebar.flushOriginals(driver).isDisplayed();
        
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
    public void NewGamesIcon() throws IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar New Games Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("NewGamesIcon"))));
        
        HomepageSidebar.NewGamesIcon(driver).click();
        
        log.info("New games Icon clicked successfully");
        
        boolean Result = HomepageSidebar.NewGames(driver).isDisplayed();
        
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
    public void PopularGamesIcon() throws IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Popular Games Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("PopularGamesIcon"))));
        
        HomepageSidebar.PopularGamesIcon(driver).click();
        
        log.info("Popular games Icon clicked successfully");
        
        boolean Result = HomepageSidebar.PopularGames(driver).isDisplayed();
        
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
    public void ProvidersIcon() throws IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Providers Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("ProvidersIcon"))));
        
        HomepageSidebar.ProvidersIcon(driver).click();
        
        log.info("Providers Icon clicked successfully");
  
        boolean Result = HomepageSidebar.AllProvider(driver).isDisplayed();
        
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
    public void SidebarVIPIcon() throws IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar VIP Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("SidebarVIPIcon"))));
        
        HomepageSidebar.SidebarVIPIcon(driver).click();
        
        log.info("VIP Icon clicked successfully");
       
        boolean Result = HomepageSidebar.VIPFeatures(driver).isDisplayed();
        
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
    public void SidebarBuyCryptoIcon() throws IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Buy Crypto Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("SidebarBuyCryptoIcon"))));
        
        HomepageSidebar.SidebarBuyCryptoIcon(driver).click();
        
        log.info("Buy Crypto Icon clicked successfully");
        
      
        
        String Message = HomepageSidebar.SidebarBuyCryptoMsg(driver).getText();
        
        System.out.println(Message);
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=10)
    public void SidebarLanguageIconEnglish() throws InterruptedException, IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar First Language Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("SidebarLanguageIcon"))));
        
        HomepageSidebar.SidebarLanguageIcon(driver).click();
        
        log.info("Language Icon clicked successfully");
        
        Thread.sleep(2000);
        
        HomepageSidebar.EnglishLanguage(driver).click();
        
         log.info("English Language clicked successfully");
         
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=11)
    public void SidebarLanguageIconSecondLang() throws InterruptedException, IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Second Language Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("SidebarLanguageIcon"))));
        
        HomepageSidebar.SidebarLanguageIcon(driver).click();
        
        log.info("Language Icon clicked successfully");
        
        Thread.sleep(4000);
        
        HomepageSidebar.SecondLanguage(driver).click();
         
       log.info("Second Language clicked successfully");
         
      //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=12)
    public void SidebarLanguageIconThirdLang() throws InterruptedException, IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Third Language Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("SidebarLanguageIcon"))));
        
        HomepageSidebar.SidebarLanguageIcon(driver).click();
        
        log.info("Language Icon clicked successfully");
        
        Thread.sleep(4000);
        
         HomepageSidebar.ThirdLanguage(driver).click();
        
         log.info("Third Language clicked successfully");
         
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @Test(enabled = true,priority=13)
    public void SidebarLanguageIconFourthLang() throws InterruptedException, IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Fourth Language Icon");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("SidebarLanguageIcon"))));
        
        HomepageSidebar.SidebarLanguageIcon(driver).click();
        
        log.info("Language Icon clicked successfully");
        
        Thread.sleep(2000);
        
         HomepageSidebar.FourthLanguage(driver).click();
        
         log.info("Fourth Language clicked successfully");
         
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    
    @Test(enabled = true,priority=14)
    public void SidebarLiveChatIcon() throws InterruptedException
    {
    	//VideoRecorder_utlity.startRecord("Sidebar live Chat Icon");
    	
    	driver.navigate().to("https://pojy67209hjyfrthuopvshcnqoclpn.flush.com/");
    	
		// driver.navigate.to("");
    	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		boolean searchIconPresence = driver
				.findElement(By.xpath("(//*[@class='Sidebar__WrapLowerEl-sc-nzv22c-8 bgWSwr'])[1]")).isDisplayed();
		
		boolean searchIconEnabled = driver
				.findElement(By.xpath("(//*[@class='Sidebar__WrapLowerEl-sc-nzv22c-8 bgWSwr'])[1]")).isEnabled();
		
        WebElement searchIcon = driver.findElement(By.xpath("(//*[@class='Sidebar__WrapLowerEl-sc-nzv22c-8 bgWSwr'])[1]"));
        
        while(searchIcon.isDisplayed())
        {
        	Thread.sleep(7000);
        	
        	searchIcon.click();
        	
        	System.out.println("----");
        	
        	//Thread.sleep(5000);
        	
        	WebElement ChatIcon=driver.findElement(By.xpath("//*[@class='cc-1jpm']"));
        	
        	Thread.sleep(2000);
        	
        	if(ChatIcon.isDisplayed())
        	{
        		break;
        	}
        }
        System.out.println("done");
        
      //VideoRecorder_utlity.stopRecord();
    }
    
    
    @Test(enabled = true,priority=15)
    public void SidebarArrow() throws InterruptedException, IOException
    {
        //VideoRecorder_utlity.startRecord("Sidebar Arrow");
        
        wait = new WebDriverWait(driver, 50);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("SidebarArrowOut"))));
        
        HomepageSidebar.SidebarArrowOut(driver).click();
        
        log.info("Sidebar Arrow Out button clicked successfully");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(f.SidebarProperty("SidebarArrowIn"))));
        
        HomepageSidebar.SidebarArrowIn(driver).click();
        
        log.info("Sidebar Arrow In button clicked successfully");
        
        //VideoRecorder_utlity.stopRecord();
        
    }
    
    @AfterMethod
	public void EndTest() throws InterruptedException
    {
    	Thread.sleep(2000);
		
		driver.close();

		log.info("Browser closed");
	}
}
