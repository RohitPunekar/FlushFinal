package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WheelGamePage {
	
	public WebDriver driver;
	
	public static WebElement element;
	
	public WheelGamePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public static WebElement WheelLink(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='GameCard__WrapperGame-sc-g0x5h9-0 JmqfD'])[4]"));
	}
	
	public static WebElement BetAmountinputField(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty'])[1]"));
	}
	
	public static WebElement RiskDropdown(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='CustomDropdown__ButtonContent-sc-1hmifsq-4 LTFnp'])[1]"));
	}
	
	public static WebElement LowRisk(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Low']"));
	}
	
	public static WebElement MediumRisk(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Medium']"));
	}
	
	public static WebElement HighRisk(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='High']"));
	}
	
	public static WebElement SegmentsDropdown(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='CustomDropdown__DropDownButton-sc-1hmifsq-2 gBAQOB'])[2]"));
	}
	
	public static WebElement Segment10(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='10']"));
	}
	
	public static WebElement Segment20(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='20']"));
	}
	
	public static WebElement Segment30(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='30']"));
	}
	
	public static WebElement Segment40(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='40']"));
	}
	
	public static WebElement Segment50(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='50']"));
	}
	

	public static WebElement BetButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='BET']"));
	}

	public static WebElement LatestResultWheelGame(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='PastBetButton__PastBetButtonWrapper-sc-pe28g7-0 joejdF']"));
	}
			
	public static WebElement WheelGameSettingICon(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[1]"));
	}
	
	public static WebElement WheelGameRulesICon(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[2]"));
	}

	public static WebElement WheelGameLiveStatusIcon(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[3]"));
	}

	public static WebElement WheelGameFairnessIcon(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[4]"));
	}
	
	public static WebElement WheelGameRulesCrossIcon(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='ModalMain__CloserBtn-sc-1xo7njg-0 icXoLY']"));
	}
	
	public static WebElement WheelGameAutoButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='WheelSidebar__BettingVariantButton-sc-1rlsfe2-5 gljdrJ']"));
	}
	
	public static WebElement MyBetsLatestWheel(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[text()='Wheel'])[2]"));
	}
	
	public static WebElement MyBets(WebDriver driver)
    {
        return driver.findElement(By.xpath("//*[text()='MY BETS']"));
    }
	
	public static WebElement PayoutWheelGame(WebDriver driver)
    {
        return driver.findElement(By.xpath("(//*[@class='StatsBlock__StatsWrapper-sc-1f7v5gl-0 eCLRg']//tbody//tr[1]//td[5])[1]"));
    }
	
	public static WebElement BetPopup(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='You must rotate your seed pair in order to verify this bet']"));
	}

	public static WebElement FAIRNESSChangeButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='CHANGE']"));
	}

	public static WebElement FAIRNESSActiveserverseed(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 cKzgzb'])[2]"));
	}

	public static WebElement FAIRNESSNextserverseed(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 cKzgzb'])[4]"));
	}

	public static WebElement HalfAmount(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='WheelSidebar__InputButtonV1-sc-1rlsfe2-7 dDdbIi'])[1]"));
	}

	public static WebElement DoubleAmount(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='WheelSidebar__InputButtonV1-sc-1rlsfe2-7 dDdbIi'])[1]"));
	}

	public static WebElement ProfitOnWinInputBox(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jMmTxe'])[2]"));
	}

	public static WebElement MaxButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='(Max - ']"));
	}

	public static WebElement InsufficientErrorMessage(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='Snackbar__MessagwWrapper-sc-g1jq3j-3 kXhAsS']"));
	}

	public static WebElement AutoStartButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='START AUTOBET']"));
	}

	public static WebElement StopAutoBettButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='STOP AUTOBET']"));
	}

	public static WebElement NoOfBETSButton(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='LabelInput__InnerContent-sc-zkip7h-5 lhNgjS']/input)[2]"));
	}
}
