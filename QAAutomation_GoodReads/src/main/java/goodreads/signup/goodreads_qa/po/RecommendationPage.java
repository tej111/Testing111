package goodreads.signup.goodreads_qa.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class RecommendationPage extends BasePage {
	@FindBy(xpath = "//div[contains(text(),'Done here')]")
	private WebElement recommendationDone;
	private WebDriver driver;

	public RecommendationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage completeRegistration() {
		recommendationDone.click();
		Reporter.log("<br>clickRecommendationDone", true);
		Reporter.log("<br>completeRegistration", true);
		return new HomePage(driver);
	}
}
