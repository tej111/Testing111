package goodreads.signup.goodreads_qa.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LogOutPage extends BasePage {
	private WebDriver driver;
	@FindBy(xpath = "//a[text()='Sign in again']")
	private WebElement signInAgain;

	public LogOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SignInPage signInAgain() {
		signInAgain.click();
		Reporter.log("<br>signInAgain", true);
		return new SignInPage(driver);
	}
}
