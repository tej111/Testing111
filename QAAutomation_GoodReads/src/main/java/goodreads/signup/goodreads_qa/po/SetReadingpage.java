package goodreads.signup.goodreads_qa.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SetReadingpage extends BasePage {
	@FindBy(id = "user_challenge_goal")
	private WebElement setGoals;

	@FindBy(xpath = "//p[@class='submitButtons']/button")
	private WebElement takeChallenge;

	private WebDriver driver;

	public SetReadingpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SelectGeneres setChallenge(String goal) {
		setGoals(goal);
		takeChallenge.click();
		Reporter.log("<br>setChallenge", true);
		return new SelectGeneres(driver);

	}

	private void setGoals(String goal) {
		setGoals.sendKeys("2");
		Reporter.log("<br>setGoals::" + goal, true);
	}
}
