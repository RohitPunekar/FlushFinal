package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePopup {
	public WebDriver driver;

	public WelcomePopup(WebDriver driver) 
	{
		this.driver=driver;
	}

	public static WebElement Welcomeemail(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@placeholder='Email Or Username']"));
	}

	public static WebElement Welcomepassword(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@placeholder='Password']"));
	}

	public static WebElement Welcomeplaynow(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Play Now']"));
	}

	public static WebElement RecoveryEmailInputbox(WebDriver driver)
	{
		return driver.findElement(By.name("email"));
	}


	public static WebElement PasswordRecoverySendButton(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Send']"));
	}


	public static WebElement PasswordRequestSentToEmailText(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='ForgetPasswordForm__InputResponse-sc-mp04uo-3 XSXKb']"));
	}


	public static WebElement Loginbutton(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='LOG IN']"));
	}


	public static WebElement Registration(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Register']"));
	}

	public static WebElement WelcomeForgotPassword(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Forgot Password']"));
	}

	public static WebElement PasswordRecoveryBackToLogin(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Back to login']"));
	}

	public static WebElement RegisterUserName(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@placeholder='Username']"));
	}

	public static WebElement RegisterEmailid(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@placeholder='Email id']"));
	}

	public static WebElement RegisterPassword(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@placeholder='Choose Password']"));
	}

	public static WebElement TermsAndConditionsCheckbox(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='CustomCheckbox__StyledCheckbox-sc-l1ttnj-0 bLgrmf']"));
	}

	public static WebElement PlayNowbutton(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Play Now']"));
	}

	public static WebElement WelcomeGoogleIcon(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='CustomButton-sc-1np6xc3-0 uVZxN']"));
	}

	public static WebElement GmailEmail(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@autocomplete='username']"));
	}

	public static WebElement EmailNext(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Next']"));
	}

	public static WebElement GmailPassword(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@autocomplete='current-password']"));
	}

	public static WebElement PasswordNext(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Next']"));
	}

	public static WebElement Userdropdown(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[@class='UserDropdownMenu__Wrapp-sc-qt4bc8-1 bRRUeZ']/button"));
	}
	public static WebElement Logout(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Logout']"));
	}
	public static WebElement Signup(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='SIGN UP']"));
	}
	public static WebElement Login(WebDriver driver)
	{
		return driver.findElement(By.xpath("//*[text()='Login']"));
	}
	public static WebElement Google(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='HomeRegister__LoginBtn-sc-1w145hg-5 jmrNOX'])[1]"));
	}
	public static WebElement Joinemail(WebDriver driver)
	{
		return driver.findElement(By.xpath("(//*[@class='HomeRegister__EmailBtn-sc-1w145hg-6 kJonu'])[1]"));
	}
}
