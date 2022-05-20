package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiceGamePage {
	public WebDriver driver;

	public static WebElement element;

	public DiceGamePage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement diceLink(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='GameCard__WrapperGame-sc-g0x5h9-0 JmqfD'])[1]"));
	}
	
	public static WebElement BetAmountinputField(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty'])[1]"));
	}

	public static WebElement BetButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='BET']"));
	}

	public static WebElement LatestResultDiceGame(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='PastBetButton__PastBetButtonWrapper-sc-pe28g7-0 eZgSmF']"));
	}

	public static WebElement DiceGameSettingICon(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[1]"));
	}

	public static WebElement DiceGameRulesICon(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[2]"));
	}

	public static WebElement DiceGameLiveStatusIcon(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[3]"));
	}

	public static WebElement DiceGameFairnessIcon(WebDriver driver) {
		return driver.findElement(
				By.xpath("(//*[@class='SidebarFooterCommands__CommandButtonContent-sc-gpcbvp-5 jALDpb'])[4]"));
	}

	public static WebElement DiceGameRulesCrossIcon(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='ModalMain__CloserBtn-sc-1xo7njg-0 dzSqMA']"));
	}

	public static WebElement DiceGameAutoButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='DiceSidebar__BettingVariantButton-sc-4stjuu-4 jwgUng']"));
	}

	public static WebElement MyBets(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='MY BETS']"));
	}

	public static WebElement MyBetsLatestDice(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[text()='Dice'])[2]"));
	}

	public static WebElement BetPopup(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='BetModalFooter__LinkButton-sc-1gg3f6s-2 hIwqGL']"));
	}
	public static WebElement FAIRNESSChangeButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[text()='CHANGE']"));
	}

	public static WebElement FAIRNESSActiveserverseed(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 bcESjD'])[2]"));
	}

	public static WebElement FAIRNESSNextserverseed(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='CustomInput__MainInput-sc-1o4ngjx-6 bcESjD'])[4]"));
	}

	public static WebElement HalfAmount(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='DiceSidebar__InputButtonV1-sc-4stjuu-6 ldmzTz'])[1]"));
	}

	public static WebElement DoubleAmount(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='DiceSidebar__InputButtonV1-sc-4stjuu-6 ldmzTz'])[2]"));
	}

	public static WebElement ProfitOnWinInputBox(WebDriver driver) {
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty'])[2]"));
	}

	public static WebElement MaxButton(WebDriver driver) {
		return driver.findElement(By.xpath("//*[@class='LabelInput__LabelContent-sc-zkip7h-2 ECQgB']/span[2]"));
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
		return driver.findElement(By.xpath("(//*[@class='LabelInput__MainInput-sc-zkip7h-6 jZgjty'])[2]"));
	}
}
