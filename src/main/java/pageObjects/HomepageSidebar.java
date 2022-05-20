package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomepageSidebar
{

	public WebDriver driver;
	public static WebElement element;
    
    public HomepageSidebar(WebDriver driver) 
    {
        this.driver=driver;
    }
    
    public static WebElement LobbyIcon(WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='Sidebar__WrapEl-sc-nzv22c-4 dRnvSu'])[1]"));
    }
    public static WebElement Container(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[@class='container']"));
    }
    public static WebElement FeaturedSlotsIcon(WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='Sidebar__WrapEl-sc-nzv22c-4 dRnvSu'])[2]"));
    }
    public static WebElement FeaturedSlots(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[text()='Featured Slots']"));
    }
    public static WebElement LiveCasinoIcon (WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='Sidebar__WrapEl-sc-nzv22c-4 dRnvSu'])[3]"));
    }
    public static WebElement LiveCasino(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[text()='Live Casino']"));
    }
    public static WebElement FlushOriginalsIcon(WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='Sidebar__WrapEl-sc-nzv22c-4 dRnvSu'])[4]"));
    }
    public static WebElement flushOriginals(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[text()='Flush Originals']"));
    }
    public static WebElement NewGamesIcon(WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='Sidebar__WrapEl-sc-nzv22c-4 dRnvSu'])[5]"));
    }
    public static WebElement NewGames(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[text()='New Games']"));
    }
    public static WebElement PopularGamesIcon(WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='Sidebar__WrapEl-sc-nzv22c-4 dRnvSu'])[6]"));
    }
    public static WebElement PopularGames(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[text()='Popular Games']"));
    }
    public static WebElement ProvidersIcon(WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='Sidebar__WrapEl-sc-nzv22c-4 dRnvSu'])[7]"));
    }
    public static WebElement AllProvider(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[text()='All Providers']"));
    }
    
    
    public static WebElement SidebarVIPIcon (WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='Sidebar__WrapLowerEl-sc-nzv22c-8 jWCBgn'])[1]"));
    }
    public static WebElement VIPFeatures(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[text()=' VIP Features']"));
    }
    public static WebElement SidebarLivechatIcon(WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='Sidebar__Title-sc-nzv22c-5 ipJlhU'])[9]"));
    }
    public static WebElement LivechatPopUp(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[@class='cc-m7ux cc-guf7 cc-ujki']"));
    }
    public static WebElement SidebarLanguageIcon (WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[@class='Sidebar__LanguageButtonWrapper-sc-nzv22c-9 fqbasa']"));
    }
    public static WebElement EnglishLanguage (WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[text()='ENGLISH']"));
    }
    public static WebElement SecondLanguage (WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='LanguagesPopupContent__DropdownItem-sc-1lk2r7t-1 hqlcEE'])[2]"));
    }
    public static WebElement ThirdLanguage (WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='LanguagesPopupContent__DropdownItem-sc-1lk2r7t-1 hqlcEE'])[3]"));
    }
    public static WebElement FourthLanguage (WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='LanguagesPopupContent__DropdownItem-sc-1lk2r7t-1 hqlcEE'])[4]"));
    }
    public static WebElement SidebarBuyCryptoIcon (WebDriver driver)
    {
    	return driver.findElement(By.xpath("(//*[@class='Sidebar__WrapLowerEl-sc-nzv22c-8 jWCBgn'])[2]"));
    }
    public static WebElement SidebarBuyCryptoMsg (WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[@class='Snackbar__MessagwWrapper-sc-g1jq3j-3 kXhAsS']"));
    }
    public static WebElement SidebarArrowOut(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[@class='Layout__ChatBoxStatus2-sc-h12xh4-5 hPChQh']"));
    }
    public static WebElement SidebarArrowIn(WebDriver driver)
    {
    	return driver.findElement(By.xpath("//*[@class='Layout__ChatBoxStatus2-sc-h12xh4-5 iRJWMr']"));
    }
    
    
    
    
    
    
}