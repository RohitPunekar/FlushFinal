package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class MinesGamePage {
    
public WebDriver driver;
    
    public static WebElement element;
    public MinesGamePage(WebDriver driver) 
    {
        this.driver=driver;
    }
    
    
    public static WebElement MinesLink(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='GameCard__WrapperGame-sc-g0x5h9-0 JmqfD'])[3]"));
    }
    public static WebElement BetButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='CustomButton-sc-1np6xc3-0 kmHtcK']/span"));
    }
    public static WebElement MinesGameSidebar(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='SidebarMines__GameSidebarWrapper-sc-1a49fvy-0 clxEDK']"));
    }
    public static WebElement WalletBalance(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='DepositSection__DropDownButton-sc-14n4hii-4 cQEYtD']"));
    }
    public static WebElement MaxAmount(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='LabelInput__LabelContent-sc-zkip7h-2 ECQgB']/span)[2]"));
    }
    public static WebElement BetAmount(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty']"));
    }
    public static WebElement ErrorMessage(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='Tooltip__TooltipMessage-sc-lnycwz-2 bymWBZ']"));
    }
    public static WebElement MinesDropDown(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='CustomDropdown__ButtonContent-sc-1hmifsq-4 LTFnp']"));
    }
    public static WebElement MinesDropDown5(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='5']"));
    }
    public static WebElement MinesDropDown2(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='2']"));
    }
    public static WebElement MinesDropDown3(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='3']"));
    }
    public static WebElement MinesDropDown24(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='24']"));
    }
    public static WebElement HalfxButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='SidebarMines__InputButtonV1-sc-1a49fvy-5 kPaYOu'])[1]"));
    }
    public static WebElement TwoxButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='SidebarMines__InputButtonV1-sc-1a49fvy-5 kPaYOu'])[2]"));
    }
    public static WebElement MaximumMines(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='24']"));
    }
    public static WebElement PickRandomTile(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='SidebarMines__ButtonText-sc-1a49fvy-4 PfNsz']"));
    }
    public static WebElement Cashout(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='CASHOUT']"));
    }
    public static WebElement MinesGameSetting(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandItem-sc-gpcbvp-2 krcAzl'])[1]"));
    }
    public static WebElement SettingSoundButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomSwitch__SwitchWrapper-sc-1bodba9-0 hbtKro'])[1]"));
    }
    public static WebElement SettingGamesSidebarButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomSwitch__SwitchWrapper-sc-1bodba9-0 hbtKro'])[2]"));
    }
    public static WebElement MinesGameRules(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandItem-sc-gpcbvp-2 krcAzl'])[2]"));
    }
    public static WebElement MinesGameRulesPopUp(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='RulesLimitsModal__Main-sc-1bim13d-1 jDIAL']"));
    }
    public static WebElement MinesGameLiveStats(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandItem-sc-gpcbvp-2 krcAzl'])[3]"));
    }
    public static WebElement MinesGameLiveStatsPopUp(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='LiveStatsModal__StatsCardsWrapper-sc-gafewh-4 bIhfOt']"));
    }
    public static WebElement MinesGameFairnessIcon(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandItem-sc-gpcbvp-2 krcAzl'])[4]"));
    }
    public static WebElement MinesGameFairnessChangeButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='CHANGE']"));
    }
    public static WebElement MinesGameFairnessActiveServerSeed(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 bcESjD'])[2]"));
    }
    public static WebElement MinesGameFairnessNextServerSeed(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 bcESjD'])[4]"));
    }
    public static WebElement MinesGameFairnessGoToTransaction(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='FairnessSection__LinkButton-sc-e5o9ot-4 eSVxxu']"));
    }
    public static WebElement MinesGameFairnessTransactions(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='IconGetters__Wrapper-sc-jp6spq-1 ZDNFx']"));
    }
    public static WebElement MinesGameFairnessVerifyBet(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='Verify Bet']"));
    }
    public static WebElement MinesGameFairnessVerifyBetGame(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomDropdown__DropDownButton-sc-1hmifsq-2 gBAQOB'])[1]"));
    }
    public static WebElement MinesGameFairnessVerifyBetNonce(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 glARGZ'])[2]"));
    }
    public static WebElement MinesGameFairnessVerifyBetMines(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomDropdown__DropDownButton-sc-1hmifsq-2 gBAQOB'])[2]"));
    }
    public static WebElement MinesGameFairnessVerifyBetServerSeed(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 glARGZ'])[3]"));
    }
    
    
    
}