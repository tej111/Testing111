package goodreads.signup.goodreads_qa.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SignInPage extends BasePage {
	private WebDriver driver;
	@FindBy(id = "user_email")
	private WebElement eMail;

	@FindBy(id = "user_password")
	private WebElement passWord;

	@FindBy(name = "next")
	private WebElement next;

	@FindBy(xpath = "//p[contains(@class,'flash error')]")
	private WebElement flashMsg;

	public SignInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String email, String password) {
		eMail.sendKeys(email);
		passWord.sendKeys(password);
		next.click();
		Reporter.log("<br>login::" + email + " " + password, true);
	}

	public String getErrorMsg() {
		Reporter.log("<br>getErrorMsg::" + flashMsg.getText(), true);
		return flashMsg.getText();
	}
}
