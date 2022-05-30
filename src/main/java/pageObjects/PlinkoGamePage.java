package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
    public class PlinkoGamePage 
    {
        public WebDriver driver;
    
    public static WebElement element;
    
    public PlinkoGamePage(WebDriver driver)
    {
        this.driver = driver;
    }
    
    public static WebElement PlinkoLink(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='GameCard__WrapperGame-sc-g0x5h9-0 JmqfD'])[7]"));
    }
    public static WebElement Manual(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='MANUAL']"));
    }
    public static WebElement BetAmountInpField(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty']"));
    }
    public static WebElement HalfAmount(WebDriver driver) 
    {
        return driver.findElement(By.xpath("(//*[@class='PlinkoSidebar__InputButtonV1-sc-152qpm4-3 fXzBWt'])[1]"));
    }
    public static WebElement DoubleAmount(WebDriver driver) 
    {
        return driver.findElement(By.xpath("(//*[@class='PlinkoSidebar__InputButtonV1-sc-152qpm4-3 fXzBWt'])[2]"));
    }
    public static WebElement Risk(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomDropdown__DropDownButton-sc-1hmifsq-2 gBAQOB'])[1]"));
    }
    public static WebElement RiskLow(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='Low']"));
    }
    public static WebElement RiskMedium(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='Medium']"));
    }
    public static WebElement RiskHigh(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='High']"));
    }
    
    public static WebElement Rows(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomDropdown__DropDownButton-sc-1hmifsq-2 gBAQOB'])[2]"));
    }
    public static WebElement NoOfRows8(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='8']"));
    }
    public static WebElement NoOfRows9(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='9']"));
    }
    public static WebElement NoOfRows10(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='10']"));
    }
    public static WebElement NoOfRows11(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='11']"));
    }
    public static WebElement NoOfRows12(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='12']"));
    }
    public static WebElement NoOfRows13(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='13']"));
    }
    public static WebElement NoOfRows14(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='14']"));
    }
    public static WebElement NoOfRows15(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='15']"));
    }
    public static WebElement NoOfRows16(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='16']"));
    }
    
//  public static List<WebElement> NoOfRows(WebDriver driver)
//  {
//      List<WebElement> NoOfRows = driver.findElements(By.xpath("//*[@class='CustomDropdown__MenuButton-sc-1hmifsq-3 erYRgZ']/span"));
//         return NoOfRows; 
//  }
    
    
    public static WebElement ClickOnBETBotton(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='PlinkoSidebar__ButtonText-sc-152qpm4-4 bXpPPe']"));
    }
    public static WebElement MyBets(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='MY BETS']"));
    }
    
    public static WebElement Bets(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='BETS']"));
    }
    
    public static WebElement HighRollers(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='HIGH ROLLERS']"));
    }
    
    public static WebElement PayoutPlinkoGame(WebDriver driver) 
    {
        return driver.findElement(By.xpath("(//*[@class='StatsTable__Table-sc-2fnw4d-3 kUqEPJ']//tbody//tr[1]//td[5])[1]"));
    }
    
    
    
    public static WebElement Auto(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='AUTO']"));
    }   
    public static WebElement AutoNoOfBetsField(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty'])[2]"));
    }
    public static WebElement ClickOnStartAutoBet(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='START AUTOBET']"));
    }
    
    public static WebElement ClickOnStopAutoBet(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='STOP AUTOBET']"));
    }
    
    public static WebElement PlinkoGameSetting(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandButton-sc-gpcbvp-4 VWgwX'])[1]"));
    }
    
    public static WebElement PlinkoGameSettingSoundButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomSwitch__SwitchWrapper-sc-1bodba9-0 hbtKro'])[1]"));
    }
    
    public static WebElement PlinkoGameSettingGamesSidebarButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomSwitch__SwitchWrapper-sc-1bodba9-0 hbtKro'])[2]"));
    }
    
    public static WebElement PlinkoGameRules(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandButton-sc-gpcbvp-4 VWgwX'])[2]"));
    }
    
    public static WebElement PlinkoGameRulesPopUp(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='RulesLimitsModal__Main-sc-1bim13d-1 jDIAL']"));
    }
    
    public static WebElement PlinkoGameLiveStats(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandButton-sc-gpcbvp-4 VWgwX'])[3]"));
    }
    public static WebElement PlinkoGameLiveStatsPopUp(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='LiveStatsModal__StatsCardsWrapper-sc-gafewh-4 bIhfOt']"));
    }
    public static WebElement PlinkoGameFairnessIcon(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandButton-sc-gpcbvp-4 VWgwX'])[4]"));
    }
    public static WebElement PlinkoGameFairnessPopUp(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='CHANGE']"));
    }
    public static WebElement PlinkoGameFairnessGoToTransaction(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='FairnessSection__LinkButton-sc-e5o9ot-4 eSVxxu']"));
    }
    public static WebElement PlinkoGameFairnessTransactionsRow(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='IconGetters__Wrapper-sc-jp6spq-1 ZDNFx'])[1]"));
    }
    public static WebElement PlinkoGameFairnessActiveServerSeed(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 bcESjD'])[2]"));
    }
    public static WebElement PlinkoGameFairnessNextServerSeed(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 bcESjD'])[4]"));
    }
    public static WebElement PlinkoGameFairnessVerifyBet(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='Verify Bet']"));
    }
    public static WebElement PlinkoGameFairnessGameTab(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomDropdown__DropDownButton-sc-1hmifsq-2 gBAQOB'])[1]"));
    }
    public static WebElement PlinkoGameFairnessRiskTab(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomDropdown__DropDownButton-sc-1hmifsq-2 gBAQOB'])[2]"));
    }
    public static WebElement PlinkoGameFairnessRowsTab(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='CustomDropdown__DropDownButton-sc-1hmifsq-2 gBAQOB'])[3]"));
    }
    public static WebElement PlinkoGameErrorMessage(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='Tooltip__TooltipMessage-sc-lnycwz-2 bymWBZ']"));
    }
    
    }