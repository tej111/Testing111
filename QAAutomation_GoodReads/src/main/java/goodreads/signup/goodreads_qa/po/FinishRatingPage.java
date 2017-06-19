package goodreads.signup.goodreads_qa.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FinishRatingPage extends BasePage {
	@FindBy(xpath = "//a[@class='actionLink']")
	private WebElement finishRating;
	private WebDriver driver;

	public FinishRatingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RecommendationPage finishRating() {
		finishRating.click();
		Reporter.log("<br>finishRating", true);
		return new RecommendationPage(driver);
	}

}
