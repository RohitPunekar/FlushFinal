package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class VIPPage {
    
    
    
    public static WebElement DropdownVipLink(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='UserDropdownMenu__DropdownItem-sc-qt4bc8-5 iLdCch'])[2]"));
    } 
    public static WebElement Loyalitytext(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='Loyality']"));
    } 
    
    public static WebElement ClaimFreeSpin(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='CLAIM FREE SPIN']"));
    } 
    
    public static WebElement Claim(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='CLAIM']"));
    } 
    
    public static WebElement ClaimedRewardstab(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='CLAIMED REWARDS']"));
        
    } 
    
    public static WebElement Rewards(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='REWARDS']"));
    } 
    
    public static WebElement ClaimRewardsChooseYourRewardCancelbutton(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='CANCEL']"));
    } 
    
    
    
    public static WebElement ClaimRewardsFirstButton(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='Rewards__LastDiv-sc-gl9zn9-6 gVShHA']"));
    } 
    
    
            
            public static WebElement FirstRadioButtonName(WebDriver driver)
            {
                return driver.findElement(By.xpath("(//*[@class='VipChooseReward__MiddleTitle-sc-bwdl93-10 gatrzt'])[1]"));
            } 
            
            public static WebElement SecondRadioButtonName(WebDriver driver)
            {
                return driver.findElement(By.xpath("(//*[@class='VipChooseReward__MiddleTitle-sc-bwdl93-10 gatrzt'])[2]"));
            } 
            
            public static WebElement ThirdRadioButtonName(WebDriver driver)
            {
                return driver.findElement(By.xpath("(//*[@class='VipChooseReward__MiddleTitle-sc-bwdl93-10 gatrzt'])[3]"));
            } 
    
            public static WebElement FouthRadioButtonName(WebDriver driver)
            {
                return driver.findElement(By.xpath("(//*[@class='VipChooseReward__MiddleTitle-sc-bwdl93-10 gatrzt'])[4]"));
            } 
            
            
                    
                    public static WebElement Slotstab(WebDriver driver)
                    {
                        return driver.findElement(By.xpath("(//*[@class='Header__ButtonWrapper-sc-15su922-9 kZGQHP'])[3]"));
                    } 
                    
                    
                    
                    public static WebElement Slotssearch(WebDriver driver)
                    {
                        return driver.findElement(By.xpath("//*[@placeholder='Search']"));
                    } 
                    
                    public static WebElement RewardPoints(WebDriver driver)
                    {
                        return driver.findElement(By.xpath("(//*[@class='Rewards__ProgressStatus-sc-gl9zn9-5 fbeDBz'])[1]"));
                    } 
                    
                            
                            public static WebElement SlotssearchFirstgame(WebDriver driver)
                            {
                                return driver.findElement(By.xpath("(//*[@class='GameCard__GameInfoLine1-sc-1djvmxe-7 cCcRwd'])[1]"));
                            } 
                            
                            
                            
                            public static WebElement SlotsGameRealPlay(WebDriver driver)
                            {
                                return driver.findElement(By.xpath("//*[@class='Main__CustomButton-sc-crg8l9-20 jPQouI']"));
                            } 
    
    public static WebElement ClaimRewardsChooseYourRewardClaimSelectedRewards(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()=' CLAIM SELECTED REWARD']"));
    } 
    
    public static WebElement TotalPointsSection(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='Header__HeadEl2-sc-jdyd2k-3 zhmkJ'])[2]"));
    } 
    
    public static WebElement ClaimRewardsChooseYourRewardFirstRadio(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='VipChooseReward__Middle-sc-bwdl93-9 cDqMZX'])[1]"));
    } 
    public static WebElement ClaimRewardsChooseYourRewardSecondRadio(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='VipChooseReward__Middle-sc-bwdl93-9 cDqMZX'])[2]"));
    } 
    public static WebElement ClaimRewardsChooseYourRewardThirdRadio(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='VipChooseReward__Middle-sc-bwdl93-9 cDqMZX'])[3]"));
    } 
    public static WebElement ClaimRewardsChooseYourRewardFourthRadio(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='VipChooseReward__Middle-sc-bwdl93-9 cDqMZX'])[4]"));
    } 
    
    public static WebElement RewardsPopupCloseIcon(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='VipChooseReward__CrossButton-sc-bwdl93-13 jIOIcS']"));
    } 
    public static WebElement DashboardSearchGameGladiator(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='Gladiator']"));
    } 
    
    public static WebElement GameFrame(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[@class='egamings_game_frame']"));
    } 
    
    
    
}