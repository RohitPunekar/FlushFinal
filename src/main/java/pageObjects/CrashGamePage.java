package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CrashGamePage {
	public WebDriver driver;

	public static WebElement element;

	public CrashGamePage(WebDriver driver)
	{
		this.driver=driver;
	}


	public static WebElement CrashGameIcon(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='Crash']"));
	}
	
	public static WebElement CrashGameResult2(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='PastBetButton__PastBetButtonWrapper-sc-pe28g7-0 kvIaXc']"));
	}
	
	public static WebElement CrashGameResult1(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='PastBetButton__PastBetButtonWrapper-sc-pe28g7-0 eZgSmF']"));
	}
	
	public static WebElement CashOutDropdown(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty'])[2]"));
	}
	
	public static WebElement CrashLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='GameCard__WrapperGame-sc-g0x5h9-0 JmqfD'])[2]"));
	}

	public static WebElement BetAmountinputField(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty'])[1]"));
	}

	public static WebElement BetBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='BET']"));
	}

	public static WebElement BetNextRoundBtn(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='BET (NEXT ROUND)']"));
	}

	public static WebElement CrashGameBetMaxAmount(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='LabelInput__LabelContent-sc-zkip7h-2 dlabUp'])[1]"));
	}		

	public static WebElement CrashGameMaxBalanceError(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='Tooltip__TooltipMessage-sc-lnycwz-2 bymWBZ']"));
	}

	public static WebElement BetAmount(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='LabelInput__MainInput-sc-zkip7h-6 jMmTxe']"));
	}


	public static WebElement HalfxButton(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='GameSidebar__InputButtonV1-sc-a55da3-6 fgSnAU'][1]"));
	}

	public static WebElement DoublexButton(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='GameSidebar__InputButtonV1-sc-a55da3-6 fgSnAU'][2]"));
	}

	public static WebElement CrashGameSettingICon(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[1]"));
	}

	public static WebElement CrashGameRulesIcon(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[2]"));
	}		

	public static WebElement CrashGameLiveStatusIcon(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[3]"));
	}

	public static WebElement CrashGameFairnessIcon(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[4]"));
	}

	public static WebElement Manual(WebDriver driver) {
		return driver.findElement(
				By.xpath("//*[text()='MANUAL']"));
	}

	public static WebElement BetAmountInpField(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty'])[1]"));
	}

	public static WebElement MyBets(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='MY BETS']"));
	}

	public static WebElement PayoutCrashGame(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='StatsBlock__StatsWrapper-sc-1f7v5gl-0 eCLRg']//tbody//tr[1]//td[5])[1]"));
	}

	public static WebElement AutoButton(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='AUTO']"));
	}
	public static WebElement AutoNoOfBets(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty'])[2]"));
	}
	public static WebElement AutoCashOutAt(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jMmTxe'])[3]"));
	}
	public static WebElement Reset(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[text()='RESET'])[1]"));
	}
	public static WebElement IncreaseBy(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[text()='INCREASE BY'])[1]"));
	}
	public static WebElement ResetValue(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jMmTxe'])[4]"));
	}

	public static WebElement ResetOnLoss(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[text()='RESET'])[2]"));
	}

	public static WebElement IncreaseByOnLoss(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[text()='INCREASE BY'])[2]"));
	}
	public static WebElement ResetValueOnLoss (WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jMmTxe'])[5]"));
	}

	public static WebElement StopOnProfit (WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jMmTxe'])[6]"));
	}
	public static WebElement StopOnLoss (WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jMmTxe'])[7]"));
	}
	public static WebElement StartAutoBet (WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='START AUTOBET']"));
	}


}
