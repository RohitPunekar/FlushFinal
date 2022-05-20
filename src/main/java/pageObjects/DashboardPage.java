package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	
	public WebDriver driver;

	public static WebElement element;

	public DashboardPage(WebDriver driver) 
	{
		this.driver=driver;
	}


	public static WebElement ChatboxIcon(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[contains(@class,'jGKfbs')]"));
	}
	
	public static WebElement CloseChatboxIcon(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[contains(@class,'gIodWT')]"));
	}
	
	public static WebElement ChatboxLanguageIcon(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[contains(@class,'bAKthm')])[3]"));
	}
	
	public static WebElement languageButton(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[contains(@class,'bAKthm')])[1]"));
	}
	
	public static WebElement language1(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[contains(@class,'bFmUdG')])[1]"));
	}
	
	public static WebElement language2(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[contains(@class,'bFmUdG')])[2]"));
	}
	
	public static WebElement language3(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[contains(@class,'bFmUdG')])[3]"));
	}
	
	public static WebElement language4(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[contains(@class,'bFmUdG')])[4]"));
	}
	
	public static WebElement Userdropdown(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='UserDropdownMenu__DropdownButton-sc-qt4bc8-2 ggVtEi']"));
	}

	public static WebElement Logout(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Logout']"));
	}

	public static WebElement Welcomepassword(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@placeholder='Password']"));
	}

	public static WebElement Welcomeplaynow(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Play Now']"));
	}
	public static WebElement BetButton(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='BET']"));
	}
	public static WebElement Cashier(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Cashier']"));
	}
	public static WebElement Crossicon(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='ModalMain__CloserBtn-sc-1xo7njg-0 icXoLY']"));
	}
	public static WebElement VIP(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='VIP']"));
	}
	public static WebElement Transaction(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Transactions']"));
	}
	public static WebElement TransactionDepositTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Deposits']"));
	}
	public static WebElement TransactionWithdrawTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Withdrawals']"));
	}
	public static WebElement TransactionRewardsTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Rewards']"));
	}
	public static WebElement TransactionBetsTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='BETS']"));
	}
	public static WebElement Statistics(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Statistics']"));
	}
	public static WebElement StatisticsBreakDownTab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Breakdown']"));
	}
	public static WebElement Statisticsoveralltab(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Overall']"));
	}
	public static WebElement Settings(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Settings']"));
	}
	public static WebElement Oldpassword(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 glARGZ'])[1]"));
	}
	public static WebElement changepasswordtext(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='CHANGE PASSWORD']"));
	}
	public static WebElement Newpassword(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 glARGZ'])[2]"));
	}
	public static WebElement ConfirmNewpassword(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 glARGZ'])[3]"));
	}
	public static WebElement Savechanges(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@type='submit']"));
	}
	public static WebElement Cancel(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='CANCEL']"));
	}
	public static WebElement PasswordDontMatchError(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Passwords dont match!']"));
	}
	public static WebElement Walletbalance(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='DepositSection__BalanceNumber-sc-14n4hii-7 bnWWxD']"));
	}
	public static WebElement ETH(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='ETH']"));
	}
	public static WebElement LTC(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='LTC']"));
	}
	public static WebElement DOGE(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='DOGE']"));
	}
	public static WebElement MATIC(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='MATIC']"));
	}
	public static WebElement BNB(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='BNB']"));
	}
	public static WebElement UserNameEditicon(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='SecuritySections__EditIcon-sc-1u32dw3-6 fnUrRG']"));
	}
	public static WebElement UserNameInputBox(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@type='text']"));
	}
	public static WebElement UserNameUpdateButton(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='UPDATE']"));
	}
	
	public static WebElement OriginalsHeader(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='Sidebar__UpperDiv-sc-nzv22c-3 dXuJQF'])/div[4]"));
	}
	
	public static WebElement LiveCasinoHeader(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='Sidebar__UpperDiv-sc-nzv22c-3 dXuJQF'])/div[3]"));
	}
	
	public static WebElement SlotsHeader(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='Sidebar__UpperDiv-sc-nzv22c-3 dXuJQF'])/div[2]"));
	}
	
	public static WebElement MinesGameLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='GameCard__WrapperGame-sc-g0x5h9-0 JmqfD'])[3]"));
	}
	
}
