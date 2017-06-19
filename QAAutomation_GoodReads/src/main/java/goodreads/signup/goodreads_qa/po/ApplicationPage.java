
package goodreads.signup.goodreads_qa.po;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ApplicationPage extends BasePage {

	private WebDriver driver;

	@FindBy(id = "user_first_name")
	private WebElement signUp_UserName;

	@FindBy(id = "user_email")
	private WebElement signUp_Email;

	@FindBy(id = "user_password_signup")
	private WebElement signUp_Password;

	@FindBy(name = "next")
	private WebElement signUp;

	public ApplicationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SetReadingpage signUpWithData(Map<String, Object> data) {
		enterName(data.get("userName").toString());
		enterEmail(data.get("email").toString());
		enterPassword(data.get("password").toString());
		signUp.click();
		Reporter.log("<br>clickSignUp", true);
		return new SetReadingpage(driver);
	}

	private void enterPassword(String str) {
		signUp_Password.sendKeys(str);
		Reporter.log("<br>enterPassword::" + str, true);
	}

	private void enterEmail(String str) {
		signUp_Email.sendKeys(str);
		Reporter.log("<br>enterEmail::" + str, true);
	}

	private void enterName(String str) {
		signUp_UserName.sendKeys(str);
		Reporter.log("<br>enterName::" + str, true);
	}

}
