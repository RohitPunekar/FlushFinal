package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class WalletModule
{
    
        public WebDriver driver;
        public static WebElement element;
        
        public WalletModule(WebDriver driver) 
        {
            this.driver=driver;
        }
        public static WebElement WalletIcon(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='WALLET']"));
        }
        public static WebElement Deposit(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='Deposit']"));
        }
        public static WebElement DepositCurrency(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[@class='CustomDropdown__DropDownButton-sc-1hmifsq-2 pjSfg']"));
        }
        public static WebElement DepositCurrencyBTC(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='BTC']"));
        }
        public static WebElement DepositDOGE(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='DOGE']"));
        }
        public static WebElement DepositETH(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='ETH']"));
        }
        public static WebElement DepositMATIC(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='MATIC']"));
        }
        public static WebElement DepositBNB(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='BNB']"));
        }
        public static WebElement DepositLTC(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='LTC']"));
        }
        public static WebElement DepositCurrencyAddress(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 bcESjD']"));
        }
        public static WebElement Withdraw (WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='Withdraw']"));
        }
        public static WebElement YourBalance(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[@class='CustomDropdown__DropDownButton-sc-1hmifsq-2 pjSfg']"));
        }
        public static WebElement WithdrawalAddress (WebDriver driver)
        {
            return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 glARGZ'])[1]"));
        }
        public static WebElement WithdrawAmount (WebDriver driver)
        {
            return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 glARGZ'])[2]"));
        }
        public static WebElement WithdrawAmountButton(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='WITHDRAW AMOUNT']"));
        }
        public static WebElement WithdrawmaxButton(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[text()='Max']"));
        }
        public static WebElement WithdrawMinAmount(WebDriver driver)
        {
            return driver.findElement(By.xpath("(//*[@class='CustomInput__LabelContent-sc-1o4ngjx-2 fXmpsl'])[2]"));
        }
        public static WebElement WithdrawSuccessMessage(WebDriver driver)
        {
            return driver.findElement(By.xpath("//*[@class='Snackbar__MessagwWrapper-sc-g1jq3j-3 kXhAsS']"));
        }
        
        //*[@class='Snackbar__MessagwWrapper-sc-g1jq3j-3 kXhAsS']
}